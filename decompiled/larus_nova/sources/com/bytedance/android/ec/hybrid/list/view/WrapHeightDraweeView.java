package com.bytedance.android.ec.hybrid.list.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/view/WrapHeightDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WrapHeightDraweeView extends SimpleDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f47425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f47426b;

    public WrapHeightDraweeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f47426b = new f(this);
    }

    @Override // com.facebook.drawee.view.SimpleDraweeView
    public final void setImageURI(Uri r100, Object r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r100, this.f47425a) == false) goto L7;
        return;
    L7:
        this.f47425a = r100;
        AbstractDraweeControllerBuilder r102 = getControllerBuilder();
        if (r102 == null) goto L12;
        setController(((PipelineDraweeControllerBuilder) r102).setControllerListener(this.f47426b).setCallerContext(r101).setUri(r100).setOldController(getController()).build());
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder");
    }

    public WrapHeightDraweeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f47426b = new f(this);
    }
}
