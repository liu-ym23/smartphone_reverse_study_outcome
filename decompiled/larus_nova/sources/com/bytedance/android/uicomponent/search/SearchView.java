package com.bytedance.android.uicomponent.search;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.uicomponent.input.view.SingleLineInputView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import fm3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pm3.b;
import pm3.c;
import qm3.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/uicomponent/search/SearchView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "listener", "", "setSearchBarOnClickListener", "Lqm3/a;", "setOnCancelListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f187738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SingleLineInputView f187739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f187740c;

    public final void setOnCancelListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public final void setSearchBarOnClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f187740c = r100;
    }

    public SearchView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributes");
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.uicomponent_search_view, this, true);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.focusable, android.R.attr.maxWidth, android.R.attr.inputType, android.R.attr.imeOptions, R.attr.closeIcon, R.attr.commitIcon, R.attr.defaultQueryHint, R.attr.goIcon, R.attr.iconifiedByDefault, R.attr.layout, R.attr.queryBackground, R.attr.queryHint, R.attr.searchHintIcon, R.attr.searchIcon, R.attr.showCancelBtn, R.attr.submitBackground, R.attr.suggestionRowLayout, R.attr.voiceIcon});
        boolean r103 = r102.getBoolean(14, false);
        r102.recycle();
        this.f187739b = (SingleLineInputView) findViewById(R.id.search_view_input);
        ((RelativeLayout) findViewById(R.id.search_view_container)).setOnClickListener(new pm3.a(this));
        ImageView r104 = new ImageView(getContext());
        int r105 = (int) e.a(getContext(), 18.0f);
        r104.setLayoutParams(new ViewGroup.LayoutParams(r105, r105));
        r104.setPadding(0, 0, (int) e.a(getContext(), 4.0f), 0);
        r104.setImageResource(R.drawable.uicomponent_ic_search);
        SingleLineInputView r106 = this.f187739b;
        if (r106 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L5:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r104, "view");
        FrameLayout r107 = r106.f187683o;
        if (r107 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPreCusContainer");
    L8:
        r107.addView(r104);
        TextView r108 = (TextView) findViewById(R.id.search_view_cancel);
        this.f187738a = r108;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mCancelTv");
    L11:
        r108.setOnClickListener(new b(this));
        if (r103 == false) goto L17;
        TextView r109 = this.f187738a;
        if (r109 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mCancelTv");
    L16:
        r109.setVisibility(0);
        return;
    L17:
        SingleLineInputView r110 = this.f187739b;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L20:
        EditText r111 = r110.f187673e;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L23:
        r111.setEnabled(false);
        SingleLineInputView r112 = this.f187739b;
        if (r112 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L26:
        r112.h(false);
        SingleLineInputView r113 = this.f187739b;
        if (r113 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L29:
        r113.getEditText().setMovementMethod(null);
        SingleLineInputView r114 = this.f187739b;
        if (r114 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L32:
        r114.getEditText().setKeyListener(null);
        TextView r115 = this.f187738a;
        if (r115 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mCancelTv");
    L35:
        r115.setVisibility(8);
        SingleLineInputView r116 = this.f187739b;
        if (r116 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L38:
        r116.setOnClickListener(new c(this));
    }
}
