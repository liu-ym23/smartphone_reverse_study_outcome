package com.bytedanceos.appstore.buss.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedanceos.appstore.buss.entity.TvGradeScoreEntity;
import com.bytedanceos.appstore.buss.entity.TvGradeWrap;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.d0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ=\u0010\u0013\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0015\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/AppGradeView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "", ServerElements.SCORES, ServerElements.COMMENTS, "Lcom/bytedanceos/appstore/buss/entity/TvGradeWrap;", ServerElements.COMMENT, "", "resId", "", "isShowNext", "", "a", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedanceos/appstore/buss/entity/TvGradeWrap;Ljava/lang/Integer;Z)V", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Z", "Lx7/d0;", "Lx7/d0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppGradeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f9046a;

    public AppGradeView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        d0 r12 = d0.c(LayoutInflater.from(r10), this, true);
        q.f(r12, "inflate(...)");
        this.f9046a = r12;
    }

    public final void a(String r10, String r11, TvGradeWrap r12, Integer r13, boolean r14) {
        if (b(r10, r11, r13) == true) goto L5;
        return;
    L5:
        if (r12 == null) goto L12;
        String r15 = r12.getCount();
        if (r15 == null) goto L12;
        Float r16 = m.f(r15);
        if (r16 == null) goto L12;
        int r17 = (int) r16.floatValue();
        this.f9046a.f25526k.setMax(r17);
        this.f9046a.f25527l.setMax(r17);
        this.f9046a.f25528m.setMax(r17);
        this.f9046a.f25529n.setMax(r17);
        this.f9046a.f25530o.setMax(r17);
    L12:
        if (r12 == null) goto L50;
        List<TvGradeScoreEntity> r18 = r12.getScore();
        if (r18 == null) goto L50;
        TvGradeScoreEntity r19 = r18.get(4);
        if (r19 == null) goto L22;
        String r20 = r19.getCount();
        if (r20 == null) goto L22;
        Float r21 = m.f(r20);
        if (r21 == null) goto L22;
        int r22 = (int) r21.floatValue();
        this.f9046a.f25526k.setProgress(r22);
    L22:
        TvGradeScoreEntity r23 = r18.get(3);
        if (r23 == null) goto L29;
        String r24 = r23.getCount();
        if (r24 == null) goto L29;
        Float r25 = m.f(r24);
        if (r25 == null) goto L29;
        int r26 = (int) r25.floatValue();
        this.f9046a.f25527l.setProgress(r26);
    L29:
        TvGradeScoreEntity r27 = r18.get(2);
        if (r27 == null) goto L36;
        String r28 = r27.getCount();
        if (r28 == null) goto L36;
        Float r29 = m.f(r28);
        if (r29 == null) goto L36;
        int r30 = (int) r29.floatValue();
        this.f9046a.f25528m.setProgress(r30);
    L36:
        TvGradeScoreEntity r31 = r18.get(1);
        if (r31 == null) goto L43;
        String r32 = r31.getCount();
        if (r32 == null) goto L43;
        Float r33 = m.f(r32);
        if (r33 == null) goto L43;
        int r34 = (int) r33.floatValue();
        this.f9046a.f25529n.setProgress(r34);
    L43:
        TvGradeScoreEntity r35 = r18.get(0);
        if (r35 == null) goto L50;
        String r36 = r35.getCount();
        if (r36 == null) goto L50;
        Float r37 = m.f(r36);
        if (r37 == null) goto L50;
        int r38 = (int) r37.floatValue();
        this.f9046a.f25530o.setProgress(r38);
    L50:
        if (r14 == false) goto L52;
        this.f9046a.f25520e.setVisibility(0);
        ViewGroup.LayoutParams r39 = this.f9046a.f25518c.getLayoutParams();
        r39.width = getResources().getDimensionPixelSize(R.dimen.tv_comment_grade_layout_default);
        return;
    L52:
        this.f9046a.f25520e.setVisibility(8);
        ViewGroup.LayoutParams r40 = this.f9046a.f25518c.getLayoutParams();
        r40.width = getResources().getDimensionPixelSize(R.dimen.tv_comment_grade_layout_full);
    }

    public final boolean b(String r10, String r11, Integer r12) {
        if (TextUtils.isEmpty(r11) == true) goto L25;
        if (r11 == null) goto L6;
        Float r13 = m.f(r11);
    L7:
        if (r13 == null) goto L25;
        Float r14 = m.f(r11);
        if (r14 != null) goto L11;
    L13:
        this.f9046a.f25532q.setVisibility(8);
        this.f9046a.f25518c.setVisibility(0);
        if (TextUtils.isEmpty(r10) == false) goto L16;
        this.f9046a.f25533r.setVisibility(8);
    L18:
        if (TextUtils.isEmpty(r11) == false) goto L20;
        this.f9046a.f25531p.setVisibility(8);
    L21:
        if (r12 == null) goto L27;
        int r15 = r12.intValue();
        this.f9046a.f25519d.setImageResource(r15);
        return true;
    L27:
        return true;
    L20:
        this.f9046a.f25531p.setText(getContext().getString(R.string.comment_num, new Object[]{r11}));
        goto L21
    L16:
        this.f9046a.f25533r.setText(r10);
        goto L18
    L11:
        if (((int) r14.floatValue()) != 0) goto L13;
    L6:
        r13 = null;
    L25:
        this.f9046a.f25532q.setVisibility(0);
        this.f9046a.f25518c.setVisibility(8);
        return false;
    }

    public AppGradeView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null);
    }
}
