package com.android.server.selinux;

import android.text.TextUtils;
import android.util.Slog;
import com.android.server.audio.AudioService$$ExternalSyntheticLambda29;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes3.dex */
class SelinuxAuditLogBuilder {
    private static final Matcher NO_OP_MATCHER = null;
    private static final String PATH_PATTERN = "\"(?<path>/\\w+(/\\w+)?)(/\\w+)*\"";
    private static final String TAG = "SelinuxAuditLogs";
    private static final String TCONTEXT_PATTERN = "u:object_r:(?<ttype>\\w+):s0(:c)?(?<tcategories>((,c)?\\d+)+)*";
    private final SelinuxAuditLog mAuditLog;
    final Matcher mPathMatcher;
    final Matcher mScontextMatcher;
    final Matcher mTcontextMatcher;
    private Iterator<String> mTokens;

    static class SelinuxAuditLog {
        boolean mGranted;
        String mPath;
        String[] mPermissions;
        boolean mPermissive;
        int[] mSCategories;
        String mSType;
        int[] mTCategories;
        String mTClass;
        String mTType;

        /* JADX INFO: renamed from: -$$Nest$mreset, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8068$$Nest$mreset(SelinuxAuditLog r0) {
            r0.reset();
        }

        SelinuxAuditLog() {
            this.mGranted = false;
            this.mPermissions = null;
            this.mSType = null;
            this.mSCategories = null;
            this.mTType = null;
            this.mTCategories = null;
            this.mTClass = null;
            this.mPath = null;
            this.mPermissive = false;
        }

        private void reset() {
            this.mGranted = false;
            this.mPermissions = null;
            this.mSType = null;
            this.mSCategories = null;
            this.mTType = null;
            this.mTCategories = null;
            this.mTClass = null;
            this.mPath = null;
            this.mPermissive = false;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$RmLrRR-sNq61_piSupkC9JV2u9c, reason: not valid java name */
    public static /* synthetic */ String[] m8067$r8$lambda$RmLrRRsNq61_piSupkC9JV2u9c(String r0) {
        return lambda$reset$0(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$xY0K9yOHYFVyQx0D3n8FFhBOhmU(int r0) {
        return lambda$build$1(r0);
    }

    static {
        NO_OP_MATCHER = Pattern.compile("no-op^").matcher("");
    }

    SelinuxAuditLogBuilder(String auditDomain) {
        this.mAuditLog = new SelinuxAuditLog();
        Matcher scontextMatcher = NO_OP_MATCHER;
        Matcher tcontextMatcher = NO_OP_MATCHER;
        Matcher pathMatcher = NO_OP_MATCHER;
        scontextMatcher = Pattern.compile(TextUtils.formatSimple("u:r:(?<stype>%s):s0(:c)?(?<scategories>((,c)?\\d+)+)*", new Object[]{auditDomain})).matcher("");     // Catch: PatternSyntaxException -> L5
        tcontextMatcher = Pattern.compile(TCONTEXT_PATTERN).matcher("");     // Catch: PatternSyntaxException -> L5
        pathMatcher = Pattern.compile(PATH_PATTERN).matcher("");     // Catch: PatternSyntaxException -> L5
    L7:
        this.mScontextMatcher = scontextMatcher;
        this.mTcontextMatcher = tcontextMatcher;
        this.mPathMatcher = pathMatcher;
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Invalid pattern, setting every matcher to no-op.", e);
        goto L7
    }

    void reset(String denialString) {
        this.mTokens = Arrays.asList((String[]) Optional.ofNullable(denialString).map(new SelinuxAuditLogBuilder$$ExternalSyntheticLambda0()).orElse(new String[0])).iterator();
        SelinuxAuditLog.m8068$$Nest$mreset(this.mAuditLog);
    }

    private static /* synthetic */ String[] lambda$reset$0(String s) {
        return s.split("\\s+|=");
    }

    SelinuxAuditLog build() {
    L3:
        if (this.mTokens.hasNext() == false) goto L70;
        String token = this.mTokens.next();
        switch(token.hashCode()) {
            case -1335395429: goto L29;
            case -879242876: goto L26;
            case -517618017: goto L23;
            case -488743460: goto L20;
            case 123: goto L17;
            case 3433509: goto L14;
            case 280295099: goto L11;
            case 1254066875: goto L8;
            default: goto L31;
        };
    L31:
        byte r1 = -1;
    L33:
        switch(r1) {
            case 0: goto L67;
            case 1: goto L66;
            case 2: goto L54;
            case 3: goto L51;
            case 4: goto L47;
            case 5: goto L43;
            case 6: goto L40;
            case 7: goto L36;
            default: goto L3;
        };
    L36:
        if (this.mTokens.hasNext() == false) goto L37;
        this.mAuditLog.mPermissive = "1".equals(this.mTokens.next());
        goto L3
    L37:
        return null;
    L40:
        if (nextTokenMatches(this.mPathMatcher) == false) goto L3;
        this.mAuditLog.mPath = this.mPathMatcher.group("path");
        goto L3
    L43:
        if (this.mTokens.hasNext() == false) goto L44;
        this.mAuditLog.mTClass = this.mTokens.next();
        goto L3
    L44:
        return null;
    L47:
        if (nextTokenMatches(this.mTcontextMatcher) == false) goto L48;
        this.mAuditLog.mTType = this.mTcontextMatcher.group("ttype");
        this.mAuditLog.mTCategories = toCategories(this.mTcontextMatcher.group("tcategories"));
        goto L3
    L48:
        return null;
    L51:
        if (nextTokenMatches(this.mScontextMatcher) == false) goto L52;
        this.mAuditLog.mSType = this.mScontextMatcher.group("stype");
        this.mAuditLog.mSCategories = toCategories(this.mScontextMatcher.group("scategories"));
        goto L3
    L52:
        return null;
    L54:
        Stream.Builder<String> permissionsStream = Stream.builder();
        boolean closed = false;
    L55:
        if (closed == true) goto L63;
        if (this.mTokens.hasNext() == false) goto L63;
        String permission = this.mTokens.next();
        if ("}".equals(permission) == true) goto L60;
        permissionsStream.add(permission);
        goto L55
    L60:
        closed = true;
    L63:
        if (closed == false) goto L64;
        this.mAuditLog.mPermissions = (String[]) permissionsStream.build().toArray(new SelinuxAuditLogBuilder$$ExternalSyntheticLambda1());
        goto L3
    L64:
        return null;
    L66:
        this.mAuditLog.mGranted = false;
        goto L3
    L67:
        this.mAuditLog.mGranted = true;
        goto L3
    L8:
        if (token.equals("tcontext") == false) goto L31;
        r1 = 4;
        goto L33
    L11:
        if (token.equals("granted") == false) goto L31;
        r1 = 0;
        goto L33
    L14:
        if (token.equals("path") == false) goto L31;
        r1 = 6;
        goto L33
    L17:
        if (token.equals("{") == false) goto L31;
        r1 = 2;
        goto L33
    L20:
        if (token.equals("scontext") == false) goto L31;
        r1 = 3;
        goto L33
    L23:
        if (token.equals("permissive") == false) goto L31;
        r1 = 7;
        goto L33
    L26:
        if (token.equals("tclass") == false) goto L31;
        r1 = 5;
        goto L33
    L29:
        if (token.equals("denied") == false) goto L31;
        r1 = 1;
        goto L33
    L70:
        return this.mAuditLog;
    }

    private static /* synthetic */ String[] lambda$build$1(int x$0) {
        return new String[x$0];
    }

    boolean nextTokenMatches(Matcher matcher) {
        if (this.mTokens.hasNext() == true) goto L5;
    L7:
        return false;
    L5:
        if (matcher.reset(this.mTokens.next()).matches() == false) goto L7;
        return true;
    }

    static int[] toCategories(String categories) {
        if (categories != null) goto L5;
        return null;
    L5:
        return Arrays.stream(categories.split(",c")).mapToInt(new AudioService$$ExternalSyntheticLambda29()).toArray();
    }
}
