package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import jd3.h0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0017\u0010\u0007\u001a\u0013\u0018\u00010\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0017\u0010\n\u001a\u0013\u0018\u00010\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0017\u0010\f\u001a\u0013\u0018\u00010\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0017\u0010\u000e\u001a\u0013\u0018\u00010\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0015\u0010\u0010\u001a\u00110\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0015\u0010\u0013\u001a\u00110\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"<anonymous>", "", "p1", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", PerfLog.PARAM_KEY_CONTEXT_ID, "p2", "", "productId", "p3", "orderId", "p4", "commentId", "p5", "commentRank", "p6", "", "commentModule", "p7", "tagType", AbsMethodDelegate.TAG_INVOKE, "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class CommentHeaderView$mobProductCommentTag$1$click$1 extends FunctionReferenceImpl implements Function7<Context, Long, Long, Long, Long, String, String, Unit> {
    public CommentHeaderView$mobProductCommentTag$1$click$1(t53.b r100) {
        super(7, r100, t53.b.class, "mobProductCommentTagClick", "mobProductCommentTagClick(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context r100, Long r101, Long r102, Long r103, Long r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r105, "p6");
        Intrinsics.checkNotNullParameter(r106, "p7");
        ((t53.b) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r105, "commentModule");
        Intrinsics.checkNotNullParameter(r106, "tagType");
        h0 r107 = new h0();
        r107.f498332a = r101;
        r107.f498333b = r102;
        r107.f498334c = r103;
        r107.f498335d = r104;
        r107.f498336e = r105;
        r107.f498337f = "comment_page";
        r107.f498338g = r106;
        t53.e.c(r107, r100, null);
    }

    @Override // kotlin.jvm.functions.Function7
    public /* bridge */ /* synthetic */ Unit invoke(Context r100, Long r110, Long r111, Long r112, Long r113, String r114, String r115) {
        invoke2(r100, r110, r111, r112, r113, r114, r115);
        return Unit.INSTANCE;
    }
}
