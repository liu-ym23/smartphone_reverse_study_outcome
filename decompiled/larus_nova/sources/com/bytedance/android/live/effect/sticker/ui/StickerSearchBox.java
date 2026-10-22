package com.bytedance.android.live.effect.sticker.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0006R#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0017\u001a\n \r*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerSearchBox;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/live/effect/sticker/ui/j;", "listener", "", "setOnChangeListener", "", "hint", "setSearchHint", "Landroid/view/View$OnKeyListener;", "setEditTextOnKeyListener", "getContent", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getEditText", "()Landroid/widget/EditText;", "editText", "Landroid/widget/ImageView;", "b", "getBtnClear", "()Landroid/widget/ImageView;", "btnClear", "Landroid/view/View;", "c", "getEditCover", "()Landroid/view/View;", "editCover", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerSearchBox extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f68487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f68488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f68489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f68490d;

    public StickerSearchBox(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StickerSearchBox(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ImageView getBtnClear() {
        return (ImageView) this.f68488b.getValue();
    }

    private final View getEditCover() {
        return (View) this.f68489c.getValue();
    }

    private final EditText getEditText() {
        return (EditText) this.f68487a.getValue();
    }

    public final void Y5() {
        j r100 = this.f68490d;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public final void V5() {
        getEditCover().setVisibility(0);
    }

    public final void Z5() {
        getEditText().setText(getEditText().getText());
        getEditText().setSelection(getEditText().getText().length());
    }

    public final String getContent() {
        return getEditText().getText().toString();
    }

    public static final /* synthetic */ ImageView R5(StickerSearchBox r100) {
        return r100.getBtnClear();
    }

    public static final /* synthetic */ EditText S5(StickerSearchBox r100) {
        return r100.getEditText();
    }

    public final void T5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        getEditText().setText(r100);
        getEditText().setSelection(getEditText().getText().length());
    }

    public final void U5(boolean r100) {
        getEditText().setCursorVisible(r100);
    }

    public final void setEditTextOnKeyListener(View.OnKeyListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getEditText().setOnKeyListener(r100);
    }

    public final void setOnChangeListener(j r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f68490d = r100;
    }

    public final void setSearchHint(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        getEditText().setHint(r100);
    }

    public StickerSearchBox(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f68487a = LazyKt.lazy(new StickerSearchBox$editText$2(this));
        this.f68488b = LazyKt.lazy(new StickerSearchBox$btnClear$2(this));
        this.f68489c = LazyKt.lazy(new StickerSearchBox$editCover$2(this));
        ViewGroup.inflate(r100, R.layout.ttlive_effect_sticker_search_box, this);
        getEditText().addTextChangedListener(new p(this));
        getEditText().setOnClickListener(new q(this));
        getEditCover().setOnClickListener(new r(this));
        getEditText().setOnFocusChangeListener(new s(this));
        getBtnClear().setOnClickListener(new t(this));
    }

    public /* synthetic */ StickerSearchBox(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
