package com.obric.utils;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.settings.SettingsProviderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ClipboardReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0004&'()B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u0018J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0013H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/utils/ClipboardReader;", "", "context", "Landroid/content/Context;", "patternConfig", "Lcom/obric/utils/ClipboardReader$PatternConfig;", "forbiddenDescriptionTypeList", "", "", "(Landroid/content/Context;Lcom/obric/utils/ClipboardReader$PatternConfig;Ljava/util/List;)V", "clipboardListener", "Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;", "clipboardManager", "Landroid/content/ClipboardManager;", "getClipboardManager", "()Landroid/content/ClipboardManager;", "clipboardManager$delegate", "Lkotlin/Lazy;", "clipboardTimeStamp", "", "observers", "", "Lcom/obric/utils/ClipboardReader$ClipboardObserver;", "addObserver", "", "observer", MaterialConfigFormatNames.DISABLE, "enable", "getClipboardText", "clipData", "Landroid/content/ClipData;", "handleClipboardChange", "isClipDataMatches", "", "isClipDescriptionMatchesPatternAndTimeStamp", "removeObserver", "updateClipboardTimeStamp", "timeStamp", "Builder", "ClipboardObserver", "Companion", "PatternConfig", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClipboardReader {
    public static final Companion Companion = null;
    public static final String FORBIDDEN_CLIPBOARD_TYPE_CALL_LOG = "text/ContactsCallLog";
    private static final String SP_KEY_CONTACTS_CLIPBOARD_CHANGE_TIMESTAMP = "contacts_clipboard_change_timestamp";
    private static final String TAG = "ClipboardReader";
    private final ClipboardManager.OnPrimaryClipChangedListener clipboardListener;
    private final Lazy clipboardManager$delegate;
    private volatile long clipboardTimeStamp;
    private final Context context;
    private final List<String> forbiddenDescriptionTypeList;
    private final Set<ClipboardObserver> observers;
    private final PatternConfig patternConfig;

    /* JADX INFO: compiled from: ClipboardReader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u0000J\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/utils/ClipboardReader$Builder;", "", "()V", "patterns", "", "Ljava/util/regex/Pattern;", "addCustomPattern", "pattern", "regex", "", "addEmailPattern", "addPhoneNumberPattern", "addUrlPattern", "build", "Lcom/obric/utils/ClipboardReader$PatternConfig;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private final List<Pattern> patterns;

        public Builder() {
            this.patterns = new ArrayList();
        }

        public final Builder addPhoneNumberPattern() {
            List<Pattern> r0 = this.patterns;
            Pattern r1 = PatternConfig.Companion.getPHONE_NUMBER_PATTERN();
            Intrinsics.checkNotNullExpressionValue(r1, "PHONE_NUMBER_PATTERN");
            r0.add(r1);
            return this;
        }

        public final Builder addEmailPattern() {
            List<Pattern> r0 = this.patterns;
            Pattern r1 = PatternConfig.Companion.getEMAIL_PATTERN();
            Intrinsics.checkNotNullExpressionValue(r1, "EMAIL_PATTERN");
            r0.add(r1);
            return this;
        }

        public final Builder addUrlPattern() {
            List<Pattern> r0 = this.patterns;
            Pattern r1 = PatternConfig.Companion.getURL_PATTERN();
            Intrinsics.checkNotNullExpressionValue(r1, "URL_PATTERN");
            r0.add(r1);
            return this;
        }

        public final Builder addCustomPattern(Pattern r2) {
            Intrinsics.checkNotNullParameter(r2, "pattern");
            this.patterns.add(r2);
            return this;
        }

        public final Builder addCustomPattern(String r3) {
            Intrinsics.checkNotNullParameter(r3, "regex");
            List<Pattern> r0 = this.patterns;
            Pattern r4 = Pattern.compile(r3);
            Intrinsics.checkNotNullExpressionValue(r4, "compile(regex)");
            r0.add(r4);
            return this;
        }

        public final PatternConfig build() {
            if (this.patterns.isEmpty() == false) goto L5;
            List<Pattern> r2 = CollectionsKt.listOf(PatternConfig.Companion.getPHONE_NUMBER_PATTERN());
        L7:
            return new PatternConfig(r2);
        L5:
            r2 = this.patterns;
            goto L7
        }
    }

    /* JADX INFO: compiled from: ClipboardReader.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, d2 = {"Lcom/obric/utils/ClipboardReader$ClipboardObserver;", "", "onClipboardResult", "", Params.CONTENT, "", "isSuccess", "", "errMessage", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ClipboardObserver {

        /* JADX INFO: compiled from: ClipboardReader.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void onClipboardResult$default(ClipboardObserver r1, String r2, boolean r3, String r4, int r5, Object r6) {
                if (r6 != null) goto L12;
                if ((r5 & 1) == 0) goto L7;
                r2 = null;
            L7:
                if ((r5 & 4) == 0) goto L9;
                r4 = null;
            L9:
                r1.onClipboardResult(r2, r3, r4);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClipboardResult");
            }
        }

        void onClipboardResult(String r1, boolean r2, String r3);
    }

    /* JADX INFO: compiled from: ClipboardReader.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/utils/ClipboardReader$Companion;", "", "()V", "FORBIDDEN_CLIPBOARD_TYPE_CALL_LOG", "", "SP_KEY_CONTACTS_CLIPBOARD_CHANGE_TIMESTAMP", "TAG", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ClipboardReader.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\t\u0010\u0016\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/obric/utils/ClipboardReader$PatternConfig;", "", "patterns", "", "Ljava/util/regex/Pattern;", "(Ljava/util/List;)V", "getPatterns", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "getConfidenceScore", "", "text", "", "getCustomPatternConfidence", "pattern", "getEmailConfidence", "getPhoneNumberConfidence", "getUrlConfidence", "hashCode", "toString", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PatternConfig {
        public static final Companion Companion = null;
        private static final PatternConfig DEFAULT = null;
        private static final Pattern EMAIL_PATTERN = null;
        private static final Pattern PHONE_NUMBER_PATTERN = null;
        private static final Pattern URL_PATTERN = null;
        private final List<Pattern> patterns;

        /* JADX INFO: compiled from: ClipboardReader.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/obric/utils/ClipboardReader$PatternConfig$Companion;", "", "()V", "DEFAULT", "Lcom/obric/utils/ClipboardReader$PatternConfig;", "getDEFAULT", "()Lcom/obric/utils/ClipboardReader$PatternConfig;", "EMAIL_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getEMAIL_PATTERN", "()Ljava/util/regex/Pattern;", "PHONE_NUMBER_PATTERN", "getPHONE_NUMBER_PATTERN", "URL_PATTERN", "getURL_PATTERN", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final Pattern getPHONE_NUMBER_PATTERN() {
                return PatternConfig.access$getPHONE_NUMBER_PATTERN$cp();
            }

            public final Pattern getEMAIL_PATTERN() {
                return PatternConfig.access$getEMAIL_PATTERN$cp();
            }

            public final Pattern getURL_PATTERN() {
                return PatternConfig.access$getURL_PATTERN$cp();
            }

            public final PatternConfig getDEFAULT() {
                return PatternConfig.access$getDEFAULT$cp();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PatternConfig() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PatternConfig copy$default(PatternConfig r0, List r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.patterns;
        L6:
            return r0.copy(r1);
        }

        public final List<Pattern> component1() {
            return this.patterns;
        }

        public final PatternConfig copy(List<Pattern> r1) {
            Intrinsics.checkNotNullParameter(r1, "patterns");
            return new PatternConfig(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof PatternConfig) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.patterns, ((PatternConfig) r4).patterns) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.patterns.hashCode();
        }

        public String toString() {
            return "PatternConfig(patterns=" + this.patterns + ')';
        }

        public PatternConfig(List<Pattern> r2) {
            Intrinsics.checkNotNullParameter(r2, "patterns");
            this.patterns = r2;
        }

        public static final /* synthetic */ PatternConfig access$getDEFAULT$cp() {
            return DEFAULT;
        }

        public static final /* synthetic */ Pattern access$getEMAIL_PATTERN$cp() {
            return EMAIL_PATTERN;
        }

        public static final /* synthetic */ Pattern access$getPHONE_NUMBER_PATTERN$cp() {
            return PHONE_NUMBER_PATTERN;
        }

        public static final /* synthetic */ Pattern access$getURL_PATTERN$cp() {
            return URL_PATTERN;
        }

        public /* synthetic */ PatternConfig(List r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = CollectionsKt.listOf(PHONE_NUMBER_PATTERN);
        L5:
            this(r1);
        }

        public final List<Pattern> getPatterns() {
            return this.patterns;
        }

        /* JADX WARN: Multi-variable type inference failed */
        static {
            Companion = new Companion(null);
            PHONE_NUMBER_PATTERN = Pattern.compile(Patterns.PHONE.pattern());
            EMAIL_PATTERN = Pattern.compile(Patterns.EMAIL_ADDRESS.pattern());
            URL_PATTERN = Pattern.compile(Patterns.WEB_URL.pattern());
            Object[] r1 = 0 == true ? 1 : 0;
            DEFAULT = new PatternConfig(r1, 1, 0 == true ? 1 : 0);
        }

        public final int getConfidenceScore(String r6) {
            Intrinsics.checkNotNullParameter(r6, "text");
            if (TextUtils.isEmpty(r6) == false) goto L5;
            return 0;
        L5:
            Iterator<T> r0 = this.patterns.iterator();
            if (r0.hasNext() == true) goto L8;
            Integer r5 = null;
        L35:
            Integer r7 = r5;
            if (r7 != null) goto L38;
            return 0;
        L38:
            return r7.intValue();
        L8:
            Pattern r2 = (Pattern) r0.next();
            if (Intrinsics.areEqual(r2, PHONE_NUMBER_PATTERN) == false) goto L12;
            int r3 = getPhoneNumberConfidence(r6);
        L18:
            Integer r4 = Integer.valueOf(r3);
        L20:
            if (r0.hasNext() == false) goto L34;
            Pattern r8 = (Pattern) r0.next();
            if (Intrinsics.areEqual(r8, PHONE_NUMBER_PATTERN) == false) goto L25;
            int r9 = getPhoneNumberConfidence(r6);
        L31:
            Integer r10 = Integer.valueOf(r9);
            if (r4.compareTo(r10) >= 0) goto L20;
            r4 = r10;
            goto L20
        L25:
            if (Intrinsics.areEqual(r8, EMAIL_PATTERN) == false) goto L28;
            r9 = getEmailConfidence(r6);
            goto L31
        L28:
            if (Intrinsics.areEqual(r8, URL_PATTERN) == false) goto L30;
            r9 = getUrlConfidence(r6);
            goto L31
        L30:
            r9 = getCustomPatternConfidence(r6, r8);
            goto L31
        L34:
            r5 = r4;
            goto L35
        L12:
            if (Intrinsics.areEqual(r2, EMAIL_PATTERN) == false) goto L15;
            r3 = getEmailConfidence(r6);
            goto L18
        L15:
            if (Intrinsics.areEqual(r2, URL_PATTERN) == false) goto L17;
            r3 = getUrlConfidence(r6);
            goto L18
        L17:
            r3 = getCustomPatternConfidence(r6, r2);
            goto L18
        }

        private final int getPhoneNumberConfidence(String r8) {
            String r7 = StringsKt.replace$default(r8, "[^0-9]", "", false, 4, null);
            if (r7.length() >= 7) goto L7;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ClipboardReader.TAG, "getPhoneNumberConfidence: digitsOnly.length = [" + r7.length() + "] < 7, text = [" + r8 + DefaultContactListAdapter.SNIPPET_END_MATCH);
            return 0;
        L7:
            if (PhoneNumberUtils.isGlobalPhoneNumber(r8) == false) goto L10;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ClipboardReader.TAG, "getPhoneNumberConfidence: isGlobalPhoneNumber = true, text = [" + r8 + DefaultContactListAdapter.SNIPPET_END_MATCH);
            return 100;
        L10:
            int r9 = ContactsUtils.countPhoneNumberDigits(r8);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ClipboardReader.TAG, "getPhoneNumberConfidence: isGlobalPhoneNumber = false, countPhoneNumberDigits = [" + r9 + "], text = [" + r8 + DefaultContactListAdapter.SNIPPET_END_MATCH);
            if (r9 >= 7) goto L13;
            return 0;
        L13:
            return 100;
        }

        private final int getEmailConfidence(String r1) {
            if (Patterns.EMAIL_ADDRESS.matcher(r1).matches() == false) goto L5;
            return 100;
        L5:
            return 0;
        }

        private final int getUrlConfidence(String r1) {
            if (Patterns.WEB_URL.matcher(r1).matches() == false) goto L5;
            return 100;
        L5:
            return 0;
        }

        private final int getCustomPatternConfidence(String r1, Pattern r2) {
            Matcher r0 = r2.matcher(r1);
            if (r0.find() == false) goto L5;
            int r3 = r0.group().length();
            return (r3 * 100) / Math.max(r1.length(), 1);
        L5:
            return 0;
        }
    }

    public static /* synthetic */ void $r8$lambda$TK20QtFLIiHRDGCF_6SR2WaeEOQ(ClipboardReader r0) {
        clipboardListener$lambda$0(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public ClipboardReader(Context r2, PatternConfig r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "patternConfig");
        Intrinsics.checkNotNullParameter(r4, "forbiddenDescriptionTypeList");
        this.context = r2;
        this.patternConfig = r3;
        this.forbiddenDescriptionTypeList = r4;
        this.clipboardManager$delegate = LazyKt.lazy(new ClipboardReader$clipboardManager$2(this));
        this.observers = new LinkedHashSet();
        this.clipboardTimeStamp = -1;
        this.clipboardListener = new ClipboardReader$$ExternalSyntheticLambda0(this);
    }

    public static final /* synthetic */ Context access$getContext$p(ClipboardReader r0) {
        return r0.context;
    }

    public /* synthetic */ ClipboardReader(Context r1, PatternConfig r2, ArrayList r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = PatternConfig.Companion.getDEFAULT();
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = new ArrayList();
    L8:
        this(r1, r2, r3);
    }

    private final ClipboardManager getClipboardManager() {
        return (ClipboardManager) this.clipboardManager$delegate.getValue();
    }

    private static final void clipboardListener$lambda$0(ClipboardReader r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.handleClipboardChange();
    }

    public final void enable() {
        if (this.clipboardTimeStamp != (-1)) goto L5;
        this.clipboardTimeStamp = PreferenceManager.getDefaultSharedPreferences(this.context).getLong(SP_KEY_CONTACTS_CLIPBOARD_CHANGE_TIMESTAMP, 0);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "clipboardTimeStamp update = [" + this.clipboardTimeStamp + DefaultContactListAdapter.SNIPPET_END_MATCH);
    L5:
        getClipboardManager().addPrimaryClipChangedListener(this.clipboardListener);
        handleClipboardChange();
    }

    public final void disable() {
        getClipboardManager().removePrimaryClipChangedListener(this.clipboardListener);
        this.observers.clear();
    }

    public final void addObserver(ClipboardObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.observers.add(r2);
    }

    public final void removeObserver(ClipboardObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.observers.remove(r2);
    }

    public final void handleClipboardChange() {
        if (SettingsProviderHelper.INSTANCE.getClipboardReaderEnable(this.context) == true) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "剪切板开关关闭");
        Iterator<T> r5 = this.observers.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        ((ClipboardObserver) r5.next()).onClipboardResult(null, false, "剪切板开关关闭");
        goto L6
    L8:
        return;
    L10:
        if (isClipDescriptionMatchesPatternAndTimeStamp() == true) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "剪切板内容 ClipDescription 不符合配置模式和时间戳");
        Iterator<T> r6 = this.observers.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        ((ClipboardObserver) r6.next()).onClipboardResult(null, false, "剪切板内容 ClipDescription 不符合配置模式和时间戳");
        goto L13
    L15:
        return;
    L16:
        ClipData r0 = getClipboardManager().getPrimaryClip();
        if (r0 != null) goto L21;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "剪切板内容为空 primaryClip");
        return;
    L21:
        if (isClipDataMatches(r0) == true) goto L27;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "剪切板内容不符合预期");
        Iterator<T> r7 = this.observers.iterator();
    L24:
        if (r7.hasNext() == false) goto L26;
        ((ClipboardObserver) r7.next()).onClipboardResult(null, false, "剪切板内容不符合预期");
        goto L24
    L26:
        return;
    L27:
        String r1 = getClipboardText(r0);
        if (r1 != null) goto L30;
        return;
    L30:
        Iterator<T> r8 = this.observers.iterator();
    L32:
        if (r8.hasNext() == false) goto L34;
        ((ClipboardObserver) r8.next()).onClipboardResult(r1, true, "");
        goto L32
    }

    private final boolean isClipDataMatches(ClipData r8) {
        int r0 = r8.getItemCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        CharSequence r3 = r8.getItemAt(r2).getText();
        if (r3 == null) goto L13;
        String r4 = r3.toString();
        if (r4 == null) goto L13;
        int r5 = this.patternConfig.getConfidenceScore(r4);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "isClipDataMatches: text = [" + r4 + "], confidenceScore = [" + r5 + DefaultContactListAdapter.SNIPPET_END_MATCH);
        if (r5 != 100) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        return false;
    }

    private final boolean isClipDescriptionMatchesPatternAndTimeStamp() {
        ClipDescription r2 = getClipboardManager().getPrimaryClipDescription();
        if (r2 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ClipDescription 为空");
        return false;
    L6:
        long r5 = r2.getTimestamp();
        if (this.clipboardTimeStamp != r5) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "剪切板未发生变化 timeStamp = [" + r5 + DefaultContactListAdapter.SNIPPET_END_MATCH);
        return false;
    L10:
        updateClipboardTimeStamp(r5);
        Iterator<T> r6 = this.forbiddenDescriptionTypeList.iterator();
    L12:
        if (r6.hasNext() == false) goto L85;
        String r7 = (String) r6.next();
        if (r2.hasMimeType(r7) == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ClipDescription 不符合预期 " + r7);
        return false;
    L85:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L74
        Iterator<T> r9 = this.patternConfig.getPatterns().iterator();     // Catch: Throwable -> L74
        if (r9.hasNext() == true) goto L20;
        Boolean r10 = null;
    L72:
        Object r0 = Result.m803constructorimpl(r10);     // Catch: Throwable -> L74
    L77:
        if (Result.m809isFailureimpl(r0) == false) goto L79;
        Object r11 = null;
    L80:
        Boolean r12 = (Boolean) r11;
        if (r12 != null) goto L92;
        return true;
    L92:
        return r12.booleanValue();
    L79:
        r11 = r0;
        goto L80
    L20:
        Pattern r13 = (Pattern) r9.next();     // Catch: Throwable -> L74
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "pattern 校验: pattern = [" + r13 + DefaultContactListAdapter.SNIPPET_END_MATCH);     // Catch: Throwable -> L74
        boolean r14 = false;
        if (Intrinsics.areEqual(r13, PatternConfig.Companion.getPHONE_NUMBER_PATTERN()) == false) goto L33;
        float r15 = r2.getConfidenceScore("phone");     // Catch: Throwable -> L74
        StringBuilder r16 = new StringBuilder().append("TextClassifier TYPE_PHONE confidence = [").append(r15).append("], text = [");     // Catch: Throwable -> L74
        ClipData r17 = getClipboardManager().getPrimaryClip();     // Catch: Throwable -> L74
        if (r17 == null) goto L28;
        ClipData.Item r18 = r17.getItemAt(0);     // Catch: Throwable -> L74
        if (r18 == null) goto L28;
        CharSequence r19 = r18.getText();     // Catch: Throwable -> L74
    L29:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r16.append(r19).append(DefaultContactListAdapter.SNIPPET_END_MATCH).toString());     // Catch: Throwable -> L74
        if (r15 > 0.0f) goto L36;
    L37:
        boolean r20 = false;
    L43:
        r10 = Boolean.valueOf(r20);     // Catch: Throwable -> L74
    L45:
        if (r9.hasNext() == false) goto L72;
        Pattern r21 = (Pattern) r9.next();     // Catch: Throwable -> L74
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "pattern 校验: pattern = [" + r21 + DefaultContactListAdapter.SNIPPET_END_MATCH);     // Catch: Throwable -> L74
        if (Intrinsics.areEqual(r21, PatternConfig.Companion.getPHONE_NUMBER_PATTERN()) == false) goto L57;
        float r22 = r2.getConfidenceScore("phone");     // Catch: Throwable -> L74
        StringBuilder r110 = new StringBuilder().append("TextClassifier TYPE_PHONE confidence = [").append(r22).append("], text = [");     // Catch: Throwable -> L74
        ClipData r111 = getClipboardManager().getPrimaryClip();     // Catch: Throwable -> L74
        if (r111 == null) goto L53;
        ClipData.Item r112 = r111.getItemAt(0);     // Catch: Throwable -> L74
        if (r112 == null) goto L53;
        CharSequence r113 = r112.getText();     // Catch: Throwable -> L74
    L54:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r110.append(r113).append(DefaultContactListAdapter.SNIPPET_END_MATCH).toString());     // Catch: Throwable -> L74
        boolean r114 = false;
        if (r22 > 0.0f) goto L61;
    L62:
        boolean r23 = false;
    L68:
        Boolean r24 = Boolean.valueOf(r23);     // Catch: Throwable -> L74
        if (r10.compareTo(r24) >= 0) goto L71;
        r10 = r24;
    L71:
        r14 = r114;
    L61:
        r23 = true;
    L53:
        r113 = null;
        goto L54
    L57:
        r114 = r14;
        if (Intrinsics.areEqual(r21, PatternConfig.Companion.getEMAIL_PATTERN()) == false) goto L64;
        if (r2.getConfidenceScore("email") != 1.0f) goto L62;
    L64:
        if (Intrinsics.areEqual(r21, PatternConfig.Companion.getURL_PATTERN()) == false) goto L62;
        if (r2.getConfidenceScore("url") != 1.0f) goto L62;
    L36:
        r20 = true;
    L28:
        r19 = null;
        goto L29
    L33:
        if (Intrinsics.areEqual(r13, PatternConfig.Companion.getEMAIL_PATTERN()) == false) goto L39;
        if (r2.getConfidenceScore("email") != 1.0f) goto L37;
    L39:
        if (Intrinsics.areEqual(r13, PatternConfig.Companion.getURL_PATTERN()) == false) goto L37;
        if (r2.getConfidenceScore("url") != 1.0f) goto L37;
    L74:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r0 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L77
    }

    private final String getClipboardText(ClipData r4) {
        int r3 = r4.getItemCount();
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L13;
        CharSequence r1 = r4.getItemAt(r0).getText();
        if (r1 == null) goto L12;
        String r2 = r1.toString();
        if (r2 == null) goto L12;
        if ((!StringsKt.isBlank(r2)) == false) goto L12;
        return r2;
    L12:
        r0 = r0 + 1;
        goto L3
    L13:
        return null;
    }

    private final void updateClipboardTimeStamp(long r3) {
        SharedPreferences.Editor r0 = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
        r0.putLong(SP_KEY_CONTACTS_CLIPBOARD_CHANGE_TIMESTAMP, r3);
        r0.apply();
        this.clipboardTimeStamp = r3;
    }
}
