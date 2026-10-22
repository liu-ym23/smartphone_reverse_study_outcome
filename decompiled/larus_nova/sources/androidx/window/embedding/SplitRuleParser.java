package androidx.window.embedding;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J%\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ \u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002¨\u0006\u001f"}, d2 = {"Landroidx/window/embedding/SplitRuleParser;", "", "()V", "buildClassName", "Landroid/content/ComponentName;", "pkg", "", "clsSeq", "", "parseActivityFilter", "Landroidx/window/embedding/ActivityFilter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "parser", "Landroid/content/res/XmlResourceParser;", "parseSplitActivityRule", "Landroidx/window/embedding/ActivityRule;", "parseSplitPairFilter", "Landroidx/window/embedding/SplitPairFilter;", "parseSplitPairRule", "Landroidx/window/embedding/SplitPairRule;", "parseSplitPlaceholderRule", "Landroidx/window/embedding/SplitPlaceholderRule;", "parseSplitRules", "", "Landroidx/window/embedding/EmbeddingRule;", "staticRuleResourceId", "", "parseSplitRules$window_release", "parseSplitXml", "splitResourceId", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitRuleParser {
    public SplitRuleParser() {
    }

    private final ComponentName buildClassName(String r110, CharSequence r111) {
        if (r111 == null) goto L24;
        if (r111.length() != 0) goto L6;
        boolean r100 = true;
    L7:
        if (r100 == true) goto L24;
        String r112 = r111.toString();
        if (r112.charAt(0) == '.') goto L11;
        int r101 = StringsKt.indexOf$default(r112, '/', 0, false, 6, null);
        if (r101 <= 0) goto L16;
        r110 = r112.substring(0, r101);
        r112 = r112.substring(r101 + 1);
    L16:
        if (Intrinsics.areEqual(r112, "*") == true) goto L22;
        if (StringsKt.indexOf$default(r112, '.', 0, false, 6, null) >= 0) goto L22;
        return new ComponentName(r110, r110 + '.' + r112);
    L22:
        return new ComponentName(r110, r112);
    L11:
        return new ComponentName(r110, r110 + r112);
    L6:
        r100 = false;
    L24:
        throw new IllegalArgumentException("Activity name must not be null");
    }

    private final ActivityFilter parseActivityFilter(Context r100, XmlResourceParser r101) {
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.activityAction, R.attr.activityName}, 0, 0);
        String r103 = r102.getString(1);
        String r104 = r102.getString(0);
        return new ActivityFilter(buildClassName(r100.getApplicationContext().getPackageName(), r103), r104);
    }

    private final ActivityRule parseSplitActivityRule(Context r100, XmlResourceParser r101) {
        return new ActivityRule(SetsKt.emptySet(), r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.alwaysExpand}, 0, 0).getBoolean(0, false));
    }

    private final SplitPairFilter parseSplitPairFilter(Context r100, XmlResourceParser r101) {
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.primaryActivityName, R.attr.secondaryActivityAction, R.attr.secondaryActivityName}, 0, 0);
        String r103 = r102.getString(0);
        String r104 = r102.getString(2);
        String r105 = r102.getString(1);
        String r106 = r100.getApplicationContext().getPackageName();
        return new SplitPairFilter(buildClassName(r106, r103), buildClassName(r106, r104), r105);
    }

    private final SplitPairRule parseSplitPairRule(Context r110, XmlResourceParser r111) {
        TypedArray r112 = r110.getTheme().obtainStyledAttributes(r111, new int[]{R.attr.clearTop, R.attr.finishPrimaryWithSecondary, R.attr.finishSecondaryWithPrimary, R.attr.splitLayoutDirection, R.attr.splitMinSmallestWidth, R.attr.splitMinWidth, R.attr.splitRatio}, 0, 0);
        float r100 = r112.getFloat(6, 0.0f);
        int r101 = (int) r112.getDimension(5, 0.0f);
        int r102 = (int) r112.getDimension(4, 0.0f);
        int r113 = r112.getInt(3, 3);
        int r103 = r112.getInt(1, 0);
        int r104 = r112.getInt(2, 1);
        boolean r105 = r112.getBoolean(0, false);
        return new SplitPairRule(SetsKt.emptySet(), r103, r104, r105, r101, r102, r100, r113);
    }

    private final SplitPlaceholderRule parseSplitPlaceholderRule(Context r110, XmlResourceParser r111) {
        TypedArray r112 = r110.getTheme().obtainStyledAttributes(r111, new int[]{R.attr.finishPrimaryWithSecondary, R.attr.placeholderActivityName, R.attr.splitLayoutDirection, R.attr.splitMinSmallestWidth, R.attr.splitMinWidth, R.attr.splitRatio, R.attr.stickyPlaceholder}, 0, 0);
        String r100 = r112.getString(1);
        boolean r101 = r112.getBoolean(6, false);
        int r102 = r112.getInt(0, 1);
        float r113 = r112.getFloat(5, 0.0f);
        int r103 = (int) r112.getDimension(4, 0.0f);
        int r114 = (int) r112.getDimension(3, 0.0f);
        int r115 = r112.getInt(2, 3);
        ComponentName r116 = buildClassName(r110.getApplicationContext().getPackageName(), r100);
        return new SplitPlaceholderRule(SetsKt.emptySet(), new Intent().setComponent(r116), r101, r102, r103, r114, r113, r115);
    }

    private final Set<EmbeddingRule> parseSplitXml(Context r100, int r110) {
        XmlResourceParser r111 = r100.getResources().getXml(r110);     // Catch: Resources.NotFoundException -> L59
        HashSet r101 = new HashSet();
        int r102 = r111.getDepth();
        int r103 = r111.next();
        ActivityRule r104 = null;
        SplitPairRule r105 = null;
        SplitPlaceholderRule r106 = null;
    L6:
        if (r103 == 1) goto L58;
        if (r103 != 3) goto L12;
        if (r111.getDepth() <= r102) goto L58;
    L12:
        if (r111.getEventType() != 2) goto L57;
        if (Intrinsics.areEqual("split-config", r111.getName()) == true) goto L57;
        String r107 = r111.getName();
        if (r107 != null) goto L19;
    L56:
        r103 = r111.next();
        goto L6
    L19:
        switch(r107.hashCode()) {
            case 511422343: goto L44;
            case 520447504: goto L39;
            case 1579230604: goto L32;
            case 1793077963: goto L27;
            case 2050988213: goto L22;
            default: goto L56;
        };
    L22:
        if (r107.equals("SplitPlaceholderRule") == false) goto L56;
        SplitPlaceholderRule r108 = parseSplitPlaceholderRule(r100, r111);
        r101.add(r108);
        r104 = null;
        r105 = null;
    L25:
        r106 = r108;
        goto L56
    L27:
        if (r107.equals("ActivityRule") == false) goto L56;
        ActivityRule r109 = parseSplitActivityRule(r100, r111);
        r101.add(r109);
        r105 = null;
        r106 = null;
    L30:
        r104 = r109;
        goto L56
    L32:
        if (r107.equals("SplitPairFilter") == false) goto L56;
        if (r105 == null) goto L37;
        SplitPairFilter r112 = parseSplitPairFilter(r100, r111);
        r101.remove(r105);
        SplitPairRule r113 = r105.plus$window_release(r112);
        r101.add(r113);
    L42:
        r105 = r113;
        goto L56
    L37:
        throw new IllegalArgumentException("Found orphaned SplitPairFilter outside of SplitPairRule");
    L39:
        if (r107.equals("SplitPairRule") == false) goto L56;
        r113 = parseSplitPairRule(r100, r111);
        r101.add(r113);
        r104 = null;
        r106 = null;
        goto L42
    L44:
        if (r107.equals("ActivityFilter") == false) goto L56;
        if (r104 != null) goto L51;
        if (r106 != null) goto L51;
        throw new IllegalArgumentException("Found orphaned ActivityFilter");
    L51:
        ActivityFilter r114 = parseActivityFilter(r100, r111);
        if (r104 == null) goto L54;
        r101.remove(r104);
        r109 = r104.plus$window_release(r114);
        r101.add(r109);
        goto L30
    L54:
        if (r106 == null) goto L56;
        r101.remove(r106);
        r108 = r106.plus$window_release(r114);
        r101.add(r108);
    L57:
        r103 = r111.next();
    L58:
        return r101;
    L59:
        return null;
    }

    public final Set<EmbeddingRule> parseSplitRules$window_release(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return parseSplitXml(r100, r101);
    }
}
