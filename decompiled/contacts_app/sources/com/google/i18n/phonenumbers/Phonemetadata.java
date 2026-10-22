package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Phonemetadata {

    public static class NumberFormat implements Externalizable {
        private static final long serialVersionUID = 1;
        private String domesticCarrierCodeFormattingRule_;
        private String format_;
        private boolean hasDomesticCarrierCodeFormattingRule;
        private boolean hasFormat;
        private boolean hasNationalPrefixFormattingRule;
        private boolean hasNationalPrefixOptionalWhenFormatting;
        private boolean hasPattern;
        private List<String> leadingDigitsPattern_;
        private String nationalPrefixFormattingRule_;
        private boolean nationalPrefixOptionalWhenFormatting_;
        private String pattern_;

        public static final class Builder extends NumberFormat {
            public NumberFormat build() {
                return this;
            }

            public Builder() {
            }

            public Builder mergeFrom(NumberFormat r3) {
                if (r3.hasPattern() == false) goto L6;
                setPattern(r3.getPattern());
            L6:
                if (r3.hasFormat() == false) goto L8;
                setFormat(r3.getFormat());
            L8:
                int r0 = 0;
            L10:
                if (r0 >= r3.leadingDigitsPatternSize()) goto L13;
                addLeadingDigitsPattern(r3.getLeadingDigitsPattern(r0));
                r0 = r0 + 1;
                goto L10
            L13:
                if (r3.hasNationalPrefixFormattingRule() == false) goto L16;
                setNationalPrefixFormattingRule(r3.getNationalPrefixFormattingRule());
            L16:
                if (r3.hasDomesticCarrierCodeFormattingRule() == false) goto L19;
                setDomesticCarrierCodeFormattingRule(r3.getDomesticCarrierCodeFormattingRule());
            L19:
                if (r3.hasNationalPrefixOptionalWhenFormatting() == false) goto L21;
                setNationalPrefixOptionalWhenFormatting(r3.getNationalPrefixOptionalWhenFormatting());
            L21:
                return this;
            }
        }

        public NumberFormat() {
            this.pattern_ = "";
            this.format_ = "";
            this.leadingDigitsPattern_ = new ArrayList();
            this.nationalPrefixFormattingRule_ = "";
            this.nationalPrefixOptionalWhenFormatting_ = false;
            this.domesticCarrierCodeFormattingRule_ = "";
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean hasPattern() {
            return this.hasPattern;
        }

        public String getPattern() {
            return this.pattern_;
        }

        public NumberFormat setPattern(String r2) {
            this.hasPattern = true;
            this.pattern_ = r2;
            return this;
        }

        public boolean hasFormat() {
            return this.hasFormat;
        }

        public String getFormat() {
            return this.format_;
        }

        public NumberFormat setFormat(String r2) {
            this.hasFormat = true;
            this.format_ = r2;
            return this;
        }

        public List<String> leadingDigitPatterns() {
            return this.leadingDigitsPattern_;
        }

        public int leadingDigitsPatternSize() {
            return this.leadingDigitsPattern_.size();
        }

        public String getLeadingDigitsPattern(int r1) {
            return this.leadingDigitsPattern_.get(r1);
        }

        public NumberFormat addLeadingDigitsPattern(String r2) {
            r2.getClass();
            this.leadingDigitsPattern_.add(r2);
            return this;
        }

        public boolean hasNationalPrefixFormattingRule() {
            return this.hasNationalPrefixFormattingRule;
        }

        public String getNationalPrefixFormattingRule() {
            return this.nationalPrefixFormattingRule_;
        }

        public NumberFormat setNationalPrefixFormattingRule(String r2) {
            this.hasNationalPrefixFormattingRule = true;
            this.nationalPrefixFormattingRule_ = r2;
            return this;
        }

        public NumberFormat clearNationalPrefixFormattingRule() {
            this.hasNationalPrefixFormattingRule = false;
            this.nationalPrefixFormattingRule_ = "";
            return this;
        }

        public boolean hasNationalPrefixOptionalWhenFormatting() {
            return this.hasNationalPrefixOptionalWhenFormatting;
        }

        public boolean getNationalPrefixOptionalWhenFormatting() {
            return this.nationalPrefixOptionalWhenFormatting_;
        }

        public NumberFormat setNationalPrefixOptionalWhenFormatting(boolean r2) {
            this.hasNationalPrefixOptionalWhenFormatting = true;
            this.nationalPrefixOptionalWhenFormatting_ = r2;
            return this;
        }

        public boolean hasDomesticCarrierCodeFormattingRule() {
            return this.hasDomesticCarrierCodeFormattingRule;
        }

        public String getDomesticCarrierCodeFormattingRule() {
            return this.domesticCarrierCodeFormattingRule_;
        }

        public NumberFormat setDomesticCarrierCodeFormattingRule(String r2) {
            this.hasDomesticCarrierCodeFormattingRule = true;
            this.domesticCarrierCodeFormattingRule_ = r2;
            return this;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput r4) throws IOException {
            r4.writeUTF(this.pattern_);
            r4.writeUTF(this.format_);
            int r0 = leadingDigitsPatternSize();
            r4.writeInt(r0);
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r4.writeUTF(this.leadingDigitsPattern_.get(r1));
            r1 = r1 + 1;
            goto L3
        L5:
            r4.writeBoolean(this.hasNationalPrefixFormattingRule);
            if (this.hasNationalPrefixFormattingRule == false) goto L8;
            r4.writeUTF(this.nationalPrefixFormattingRule_);
        L8:
            r4.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
            if (this.hasDomesticCarrierCodeFormattingRule == false) goto L11;
            r4.writeUTF(this.domesticCarrierCodeFormattingRule_);
        L11:
            r4.writeBoolean(this.nationalPrefixOptionalWhenFormatting_);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput r5) throws IOException {
            setPattern(r5.readUTF());
            setFormat(r5.readUTF());
            int r0 = r5.readInt();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L6;
            this.leadingDigitsPattern_.add(r5.readUTF());
            r1 = r1 + 1;
            goto L3
        L6:
            if (r5.readBoolean() == false) goto L9;
            setNationalPrefixFormattingRule(r5.readUTF());
        L9:
            if (r5.readBoolean() == false) goto L11;
            setDomesticCarrierCodeFormattingRule(r5.readUTF());
        L11:
            setNationalPrefixOptionalWhenFormatting(r5.readBoolean());
        }
    }

    public static class PhoneMetadata implements Externalizable {
        private static final long serialVersionUID = 1;
        private PhoneNumberDesc carrierSpecific_;
        private int countryCode_;
        private PhoneNumberDesc emergency_;
        private PhoneNumberDesc fixedLine_;
        private PhoneNumberDesc generalDesc_;
        private boolean hasCarrierSpecific;
        private boolean hasCountryCode;
        private boolean hasEmergency;
        private boolean hasFixedLine;
        private boolean hasGeneralDesc;
        private boolean hasId;
        private boolean hasInternationalPrefix;
        private boolean hasLeadingDigits;
        private boolean hasLeadingZeroPossible;
        private boolean hasMainCountryForCode;
        private boolean hasMobile;
        private boolean hasMobileNumberPortableRegion;
        private boolean hasNationalPrefix;
        private boolean hasNationalPrefixForParsing;
        private boolean hasNationalPrefixTransformRule;
        private boolean hasNoInternationalDialling;
        private boolean hasPager;
        private boolean hasPersonalNumber;
        private boolean hasPreferredExtnPrefix;
        private boolean hasPreferredInternationalPrefix;
        private boolean hasPremiumRate;
        private boolean hasSameMobileAndFixedLinePattern;
        private boolean hasSharedCost;
        private boolean hasShortCode;
        private boolean hasSmsServices;
        private boolean hasStandardRate;
        private boolean hasTollFree;
        private boolean hasUan;
        private boolean hasVoicemail;
        private boolean hasVoip;
        private String id_;
        private String internationalPrefix_;
        private List<NumberFormat> intlNumberFormat_;
        private String leadingDigits_;
        private boolean leadingZeroPossible_;
        private boolean mainCountryForCode_;
        private boolean mobileNumberPortableRegion_;
        private PhoneNumberDesc mobile_;
        private String nationalPrefixForParsing_;
        private String nationalPrefixTransformRule_;
        private String nationalPrefix_;
        private PhoneNumberDesc noInternationalDialling_;
        private List<NumberFormat> numberFormat_;
        private PhoneNumberDesc pager_;
        private PhoneNumberDesc personalNumber_;
        private String preferredExtnPrefix_;
        private String preferredInternationalPrefix_;
        private PhoneNumberDesc premiumRate_;
        private boolean sameMobileAndFixedLinePattern_;
        private PhoneNumberDesc sharedCost_;
        private PhoneNumberDesc shortCode_;
        private PhoneNumberDesc smsServices_;
        private PhoneNumberDesc standardRate_;
        private PhoneNumberDesc tollFree_;
        private PhoneNumberDesc uan_;
        private PhoneNumberDesc voicemail_;
        private PhoneNumberDesc voip_;

        public static final class Builder extends PhoneMetadata {
            public PhoneMetadata build() {
                return this;
            }

            public Builder() {
            }
        }

        public PhoneMetadata() {
            this.generalDesc_ = null;
            this.fixedLine_ = null;
            this.mobile_ = null;
            this.tollFree_ = null;
            this.premiumRate_ = null;
            this.sharedCost_ = null;
            this.personalNumber_ = null;
            this.voip_ = null;
            this.pager_ = null;
            this.uan_ = null;
            this.emergency_ = null;
            this.voicemail_ = null;
            this.shortCode_ = null;
            this.standardRate_ = null;
            this.carrierSpecific_ = null;
            this.smsServices_ = null;
            this.noInternationalDialling_ = null;
            this.id_ = "";
            this.countryCode_ = 0;
            this.internationalPrefix_ = "";
            this.preferredInternationalPrefix_ = "";
            this.nationalPrefix_ = "";
            this.preferredExtnPrefix_ = "";
            this.nationalPrefixForParsing_ = "";
            this.nationalPrefixTransformRule_ = "";
            this.sameMobileAndFixedLinePattern_ = false;
            this.numberFormat_ = new ArrayList();
            this.intlNumberFormat_ = new ArrayList();
            this.mainCountryForCode_ = false;
            this.leadingDigits_ = "";
            this.leadingZeroPossible_ = false;
            this.mobileNumberPortableRegion_ = false;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean hasGeneralDesc() {
            return this.hasGeneralDesc;
        }

        public PhoneNumberDesc getGeneralDesc() {
            return this.generalDesc_;
        }

        public PhoneMetadata setGeneralDesc(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasGeneralDesc = true;
            this.generalDesc_ = r2;
            return this;
        }

        public boolean hasFixedLine() {
            return this.hasFixedLine;
        }

        public PhoneNumberDesc getFixedLine() {
            return this.fixedLine_;
        }

        public PhoneMetadata setFixedLine(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasFixedLine = true;
            this.fixedLine_ = r2;
            return this;
        }

        public boolean hasMobile() {
            return this.hasMobile;
        }

        public PhoneNumberDesc getMobile() {
            return this.mobile_;
        }

        public PhoneMetadata setMobile(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasMobile = true;
            this.mobile_ = r2;
            return this;
        }

        public boolean hasTollFree() {
            return this.hasTollFree;
        }

        public PhoneNumberDesc getTollFree() {
            return this.tollFree_;
        }

        public PhoneMetadata setTollFree(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasTollFree = true;
            this.tollFree_ = r2;
            return this;
        }

        public boolean hasPremiumRate() {
            return this.hasPremiumRate;
        }

        public PhoneNumberDesc getPremiumRate() {
            return this.premiumRate_;
        }

        public PhoneMetadata setPremiumRate(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasPremiumRate = true;
            this.premiumRate_ = r2;
            return this;
        }

        public boolean hasSharedCost() {
            return this.hasSharedCost;
        }

        public PhoneNumberDesc getSharedCost() {
            return this.sharedCost_;
        }

        public PhoneMetadata setSharedCost(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasSharedCost = true;
            this.sharedCost_ = r2;
            return this;
        }

        public boolean hasPersonalNumber() {
            return this.hasPersonalNumber;
        }

        public PhoneNumberDesc getPersonalNumber() {
            return this.personalNumber_;
        }

        public PhoneMetadata setPersonalNumber(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasPersonalNumber = true;
            this.personalNumber_ = r2;
            return this;
        }

        public boolean hasVoip() {
            return this.hasVoip;
        }

        public PhoneNumberDesc getVoip() {
            return this.voip_;
        }

        public PhoneMetadata setVoip(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasVoip = true;
            this.voip_ = r2;
            return this;
        }

        public boolean hasPager() {
            return this.hasPager;
        }

        public PhoneNumberDesc getPager() {
            return this.pager_;
        }

        public PhoneMetadata setPager(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasPager = true;
            this.pager_ = r2;
            return this;
        }

        public boolean hasUan() {
            return this.hasUan;
        }

        public PhoneNumberDesc getUan() {
            return this.uan_;
        }

        public PhoneMetadata setUan(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasUan = true;
            this.uan_ = r2;
            return this;
        }

        public boolean hasEmergency() {
            return this.hasEmergency;
        }

        public PhoneNumberDesc getEmergency() {
            return this.emergency_;
        }

        public PhoneMetadata setEmergency(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasEmergency = true;
            this.emergency_ = r2;
            return this;
        }

        public boolean hasVoicemail() {
            return this.hasVoicemail;
        }

        public PhoneNumberDesc getVoicemail() {
            return this.voicemail_;
        }

        public PhoneMetadata setVoicemail(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasVoicemail = true;
            this.voicemail_ = r2;
            return this;
        }

        public boolean hasShortCode() {
            return this.hasShortCode;
        }

        public PhoneNumberDesc getShortCode() {
            return this.shortCode_;
        }

        public PhoneMetadata setShortCode(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasShortCode = true;
            this.shortCode_ = r2;
            return this;
        }

        public boolean hasStandardRate() {
            return this.hasStandardRate;
        }

        public PhoneNumberDesc getStandardRate() {
            return this.standardRate_;
        }

        public PhoneMetadata setStandardRate(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasStandardRate = true;
            this.standardRate_ = r2;
            return this;
        }

        public boolean hasCarrierSpecific() {
            return this.hasCarrierSpecific;
        }

        public PhoneNumberDesc getCarrierSpecific() {
            return this.carrierSpecific_;
        }

        public PhoneMetadata setCarrierSpecific(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasCarrierSpecific = true;
            this.carrierSpecific_ = r2;
            return this;
        }

        public boolean hasSmsServices() {
            return this.hasSmsServices;
        }

        public PhoneNumberDesc getSmsServices() {
            return this.smsServices_;
        }

        public PhoneMetadata setSmsServices(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasSmsServices = true;
            this.smsServices_ = r2;
            return this;
        }

        public boolean hasNoInternationalDialling() {
            return this.hasNoInternationalDialling;
        }

        public PhoneNumberDesc getNoInternationalDialling() {
            return this.noInternationalDialling_;
        }

        public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc r2) {
            r2.getClass();
            this.hasNoInternationalDialling = true;
            this.noInternationalDialling_ = r2;
            return this;
        }

        public boolean hasId() {
            return this.hasId;
        }

        public String getId() {
            return this.id_;
        }

        public PhoneMetadata setId(String r2) {
            this.hasId = true;
            this.id_ = r2;
            return this;
        }

        public boolean hasCountryCode() {
            return this.hasCountryCode;
        }

        public int getCountryCode() {
            return this.countryCode_;
        }

        public PhoneMetadata setCountryCode(int r2) {
            this.hasCountryCode = true;
            this.countryCode_ = r2;
            return this;
        }

        public boolean hasInternationalPrefix() {
            return this.hasInternationalPrefix;
        }

        public String getInternationalPrefix() {
            return this.internationalPrefix_;
        }

        public PhoneMetadata setInternationalPrefix(String r2) {
            this.hasInternationalPrefix = true;
            this.internationalPrefix_ = r2;
            return this;
        }

        public boolean hasPreferredInternationalPrefix() {
            return this.hasPreferredInternationalPrefix;
        }

        public String getPreferredInternationalPrefix() {
            return this.preferredInternationalPrefix_;
        }

        public PhoneMetadata setPreferredInternationalPrefix(String r2) {
            this.hasPreferredInternationalPrefix = true;
            this.preferredInternationalPrefix_ = r2;
            return this;
        }

        public PhoneMetadata clearPreferredInternationalPrefix() {
            this.hasPreferredInternationalPrefix = false;
            this.preferredInternationalPrefix_ = "";
            return this;
        }

        public boolean hasNationalPrefix() {
            return this.hasNationalPrefix;
        }

        public String getNationalPrefix() {
            return this.nationalPrefix_;
        }

        public PhoneMetadata setNationalPrefix(String r2) {
            this.hasNationalPrefix = true;
            this.nationalPrefix_ = r2;
            return this;
        }

        public PhoneMetadata clearNationalPrefix() {
            this.hasNationalPrefix = false;
            this.nationalPrefix_ = "";
            return this;
        }

        public boolean hasPreferredExtnPrefix() {
            return this.hasPreferredExtnPrefix;
        }

        public String getPreferredExtnPrefix() {
            return this.preferredExtnPrefix_;
        }

        public PhoneMetadata setPreferredExtnPrefix(String r2) {
            this.hasPreferredExtnPrefix = true;
            this.preferredExtnPrefix_ = r2;
            return this;
        }

        public PhoneMetadata clearPreferredExtnPrefix() {
            this.hasPreferredExtnPrefix = false;
            this.preferredExtnPrefix_ = "";
            return this;
        }

        public boolean hasNationalPrefixForParsing() {
            return this.hasNationalPrefixForParsing;
        }

        public String getNationalPrefixForParsing() {
            return this.nationalPrefixForParsing_;
        }

        public PhoneMetadata setNationalPrefixForParsing(String r2) {
            this.hasNationalPrefixForParsing = true;
            this.nationalPrefixForParsing_ = r2;
            return this;
        }

        public boolean hasNationalPrefixTransformRule() {
            return this.hasNationalPrefixTransformRule;
        }

        public String getNationalPrefixTransformRule() {
            return this.nationalPrefixTransformRule_;
        }

        public PhoneMetadata setNationalPrefixTransformRule(String r2) {
            this.hasNationalPrefixTransformRule = true;
            this.nationalPrefixTransformRule_ = r2;
            return this;
        }

        public PhoneMetadata clearNationalPrefixTransformRule() {
            this.hasNationalPrefixTransformRule = false;
            this.nationalPrefixTransformRule_ = "";
            return this;
        }

        public boolean hasSameMobileAndFixedLinePattern() {
            return this.hasSameMobileAndFixedLinePattern;
        }

        public boolean getSameMobileAndFixedLinePattern() {
            return this.sameMobileAndFixedLinePattern_;
        }

        public PhoneMetadata setSameMobileAndFixedLinePattern(boolean r2) {
            this.hasSameMobileAndFixedLinePattern = true;
            this.sameMobileAndFixedLinePattern_ = r2;
            return this;
        }

        public PhoneMetadata clearSameMobileAndFixedLinePattern() {
            this.hasSameMobileAndFixedLinePattern = false;
            this.sameMobileAndFixedLinePattern_ = false;
            return this;
        }

        public List<NumberFormat> numberFormats() {
            return this.numberFormat_;
        }

        public int numberFormatSize() {
            return this.numberFormat_.size();
        }

        public NumberFormat getNumberFormat(int r1) {
            return this.numberFormat_.get(r1);
        }

        public PhoneMetadata addNumberFormat(NumberFormat r2) {
            r2.getClass();
            this.numberFormat_.add(r2);
            return this;
        }

        public List<NumberFormat> intlNumberFormats() {
            return this.intlNumberFormat_;
        }

        public int intlNumberFormatSize() {
            return this.intlNumberFormat_.size();
        }

        public NumberFormat getIntlNumberFormat(int r1) {
            return this.intlNumberFormat_.get(r1);
        }

        public PhoneMetadata addIntlNumberFormat(NumberFormat r2) {
            r2.getClass();
            this.intlNumberFormat_.add(r2);
            return this;
        }

        public PhoneMetadata clearIntlNumberFormat() {
            this.intlNumberFormat_.clear();
            return this;
        }

        public boolean hasMainCountryForCode() {
            return this.hasMainCountryForCode;
        }

        public boolean isMainCountryForCode() {
            return this.mainCountryForCode_;
        }

        public boolean getMainCountryForCode() {
            return this.mainCountryForCode_;
        }

        public PhoneMetadata setMainCountryForCode(boolean r2) {
            this.hasMainCountryForCode = true;
            this.mainCountryForCode_ = r2;
            return this;
        }

        public PhoneMetadata clearMainCountryForCode() {
            this.hasMainCountryForCode = false;
            this.mainCountryForCode_ = false;
            return this;
        }

        public boolean hasLeadingDigits() {
            return this.hasLeadingDigits;
        }

        public String getLeadingDigits() {
            return this.leadingDigits_;
        }

        public PhoneMetadata setLeadingDigits(String r2) {
            this.hasLeadingDigits = true;
            this.leadingDigits_ = r2;
            return this;
        }

        public boolean hasLeadingZeroPossible() {
            return this.hasLeadingZeroPossible;
        }

        public boolean isLeadingZeroPossible() {
            return this.leadingZeroPossible_;
        }

        public PhoneMetadata setLeadingZeroPossible(boolean r2) {
            this.hasLeadingZeroPossible = true;
            this.leadingZeroPossible_ = r2;
            return this;
        }

        public PhoneMetadata clearLeadingZeroPossible() {
            this.hasLeadingZeroPossible = false;
            this.leadingZeroPossible_ = false;
            return this;
        }

        public boolean hasMobileNumberPortableRegion() {
            return this.hasMobileNumberPortableRegion;
        }

        public boolean isMobileNumberPortableRegion() {
            return this.mobileNumberPortableRegion_;
        }

        public PhoneMetadata setMobileNumberPortableRegion(boolean r2) {
            this.hasMobileNumberPortableRegion = true;
            this.mobileNumberPortableRegion_ = r2;
            return this;
        }

        public PhoneMetadata clearMobileNumberPortableRegion() {
            this.hasMobileNumberPortableRegion = false;
            this.mobileNumberPortableRegion_ = false;
            return this;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput r5) throws IOException {
            r5.writeBoolean(this.hasGeneralDesc);
            if (this.hasGeneralDesc == false) goto L5;
            this.generalDesc_.writeExternal(r5);
        L5:
            r5.writeBoolean(this.hasFixedLine);
            if (this.hasFixedLine == false) goto L8;
            this.fixedLine_.writeExternal(r5);
        L8:
            r5.writeBoolean(this.hasMobile);
            if (this.hasMobile == false) goto L11;
            this.mobile_.writeExternal(r5);
        L11:
            r5.writeBoolean(this.hasTollFree);
            if (this.hasTollFree == false) goto L14;
            this.tollFree_.writeExternal(r5);
        L14:
            r5.writeBoolean(this.hasPremiumRate);
            if (this.hasPremiumRate == false) goto L17;
            this.premiumRate_.writeExternal(r5);
        L17:
            r5.writeBoolean(this.hasSharedCost);
            if (this.hasSharedCost == false) goto L20;
            this.sharedCost_.writeExternal(r5);
        L20:
            r5.writeBoolean(this.hasPersonalNumber);
            if (this.hasPersonalNumber == false) goto L23;
            this.personalNumber_.writeExternal(r5);
        L23:
            r5.writeBoolean(this.hasVoip);
            if (this.hasVoip == false) goto L26;
            this.voip_.writeExternal(r5);
        L26:
            r5.writeBoolean(this.hasPager);
            if (this.hasPager == false) goto L29;
            this.pager_.writeExternal(r5);
        L29:
            r5.writeBoolean(this.hasUan);
            if (this.hasUan == false) goto L32;
            this.uan_.writeExternal(r5);
        L32:
            r5.writeBoolean(this.hasEmergency);
            if (this.hasEmergency == false) goto L35;
            this.emergency_.writeExternal(r5);
        L35:
            r5.writeBoolean(this.hasVoicemail);
            if (this.hasVoicemail == false) goto L38;
            this.voicemail_.writeExternal(r5);
        L38:
            r5.writeBoolean(this.hasShortCode);
            if (this.hasShortCode == false) goto L41;
            this.shortCode_.writeExternal(r5);
        L41:
            r5.writeBoolean(this.hasStandardRate);
            if (this.hasStandardRate == false) goto L44;
            this.standardRate_.writeExternal(r5);
        L44:
            r5.writeBoolean(this.hasCarrierSpecific);
            if (this.hasCarrierSpecific == false) goto L47;
            this.carrierSpecific_.writeExternal(r5);
        L47:
            r5.writeBoolean(this.hasSmsServices);
            if (this.hasSmsServices == false) goto L50;
            this.smsServices_.writeExternal(r5);
        L50:
            r5.writeBoolean(this.hasNoInternationalDialling);
            if (this.hasNoInternationalDialling == false) goto L53;
            this.noInternationalDialling_.writeExternal(r5);
        L53:
            r5.writeUTF(this.id_);
            r5.writeInt(this.countryCode_);
            r5.writeUTF(this.internationalPrefix_);
            r5.writeBoolean(this.hasPreferredInternationalPrefix);
            if (this.hasPreferredInternationalPrefix == false) goto L56;
            r5.writeUTF(this.preferredInternationalPrefix_);
        L56:
            r5.writeBoolean(this.hasNationalPrefix);
            if (this.hasNationalPrefix == false) goto L59;
            r5.writeUTF(this.nationalPrefix_);
        L59:
            r5.writeBoolean(this.hasPreferredExtnPrefix);
            if (this.hasPreferredExtnPrefix == false) goto L62;
            r5.writeUTF(this.preferredExtnPrefix_);
        L62:
            r5.writeBoolean(this.hasNationalPrefixForParsing);
            if (this.hasNationalPrefixForParsing == false) goto L65;
            r5.writeUTF(this.nationalPrefixForParsing_);
        L65:
            r5.writeBoolean(this.hasNationalPrefixTransformRule);
            if (this.hasNationalPrefixTransformRule == false) goto L68;
            r5.writeUTF(this.nationalPrefixTransformRule_);
        L68:
            r5.writeBoolean(this.sameMobileAndFixedLinePattern_);
            int r0 = numberFormatSize();
            r5.writeInt(r0);
            int r1 = 0;
            int r2 = 0;
        L69:
            if (r2 >= r0) goto L71;
            this.numberFormat_.get(r2).writeExternal(r5);
            r2 = r2 + 1;
            goto L69
        L71:
            int r3 = intlNumberFormatSize();
            r5.writeInt(r3);
        L72:
            if (r1 >= r3) goto L74;
            this.intlNumberFormat_.get(r1).writeExternal(r5);
            r1 = r1 + 1;
            goto L72
        L74:
            r5.writeBoolean(this.mainCountryForCode_);
            r5.writeBoolean(this.hasLeadingDigits);
            if (this.hasLeadingDigits == false) goto L77;
            r5.writeUTF(this.leadingDigits_);
        L77:
            r5.writeBoolean(this.leadingZeroPossible_);
            r5.writeBoolean(this.mobileNumberPortableRegion_);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput r6) throws IOException {
            if (r6.readBoolean() == false) goto L6;
            PhoneNumberDesc r0 = new PhoneNumberDesc();
            r0.readExternal(r6);
            setGeneralDesc(r0);
        L6:
            if (r6.readBoolean() == false) goto L9;
            PhoneNumberDesc r1 = new PhoneNumberDesc();
            r1.readExternal(r6);
            setFixedLine(r1);
        L9:
            if (r6.readBoolean() == false) goto L12;
            PhoneNumberDesc r2 = new PhoneNumberDesc();
            r2.readExternal(r6);
            setMobile(r2);
        L12:
            if (r6.readBoolean() == false) goto L15;
            PhoneNumberDesc r3 = new PhoneNumberDesc();
            r3.readExternal(r6);
            setTollFree(r3);
        L15:
            if (r6.readBoolean() == false) goto L18;
            PhoneNumberDesc r4 = new PhoneNumberDesc();
            r4.readExternal(r6);
            setPremiumRate(r4);
        L18:
            if (r6.readBoolean() == false) goto L21;
            PhoneNumberDesc r5 = new PhoneNumberDesc();
            r5.readExternal(r6);
            setSharedCost(r5);
        L21:
            if (r6.readBoolean() == false) goto L24;
            PhoneNumberDesc r7 = new PhoneNumberDesc();
            r7.readExternal(r6);
            setPersonalNumber(r7);
        L24:
            if (r6.readBoolean() == false) goto L27;
            PhoneNumberDesc r8 = new PhoneNumberDesc();
            r8.readExternal(r6);
            setVoip(r8);
        L27:
            if (r6.readBoolean() == false) goto L30;
            PhoneNumberDesc r9 = new PhoneNumberDesc();
            r9.readExternal(r6);
            setPager(r9);
        L30:
            if (r6.readBoolean() == false) goto L33;
            PhoneNumberDesc r10 = new PhoneNumberDesc();
            r10.readExternal(r6);
            setUan(r10);
        L33:
            if (r6.readBoolean() == false) goto L36;
            PhoneNumberDesc r11 = new PhoneNumberDesc();
            r11.readExternal(r6);
            setEmergency(r11);
        L36:
            if (r6.readBoolean() == false) goto L39;
            PhoneNumberDesc r12 = new PhoneNumberDesc();
            r12.readExternal(r6);
            setVoicemail(r12);
        L39:
            if (r6.readBoolean() == false) goto L42;
            PhoneNumberDesc r13 = new PhoneNumberDesc();
            r13.readExternal(r6);
            setShortCode(r13);
        L42:
            if (r6.readBoolean() == false) goto L45;
            PhoneNumberDesc r14 = new PhoneNumberDesc();
            r14.readExternal(r6);
            setStandardRate(r14);
        L45:
            if (r6.readBoolean() == false) goto L48;
            PhoneNumberDesc r15 = new PhoneNumberDesc();
            r15.readExternal(r6);
            setCarrierSpecific(r15);
        L48:
            if (r6.readBoolean() == false) goto L51;
            PhoneNumberDesc r16 = new PhoneNumberDesc();
            r16.readExternal(r6);
            setSmsServices(r16);
        L51:
            if (r6.readBoolean() == false) goto L53;
            PhoneNumberDesc r17 = new PhoneNumberDesc();
            r17.readExternal(r6);
            setNoInternationalDialling(r17);
        L53:
            setId(r6.readUTF());
            setCountryCode(r6.readInt());
            setInternationalPrefix(r6.readUTF());
            if (r6.readBoolean() == false) goto L57;
            setPreferredInternationalPrefix(r6.readUTF());
        L57:
            if (r6.readBoolean() == false) goto L60;
            setNationalPrefix(r6.readUTF());
        L60:
            if (r6.readBoolean() == false) goto L63;
            setPreferredExtnPrefix(r6.readUTF());
        L63:
            if (r6.readBoolean() == false) goto L66;
            setNationalPrefixForParsing(r6.readUTF());
        L66:
            if (r6.readBoolean() == false) goto L68;
            setNationalPrefixTransformRule(r6.readUTF());
        L68:
            setSameMobileAndFixedLinePattern(r6.readBoolean());
            int r18 = r6.readInt();
            int r19 = 0;
            int r20 = 0;
        L69:
            if (r20 >= r18) goto L71;
            NumberFormat r21 = new NumberFormat();
            r21.readExternal(r6);
            this.numberFormat_.add(r21);
            r20 = r20 + 1;
            goto L69
        L71:
            int r22 = r6.readInt();
        L72:
            if (r19 >= r22) goto L74;
            NumberFormat r23 = new NumberFormat();
            r23.readExternal(r6);
            this.intlNumberFormat_.add(r23);
            r19 = r19 + 1;
            goto L72
        L74:
            setMainCountryForCode(r6.readBoolean());
            if (r6.readBoolean() == false) goto L77;
            setLeadingDigits(r6.readUTF());
        L77:
            setLeadingZeroPossible(r6.readBoolean());
            setMobileNumberPortableRegion(r6.readBoolean());
        }
    }

    public static class PhoneMetadataCollection implements Externalizable {
        private static final long serialVersionUID = 1;
        private List<PhoneMetadata> metadata_;

        public static final class Builder extends PhoneMetadataCollection {
            public PhoneMetadataCollection build() {
                return this;
            }

            public Builder() {
            }
        }

        public PhoneMetadataCollection() {
            this.metadata_ = new ArrayList();
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public List<PhoneMetadata> getMetadataList() {
            return this.metadata_;
        }

        public int getMetadataCount() {
            return this.metadata_.size();
        }

        public PhoneMetadataCollection addMetadata(PhoneMetadata r2) {
            r2.getClass();
            this.metadata_.add(r2);
            return this;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput r4) throws IOException {
            int r0 = getMetadataCount();
            r4.writeInt(r0);
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            this.metadata_.get(r1).writeExternal(r4);
            r1 = r1 + 1;
            goto L3
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput r5) throws IOException {
            int r0 = r5.readInt();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            PhoneMetadata r2 = new PhoneMetadata();
            r2.readExternal(r5);
            this.metadata_.add(r2);
            r1 = r1 + 1;
            goto L3
        }

        public PhoneMetadataCollection clear() {
            this.metadata_.clear();
            return this;
        }
    }

    public static class PhoneNumberDesc implements Externalizable {
        private static final long serialVersionUID = 1;
        private String exampleNumber_;
        private boolean hasExampleNumber;
        private boolean hasNationalNumberPattern;
        private String nationalNumberPattern_;
        private List<Integer> possibleLengthLocalOnly_;
        private List<Integer> possibleLength_;

        public static final class Builder extends PhoneNumberDesc {
            public PhoneNumberDesc build() {
                return this;
            }

            public Builder() {
            }

            public Builder mergeFrom(PhoneNumberDesc r4) {
                if (r4.hasNationalNumberPattern() == false) goto L5;
                setNationalNumberPattern(r4.getNationalNumberPattern());
            L5:
                int r0 = 0;
                int r1 = 0;
            L7:
                if (r1 >= r4.getPossibleLengthCount()) goto L10;
                addPossibleLength(r4.getPossibleLength(r1));
                r1 = r1 + 1;
            L10:
                if (r0 >= r4.getPossibleLengthLocalOnlyCount()) goto L13;
                addPossibleLengthLocalOnly(r4.getPossibleLengthLocalOnly(r0));
                r0 = r0 + 1;
                goto L10
            L13:
                if (r4.hasExampleNumber() == false) goto L15;
                setExampleNumber(r4.getExampleNumber());
            L15:
                return this;
            }
        }

        public PhoneNumberDesc() {
            this.nationalNumberPattern_ = "";
            this.possibleLength_ = new ArrayList();
            this.possibleLengthLocalOnly_ = new ArrayList();
            this.exampleNumber_ = "";
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean hasNationalNumberPattern() {
            return this.hasNationalNumberPattern;
        }

        public String getNationalNumberPattern() {
            return this.nationalNumberPattern_;
        }

        public PhoneNumberDesc setNationalNumberPattern(String r2) {
            this.hasNationalNumberPattern = true;
            this.nationalNumberPattern_ = r2;
            return this;
        }

        public PhoneNumberDesc clearNationalNumberPattern() {
            this.hasNationalNumberPattern = false;
            this.nationalNumberPattern_ = "";
            return this;
        }

        public List<Integer> getPossibleLengthList() {
            return this.possibleLength_;
        }

        public int getPossibleLengthCount() {
            return this.possibleLength_.size();
        }

        public int getPossibleLength(int r1) {
            return this.possibleLength_.get(r1).intValue();
        }

        public PhoneNumberDesc addPossibleLength(int r2) {
            this.possibleLength_.add(Integer.valueOf(r2));
            return this;
        }

        public PhoneNumberDesc clearPossibleLength() {
            this.possibleLength_.clear();
            return this;
        }

        public List<Integer> getPossibleLengthLocalOnlyList() {
            return this.possibleLengthLocalOnly_;
        }

        public int getPossibleLengthLocalOnlyCount() {
            return this.possibleLengthLocalOnly_.size();
        }

        public int getPossibleLengthLocalOnly(int r1) {
            return this.possibleLengthLocalOnly_.get(r1).intValue();
        }

        public PhoneNumberDesc addPossibleLengthLocalOnly(int r2) {
            this.possibleLengthLocalOnly_.add(Integer.valueOf(r2));
            return this;
        }

        public PhoneNumberDesc clearPossibleLengthLocalOnly() {
            this.possibleLengthLocalOnly_.clear();
            return this;
        }

        public boolean hasExampleNumber() {
            return this.hasExampleNumber;
        }

        public String getExampleNumber() {
            return this.exampleNumber_;
        }

        public PhoneNumberDesc setExampleNumber(String r2) {
            this.hasExampleNumber = true;
            this.exampleNumber_ = r2;
            return this;
        }

        public PhoneNumberDesc clearExampleNumber() {
            this.hasExampleNumber = false;
            this.exampleNumber_ = "";
            return this;
        }

        public boolean exactlySameAs(PhoneNumberDesc r3) {
            if (this.nationalNumberPattern_.equals(r3.nationalNumberPattern_) == true) goto L5;
        L11:
            return false;
        L5:
            if (this.possibleLength_.equals(r3.possibleLength_) == false) goto L11;
            if (this.possibleLengthLocalOnly_.equals(r3.possibleLengthLocalOnly_) == false) goto L11;
            if (this.exampleNumber_.equals(r3.exampleNumber_) == false) goto L11;
            return true;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput r5) throws IOException {
            r5.writeBoolean(this.hasNationalNumberPattern);
            if (this.hasNationalNumberPattern == false) goto L5;
            r5.writeUTF(this.nationalNumberPattern_);
        L5:
            int r0 = getPossibleLengthCount();
            r5.writeInt(r0);
            int r1 = 0;
            int r2 = 0;
        L6:
            if (r2 >= r0) goto L8;
            r5.writeInt(this.possibleLength_.get(r2).intValue());
            r2 = r2 + 1;
            goto L6
        L8:
            int r3 = getPossibleLengthLocalOnlyCount();
            r5.writeInt(r3);
        L9:
            if (r1 >= r3) goto L11;
            r5.writeInt(this.possibleLengthLocalOnly_.get(r1).intValue());
            r1 = r1 + 1;
            goto L9
        L11:
            r5.writeBoolean(this.hasExampleNumber);
            if (this.hasExampleNumber == false) goto L17;
            r5.writeUTF(this.exampleNumber_);
            return;
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput r6) throws IOException {
            if (r6.readBoolean() == false) goto L5;
            setNationalNumberPattern(r6.readUTF());
        L5:
            int r0 = r6.readInt();
            int r1 = 0;
            int r2 = 0;
        L6:
            if (r2 >= r0) goto L8;
            this.possibleLength_.add(Integer.valueOf(r6.readInt()));
            r2 = r2 + 1;
            goto L6
        L8:
            int r3 = r6.readInt();
        L9:
            if (r1 >= r3) goto L12;
            this.possibleLengthLocalOnly_.add(Integer.valueOf(r6.readInt()));
            r1 = r1 + 1;
            goto L9
        L12:
            if (r6.readBoolean() == false) goto L17;
            setExampleNumber(r6.readUTF());
            return;
        }
    }

    private Phonemetadata() {
    }
}
