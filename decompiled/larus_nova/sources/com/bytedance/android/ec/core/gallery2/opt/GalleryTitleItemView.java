package com.bytedance.android.ec.core.gallery2.opt;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002R*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/opt/GalleryTitleItemView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "update", "", "value", "b", "I", "getCheckPos", "()I", "setCheckPos", "(I)V", "checkPos", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryTitleItemView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f44066b;

    public GalleryTitleItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GalleryTitleItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final void update() {
        int r100 = this.f44066b;
        int r101 = this.f44065a;
        if (r100 != r101) goto L5;
        ExtensionsKt.visible(this);
        setTextColor(-1);
        return;
    L5:
        if (r100 <= 0) goto L8;
        if (r101 <= 0) goto L8;
        ExtensionsKt.visible(this);
    L9:
        Integer r102 = s.b("#9B9DA9");
        if (r102 == null) goto L14;
        setTextColor(r102.intValue());
        return;
    L14:
        return;
    L8:
        setVisibility(4);
        goto L9
    }

    public final int getCheckPos() {
        return this.f44066b;
    }

    public final void setCheckPos(int r100) {
        this.f44066b = r100;
        update();
    }

    public GalleryTitleItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f44065a = -1;
        setTextSize(14.0f);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setGravity(19);
        setMaxWidth(vf4.a.b(180));
        Integer r103 = s.b("#9B9DA9");
        if (r103 == null) goto L5;
        setTextColor(r103.intValue());
    L5:
        setLineSpacing(vf4.a.b(3), 1.0f);
    }

    public /* synthetic */ GalleryTitleItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
