package com.bytedance.android.livesdk.widget.board;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/widget/board/ExpressionContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/interactivity/api/expression/j;", "onCommentSendDelegate$delegate", "Lcom/bytedance/live/datacontext/p;", "getOnCommentSendDelegate", "()Lcom/bytedance/live/datacontext/n;", "onCommentSendDelegate", "Lcom/bytedance/live/datacontext/m;", "", "sectionShow$delegate", "getSectionShow", "()Lcom/bytedance/live/datacontext/m;", "sectionShow", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExpressionContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p onCommentSendDelegate$delegate;
    private final p sectionShow$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ExpressionContext.class, "onCommentSendDelegate", "getOnCommentSendDelegate()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ExpressionContext.class, "sectionShow", "getSectionShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final n<com.bytedance.android.livesdk.interactivity.api.expression.j> getOnCommentSendDelegate() {
        return (n) this.onCommentSendDelegate$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> getSectionShow() {
        return (m) this.sectionShow$delegate.a(this, $$delegatedProperties[1]);
    }

    public ExpressionContext() {
        this.onCommentSendDelegate$delegate = q.c(this);
        this.sectionShow$delegate = q.d(this, Boolean.FALSE);
    }
}
