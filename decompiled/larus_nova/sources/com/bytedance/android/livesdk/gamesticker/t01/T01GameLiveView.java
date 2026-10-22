package com.bytedance.android.livesdk.gamesticker.t01;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.model.r3;
import com.bytedance.android.livesdk.chatroom.model.s3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u0004\u0018\u00010\u0003R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0016\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u001b\u0010\u001c\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameLiveView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/livesdk/chatroom/model/r3;", "liveInfo", "", "setLiveInfo", "Landroid/view/View;", "getView", "getLiveInfo", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getLeftTextView", "()Landroid/widget/TextView;", "leftTextView", "b", "getLeftTagView", "leftTagView", "c", "getMidDividerView", "()Landroid/view/View;", "midDividerView", "d", "getRightTextView", "rightTextView", "e", "getRightTagView", "rightTagView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class T01GameLiveView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f125709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f125710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f125711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f125712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f125713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r3 f125714f;

    public T01GameLiveView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public T01GameLiveView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final TextView getLeftTagView() {
        return (TextView) this.f125710b.getValue();
    }

    private final TextView getLeftTextView() {
        return (TextView) this.f125709a.getValue();
    }

    private final View getMidDividerView() {
        return (View) this.f125711c.getValue();
    }

    private final TextView getRightTagView() {
        return (TextView) this.f125713e.getValue();
    }

    private final TextView getRightTextView() {
        return (TextView) this.f125712d.getValue();
    }

    public View getView() {
        return this;
    }

    public final r3 getLiveInfo() {
        return this.f125714f;
    }

    public final void setLiveInfo(r3 r100) {
        this.f125714f = r100;
        if (r100 == null) goto L5;
        List<s3> r101 = r100.c();
    L6:
        List<s3> r102 = r101;
        int r103 = 0;
        if (r102 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == true) goto L23;
        if (r100 == null) goto L19;
        List<s3> r105 = r100.c();
        if (r105 == null) goto L19;
        int r106 = r105.size();
    L21:
        if (r106 <= 0) goto L23;
        boolean r107 = true;
    L25:
        if (r107 == true) goto L29;
        setVisibility(8);
        return;
    L29:
        if (r100 == null) goto L52;
        List<s3> r108 = r100.c();
        if (r108 == null) goto L52;
        if (r108.size() != 1) goto L36;
        a(getRightTextView(), ((s3) ListProtector.get(r108, 0)).c());
        a(getRightTagView(), ((s3) ListProtector.get(r108, 0)).b());
        a(getLeftTextView(), "");
        a(getLeftTagView(), "");
        goto L52
    L36:
        if (r108.size() != 2) goto L52;
        Iterator<T> r109 = r108.iterator();
    L39:
        if (r109.hasNext() == false) goto L52;
        s3 r110 = (s3) r109.next();
        Integer r111 = r110.a();
        if (r111 == null) goto L46;
        if (r111.intValue() != 1) goto L46;
        a(getRightTextView(), r110.c());
        a(getRightTagView(), r110.b());
    L46:
        Integer r112 = r110.a();
        if (r112 == null) goto L39;
        if (r112.intValue() != 2) goto L39;
        a(getLeftTextView(), r110.c());
        a(getLeftTagView(), r110.b());
    L52:
        setVisibility(0);
        View r113 = getMidDividerView();
        if (r100 == null) goto L57;
        List<s3> r114 = r100.c();
        if (r114 == null) goto L57;
        int r115 = r114.size();
    L58:
        if (r115 >= 2) goto L61;
        r103 = 8;
    L61:
        r113.setVisibility(r103);
        return;
    L57:
        r115 = 0;
    L19:
        r106 = 0;
    L23:
        r107 = false;
        goto L25
    L9:
        if (r102.isEmpty() == true) goto L12;
        r104 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public static void a(TextView r100, String r101) {
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        r100.setVisibility(8);
        r100.setText("");
        return;
    L11:
        r100.setVisibility(0);
        r100.setText(r101);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public T01GameLiveView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f125709a = LazyKt.lazy(new T01GameLiveView$leftTextView$2(this));
        this.f125710b = LazyKt.lazy(new T01GameLiveView$leftTagView$2(this));
        this.f125711c = LazyKt.lazy(new T01GameLiveView$midDividerView$2(this));
        this.f125712d = LazyKt.lazy(new T01GameLiveView$rightTextView$2(this));
        this.f125713e = LazyKt.lazy(new T01GameLiveView$rightTagView$2(this));
        LayoutInflater.from(r100).inflate(R.layout.ttlive_game_t01_live_view, this);
    }

    public /* synthetic */ T01GameLiveView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
