package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.internal.RegexCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class AsYouTypeFormatter {
    private static final Pattern DIGIT_PATTERN = null;
    private static final String DIGIT_PLACEHOLDER = "\u2008";
    private static final Pattern ELIGIBLE_FORMAT_PATTERN = null;
    private static final Phonemetadata.PhoneMetadata EMPTY_METADATA = null;
    private static final int MIN_LEADING_DIGITS_LENGTH = 3;
    private static final Pattern NATIONAL_PREFIX_SEPARATORS_PATTERN = null;
    private static final char SEPARATOR_BEFORE_NATIONAL_NUMBER = ' ';
    private boolean ableToFormat;
    private StringBuilder accruedInput;
    private StringBuilder accruedInputWithoutFormatting;
    private String currentFormattingPattern;
    private Phonemetadata.PhoneMetadata currentMetadata;
    private String currentOutput;
    private String defaultCountry;
    private Phonemetadata.PhoneMetadata defaultMetadata;
    private String extractedNationalPrefix;
    private StringBuilder formattingTemplate;
    private boolean inputHasFormatting;
    private boolean isCompleteNumber;
    private boolean isExpectingCountryCallingCode;
    private int lastMatchPosition;
    private StringBuilder nationalNumber;
    private int originalPosition;
    private final PhoneNumberUtil phoneUtil;
    private int positionToRemember;
    private List<Phonemetadata.NumberFormat> possibleFormats;
    private StringBuilder prefixBeforeNationalNumber;
    private RegexCache regexCache;
    private boolean shouldAddSpaceAfterNationalPrefix;

    static {
        EMPTY_METADATA = new Phonemetadata.PhoneMetadata().setInternationalPrefix("NA");
        ELIGIBLE_FORMAT_PATTERN = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]*(\\$\\d[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]*)+");
        NATIONAL_PREFIX_SEPARATORS_PATTERN = Pattern.compile("[- ]");
        DIGIT_PATTERN = Pattern.compile(DIGIT_PLACEHOLDER);
    }

    AsYouTypeFormatter(String r4) {
        this.currentOutput = "";
        this.formattingTemplate = new StringBuilder();
        this.currentFormattingPattern = "";
        this.accruedInput = new StringBuilder();
        this.accruedInputWithoutFormatting = new StringBuilder();
        this.ableToFormat = true;
        this.inputHasFormatting = false;
        this.isCompleteNumber = false;
        this.isExpectingCountryCallingCode = false;
        this.phoneUtil = PhoneNumberUtil.getInstance();
        this.lastMatchPosition = 0;
        this.originalPosition = 0;
        this.positionToRemember = 0;
        this.prefixBeforeNationalNumber = new StringBuilder();
        this.shouldAddSpaceAfterNationalPrefix = false;
        this.extractedNationalPrefix = "";
        this.nationalNumber = new StringBuilder();
        this.possibleFormats = new ArrayList();
        this.regexCache = new RegexCache(64);
        this.defaultCountry = r4;
        Phonemetadata.PhoneMetadata r5 = getMetadataForRegion(r4);
        this.currentMetadata = r5;
        this.defaultMetadata = r5;
    }

    private Phonemetadata.PhoneMetadata getMetadataForRegion(String r2) {
        int r3 = this.phoneUtil.getCountryCodeForRegion(r2);
        String r4 = this.phoneUtil.getRegionCodeForCountryCode(r3);
        Phonemetadata.PhoneMetadata r1 = this.phoneUtil.getMetadataForRegion(r4);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return EMPTY_METADATA;
    }

    private boolean maybeCreateNewTemplate() {
        Iterator<Phonemetadata.NumberFormat> r0 = this.possibleFormats.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Phonemetadata.NumberFormat r1 = r0.next();
        String r3 = r1.getPattern();
        if (this.currentFormattingPattern.equals(r3) == true) goto L7;
        if (createFormattingTemplate(r1) == true) goto L10;
        r0.remove();
        goto L4
    L10:
        this.currentFormattingPattern = r3;
        this.shouldAddSpaceAfterNationalPrefix = NATIONAL_PREFIX_SEPARATORS_PATTERN.matcher(r1.getNationalPrefixFormattingRule()).find();
        this.lastMatchPosition = 0;
        return true;
    L7:
        return false;
    L13:
        this.ableToFormat = false;
        return false;
    }

    private void getAvailableFormats(String r5) {
        if (this.isCompleteNumber == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
    L12:
        List<Phonemetadata.NumberFormat> r1 = this.currentMetadata.numberFormats();
    L13:
        Iterator<Phonemetadata.NumberFormat> r2 = r1.iterator();
    L15:
        if (r2.hasNext() == false) goto L37;
        Phonemetadata.NumberFormat r3 = r2.next();
        if (this.extractedNationalPrefix.length() <= 0) goto L26;
        if (PhoneNumberUtil.formattingRuleHasFirstGroupOnly(r3.getNationalPrefixFormattingRule()) == false) goto L26;
        if (r3.getNationalPrefixOptionalWhenFormatting() == true) goto L26;
        if (r3.hasDomesticCarrierCodeFormattingRule() == false) goto L15;
    L26:
        if (this.extractedNationalPrefix.length() != 0) goto L35;
        if (this.isCompleteNumber == true) goto L35;
        if (PhoneNumberUtil.formattingRuleHasFirstGroupOnly(r3.getNationalPrefixFormattingRule()) == true) goto L35;
        if (r3.getNationalPrefixOptionalWhenFormatting() == false) goto L15;
    L35:
        if (ELIGIBLE_FORMAT_PATTERN.matcher(r3.getFormat()).matches() == false) goto L15;
        this.possibleFormats.add(r3);
        goto L15
    L37:
        narrowDownPossibleFormats(r5);
        return;
    L10:
        if (this.currentMetadata.intlNumberFormatSize() <= 0) goto L12;
        r1 = this.currentMetadata.intlNumberFormats();
        goto L13
    L5:
        if (this.extractedNationalPrefix.length() != 0) goto L7;
        r0 = true;
        goto L8
    }

    private void narrowDownPossibleFormats(String r6) {
        int r0 = r6.length() - 3;
        Iterator<Phonemetadata.NumberFormat> r1 = this.possibleFormats.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Phonemetadata.NumberFormat r2 = r1.next();
        if (r2.leadingDigitsPatternSize() == 0) goto L4;
        if (this.regexCache.getPatternForRegex(r2.getLeadingDigitsPattern(Math.min(r0, r2.leadingDigitsPatternSize() - 1))).matcher(r6).lookingAt() == true) goto L4;
        r1.remove();
        goto L4
    }

    private boolean createFormattingTemplate(Phonemetadata.NumberFormat r4) {
        String r0 = r4.getPattern();
        this.formattingTemplate.setLength(0);
        String r5 = getFormattingTemplate(r0, r4.getFormat());
        if (r5.length() <= 0) goto L6;
        this.formattingTemplate.append(r5);
        return true;
    L6:
        return false;
    }

    private String getFormattingTemplate(String r3, String r4) {
        Matcher r0 = this.regexCache.getPatternForRegex(r3).matcher("999999999999999");
        r0.find();
        String r1 = r0.group();
        if (r1.length() >= this.nationalNumber.length()) goto L7;
        return "";
    L7:
        return r1.replaceAll(r3, r4).replaceAll("9", DIGIT_PLACEHOLDER);
    }

    public void clear() {
        this.currentOutput = "";
        this.accruedInput.setLength(0);
        this.accruedInputWithoutFormatting.setLength(0);
        this.formattingTemplate.setLength(0);
        this.lastMatchPosition = 0;
        this.currentFormattingPattern = "";
        this.prefixBeforeNationalNumber.setLength(0);
        this.extractedNationalPrefix = "";
        this.nationalNumber.setLength(0);
        this.ableToFormat = true;
        this.inputHasFormatting = false;
        this.positionToRemember = 0;
        this.originalPosition = 0;
        this.isCompleteNumber = false;
        this.isExpectingCountryCallingCode = false;
        this.possibleFormats.clear();
        this.shouldAddSpaceAfterNationalPrefix = false;
        if (this.currentMetadata.equals(this.defaultMetadata) == true) goto L6;
        this.currentMetadata = getMetadataForRegion(this.defaultCountry);
        return;
    }

    public String inputDigit(char r2) {
        String r3 = inputDigitWithOptionToRememberPosition(r2, false);
        this.currentOutput = r3;
        return r3;
    }

    public String inputDigitAndRememberPosition(char r2) {
        String r3 = inputDigitWithOptionToRememberPosition(r2, true);
        this.currentOutput = r3;
        return r3;
    }

    private String inputDigitWithOptionToRememberPosition(char r4, boolean r5) {
        this.accruedInput.append(r4);
        if (r5 == false) goto L6;
        this.originalPosition = this.accruedInput.length();
    L6:
        if (isDigitOrLeadingPlusSign(r4) == true) goto L8;
        this.ableToFormat = false;
        this.inputHasFormatting = true;
    L10:
        if (this.ableToFormat == false) goto L12;
        int r6 = this.accruedInputWithoutFormatting.length();
        if (r6 == 0) goto L64;
        if (r6 == 1) goto L64;
        if (r6 == 2) goto L64;
        if (r6 != 3) goto L39;
        if (attemptToExtractIdd() == false) goto L61;
        this.isExpectingCountryCallingCode = true;
        goto L39
    L61:
        this.extractedNationalPrefix = removeNationalPrefixFromNationalNumber();
        return attemptToChooseFormattingPattern();
    L39:
        if (this.isExpectingCountryCallingCode == false) goto L46;
        if (attemptToExtractCountryCallingCode() == false) goto L44;
        this.isExpectingCountryCallingCode = false;
    L44:
        return this.prefixBeforeNationalNumber + this.nationalNumber.toString();
    L46:
        if (this.possibleFormats.size() <= 0) goto L60;
        String r7 = inputDigitHelper(r4);
        String r8 = attemptToFormatAccruedDigits();
        if (r8.length() <= 0) goto L50;
        return r8;
    L50:
        narrowDownPossibleFormats(this.nationalNumber.toString());
        if (maybeCreateNewTemplate() == false) goto L55;
        return inputAccruedNationalNumber();
    L55:
        if (this.ableToFormat == false) goto L58;
        return appendNationalNumber(r7);
    L58:
        return this.accruedInput.toString();
    L60:
        return attemptToChooseFormattingPattern();
    L64:
        return this.accruedInput.toString();
    L12:
        if (this.inputHasFormatting == false) goto L16;
        return this.accruedInput.toString();
    L16:
        if (attemptToExtractIdd() == false) goto L22;
        if (attemptToExtractCountryCallingCode() == false) goto L26;
        return attemptToChoosePatternWithPrefixExtracted();
    L26:
        return this.accruedInput.toString();
    L22:
        if (ableToExtractLongerNdd() == false) goto L26;
        this.prefixBeforeNationalNumber.append(SEPARATOR_BEFORE_NATIONAL_NUMBER);
        return attemptToChoosePatternWithPrefixExtracted();
    L8:
        r4 = normalizeAndAccrueDigitsAndPlusSign(r4, r5);
        goto L10
    }

    private String attemptToChoosePatternWithPrefixExtracted() {
        this.ableToFormat = true;
        this.isExpectingCountryCallingCode = false;
        this.possibleFormats.clear();
        this.lastMatchPosition = 0;
        this.formattingTemplate.setLength(0);
        this.currentFormattingPattern = "";
        return attemptToChooseFormattingPattern();
    }

    String getExtractedNationalPrefix() {
        return this.extractedNationalPrefix;
    }

    private boolean ableToExtractLongerNdd() {
        if (this.extractedNationalPrefix.length() <= 0) goto L6;
        this.nationalNumber.insert(0, this.extractedNationalPrefix);
        this.prefixBeforeNationalNumber.setLength(this.prefixBeforeNationalNumber.lastIndexOf(this.extractedNationalPrefix));
    L6:
        return !this.extractedNationalPrefix.equals(removeNationalPrefixFromNationalNumber());
    }

    private boolean isDigitOrLeadingPlusSign(char r3) {
        if (Character.isDigit(r3) == false) goto L5;
        return true;
    L5:
        if (this.accruedInput.length() == 1) goto L7;
    L9:
        return false;
    L7:
        if (PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(Character.toString(r3)).matches() == false) goto L9;
        return true;
    }

    String attemptToFormatAccruedDigits() {
        Iterator<Phonemetadata.NumberFormat> r0 = this.possibleFormats.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Phonemetadata.NumberFormat r1 = r0.next();
        Matcher r2 = this.regexCache.getPatternForRegex(r1.getPattern()).matcher(this.nationalNumber);
        if (r2.matches() == false) goto L4;
        this.shouldAddSpaceAfterNationalPrefix = NATIONAL_PREFIX_SEPARATORS_PATTERN.matcher(r1.getNationalPrefixFormattingRule()).find();
        return appendNationalNumber(r2.replaceAll(r1.getFormat()));
    L9:
        return "";
    }

    public int getRememberedPosition() {
        if (this.ableToFormat == false) goto L5;
        int r0 = 0;
        int r1 = 0;
    L8:
        if (r0 >= this.positionToRemember) goto L15;
        if (r1 >= this.currentOutput.length()) goto L15;
        if (this.accruedInputWithoutFormatting.charAt(r0) != this.currentOutput.charAt(r1)) goto L14;
        r0 = r0 + 1;
    L14:
        r1 = r1 + 1;
    L15:
        return r1;
    L5:
        return this.originalPosition;
    }

    private String appendNationalNumber(String r4) {
        int r0 = this.prefixBeforeNationalNumber.length();
        if (this.shouldAddSpaceAfterNationalPrefix == false) goto L10;
        if (r0 <= 0) goto L10;
        if (this.prefixBeforeNationalNumber.charAt(r0 - 1) == ' ') goto L10;
        return new String(this.prefixBeforeNationalNumber) + SEPARATOR_BEFORE_NATIONAL_NUMBER + r4;
    L10:
        return this.prefixBeforeNationalNumber + r4;
    }

    private String attemptToChooseFormattingPattern() {
        if (this.nationalNumber.length() < 3) goto L13;
        getAvailableFormats(this.nationalNumber.toString());
        String r0 = attemptToFormatAccruedDigits();
        if (r0.length() <= 0) goto L8;
        return r0;
    L8:
        if (maybeCreateNewTemplate() == false) goto L11;
        return inputAccruedNationalNumber();
    L11:
        return this.accruedInput.toString();
    L13:
        return appendNationalNumber(this.nationalNumber.toString());
    }

    private String inputAccruedNationalNumber() {
        int r0 = this.nationalNumber.length();
        if (r0 <= 0) goto L13;
        String r1 = "";
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L8;
        r1 = inputDigitHelper(this.nationalNumber.charAt(r2));
        r2 = r2 + 1;
        goto L5
    L8:
        if (this.ableToFormat == false) goto L11;
        return appendNationalNumber(r1);
    L11:
        return this.accruedInput.toString();
    L13:
        return this.prefixBeforeNationalNumber.toString();
    }

    private boolean isNanpaNumberWithNationalPrefix() {
        if (this.currentMetadata.getCountryCode() == 1) goto L5;
        return false;
    L5:
        if (this.nationalNumber.charAt(0) == '1') goto L7;
        return false;
    L7:
        if (this.nationalNumber.charAt(1) != '0') goto L9;
        return false;
    L9:
        if (this.nationalNumber.charAt(1) != '1') goto L11;
        return false;
    L11:
        return true;
    }

    private String removeNationalPrefixFromNationalNumber() {
        int r1 = 1;
        if (isNanpaNumberWithNationalPrefix() == false) goto L6;
        this.prefixBeforeNationalNumber.append('1').append(SEPARATOR_BEFORE_NATIONAL_NUMBER);
        this.isCompleteNumber = true;
    L13:
        String r0 = this.nationalNumber.substring(0, r1);
        this.nationalNumber.delete(0, r1);
        return r0;
    L6:
        if (this.currentMetadata.hasNationalPrefixForParsing() == false) goto L12;
        Matcher r2 = this.regexCache.getPatternForRegex(this.currentMetadata.getNationalPrefixForParsing()).matcher(this.nationalNumber);
        if (r2.lookingAt() == false) goto L12;
        if (r2.end() <= 0) goto L12;
        this.isCompleteNumber = true;
        r1 = r2.end();
        this.prefixBeforeNationalNumber.append(this.nationalNumber.substring(0, r1));
    L12:
        r1 = 0;
        goto L13
    }

    private boolean attemptToExtractIdd() {
        Matcher r0 = this.regexCache.getPatternForRegex("\\+|" + this.currentMetadata.getInternationalPrefix()).matcher(this.accruedInputWithoutFormatting);
        if (r0.lookingAt() == false) goto L8;
        this.isCompleteNumber = true;
        int r1 = r0.end();
        this.nationalNumber.setLength(0);
        this.nationalNumber.append(this.accruedInputWithoutFormatting.substring(r1));
        this.prefixBeforeNationalNumber.setLength(0);
        this.prefixBeforeNationalNumber.append(this.accruedInputWithoutFormatting.substring(0, r1));
        if (this.accruedInputWithoutFormatting.charAt(0) == '+') goto L7;
        this.prefixBeforeNationalNumber.append(SEPARATOR_BEFORE_NATIONAL_NUMBER);
    L7:
        return true;
    L8:
        return false;
    }

    private boolean attemptToExtractCountryCallingCode() {
        if (this.nationalNumber.length() != 0) goto L5;
        return false;
    L5:
        StringBuilder r0 = new StringBuilder();
        int r2 = this.phoneUtil.extractCountryCode(this.nationalNumber, r0);
        if (r2 != 0) goto L8;
        return false;
    L8:
        this.nationalNumber.setLength(0);
        this.nationalNumber.append(r0);
        String r1 = this.phoneUtil.getRegionCodeForCountryCode(r2);
        if (PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY.equals(r1) == false) goto L12;
        this.currentMetadata = this.phoneUtil.getMetadataForNonGeographicalRegion(r2);
    L14:
        String r3 = Integer.toString(r2);
        this.prefixBeforeNationalNumber.append(r3).append(SEPARATOR_BEFORE_NATIONAL_NUMBER);
        this.extractedNationalPrefix = "";
        return true;
    L12:
        if (r1.equals(this.defaultCountry) == true) goto L14;
        this.currentMetadata = getMetadataForRegion(r1);
        goto L14
    }

    private char normalizeAndAccrueDigitsAndPlusSign(char r2, boolean r3) {
        if (r2 != '+') goto L5;
        this.accruedInputWithoutFormatting.append(r2);
    L6:
        if (r3 == false) goto L8;
        this.positionToRemember = this.accruedInputWithoutFormatting.length();
    L8:
        return r2;
    L5:
        r2 = Character.forDigit(Character.digit(r2, 10), 10);
        this.accruedInputWithoutFormatting.append(r2);
        this.nationalNumber.append(r2);
        goto L6
    }

    private String inputDigitHelper(char r6) {
        Matcher r0 = DIGIT_PATTERN.matcher(this.formattingTemplate);
        if (r0.find(this.lastMatchPosition) == false) goto L7;
        String r7 = r0.replaceFirst(Character.toString(r6));
        this.formattingTemplate.replace(0, r7.length(), r7);
        int r8 = r0.start();
        this.lastMatchPosition = r8;
        return this.formattingTemplate.substring(0, r8 + 1);
    L7:
        if (this.possibleFormats.size() != 1) goto L9;
        this.ableToFormat = false;
    L9:
        this.currentFormattingPattern = "";
        return this.accruedInput.toString();
    }
}
