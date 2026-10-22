package com.bytedance.android.live.liveinteract.voicechat.fight.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import ck0.b;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.widget.GradientTextView;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/fight/view/FightTitleTextView;", "Lcom/bytedance/android/livesdk/widget/GradientTextView;", "", "text", "", "setPkTitle", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FightTitleTextView extends GradientTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pattern f80284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Pattern f80285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f80286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f80287g;

    public static final class a {
    }

    static {
    }

    public FightTitleTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f80284d = PatternProtector.compile("[^\\d]+");
        this.f80285e = PatternProtector.compile("[\\d]+");
    }

    public final void setPkTitle(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L39:
        setText(r100);
        return;
    L5:
        if (this.f80286f == null) goto L39;
        if (this.f80287g == null) goto L39;
        if (r100 != null) goto L11;
    L18:
        boolean r101 = false;
    L19:
        if (r101 == false) goto L39;
        SpannableStringBuilder r102 = new SpannableStringBuilder(r100);
        Matcher r103 = this.f80284d.matcher(r100);     // Catch: Exception -> L36
        if (r103 != null) goto L25;
        return;
    L25:
        Matcher r104 = this.f80285e.matcher(r100);     // Catch: Exception -> L36
        if (r104 != null) goto L29;
        return;
    L29:
        if (r103.find() == false) goto L32;
        b r105 = this.f80286f;     // Catch: Exception -> L36
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L36
        r102.setSpan(r105.a(), r103.start(0), r103.end(0), 17);     // Catch: Exception -> L36
    L32:
        if (r104.find() == false) goto L34;
        b r106 = this.f80287g;     // Catch: Exception -> L36
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L36
        r102.setSpan(r106.a(), r104.start(0), r104.end(0), 17);     // Catch: Exception -> L36
        goto L32
    L34:
        setText(r102);     // Catch: Exception -> L36
        return;
    L36:
        e = move-exception;
        ALogger.e("FightTitleTextView", "setPkTitle make exception: " + e.getMessage());
        return;
    L11:
        if (TextUtils.isEmpty(r100) == true) goto L18;
        if (this.f80284d.matcher(r100).find() == false) goto L18;
        if (this.f80285e.matcher(r100).find() == false) goto L18;
        r101 = true;
        goto L19
    }

    public FightTitleTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f80284d = PatternProtector.compile("[^\\d]+");
        this.f80285e = PatternProtector.compile("[\\d]+");
    }
}
