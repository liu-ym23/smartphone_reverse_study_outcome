package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.chatroom.view.NoPaddingTextView;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/MultiPkTextView;", "Lcom/bytedance/android/livesdk/chatroom/view/NoPaddingTextView;", "", "text", "", "setContent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiPkTextView extends NoPaddingTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f138274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pattern f138275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f138276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f138277d;

    public MultiPkTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f138274a = PatternProtector.compile("[^\\d]+");
        this.f138275b = PatternProtector.compile("[\\d]+");
    }

    public final void setContent(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L60:
        setText(r100);
        return;
    L5:
        if (this.f138276c == null) goto L60;
        if (this.f138277d == null) goto L60;
        if (r100 != null) goto L11;
    L27:
        boolean r101 = false;
    L28:
        if (r101 == false) goto L60;
        SpannableStringBuilder r102 = new SpannableStringBuilder(r100);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L33
        Object r104 = Result.m9449constructorimpl(this.f138274a.matcher(r100));     // Catch: Throwable -> L33
    L35:
        Object r105 = null;
        if (Result.m9455isFailureimpl(r104) == false) goto L38;
        r104 = null;
    L38:
        Matcher r106 = (Matcher) r104;
        if (r106 != null) goto L64;
        return;
    L64:
        Object r107 = Result.m9449constructorimpl(this.f138275b.matcher(r100));     // Catch: Throwable -> L43
    L46:
        if (Result.m9455isFailureimpl(r107) == true) goto L49;
        r105 = r107;
    L49:
        Matcher r108 = (Matcher) r105;
        if (r108 != null) goto L53;
        return;
    L53:
        if (r106.find() == false) goto L56;
        t r109 = this.f138276c;
        Intrinsics.checkNotNull(r109);
        r102.setSpan(r109.a(), r106.start(0), r106.end(0), 17);
    L56:
        if (r108.find() == false) goto L58;
        t r110 = this.f138277d;
        Intrinsics.checkNotNull(r110);
        r102.setSpan(r110.a(), r108.start(0), r108.end(0), 17);
        goto L56
    L58:
        setText(r102);
        return;
    L43:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L33:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L11:
        if (TextUtils.isEmpty(r100) == true) goto L27;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L21
        if (this.f138274a.matcher(r100).find() == true) goto L16;
    L18:
        boolean r114 = false;
    L19:
        Object r115 = Result.m9449constructorimpl(Boolean.valueOf(r114));     // Catch: Throwable -> L21
    L23:
        Boolean r116 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r115) == false) goto L26;
        r115 = r116;
    L26:
        r101 = ((Boolean) r115).booleanValue();
        goto L28
    L16:
        if (this.f138275b.matcher(r100).find() == false) goto L18;
        r114 = true;
    L21:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    public MultiPkTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f138274a = PatternProtector.compile("[^\\d]+");
        this.f138275b = PatternProtector.compile("[\\d]+");
    }
}
