package com.bytedance.android.uicomponent.input.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import fm3.e;
import java.lang.reflect.Field;
import jm3.b;
import jm3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001!B\u0019\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010PJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0006H&J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001fR$\u0010'\u001a\u0004\u0018\u00010\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010\u001a8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00105\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010=\u001a\u0002068\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010D\u001a\u00020\r8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010E\u001a\u0004\u0018\u00010\u001f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006Q"}, d2 = {"Lcom/bytedance/android/uicomponent/input/view/InputView;", "Landroid/widget/FrameLayout;", "", "hint", "", "setErrorHint", "", "type", "setInputType", "getLayoutID", "", "size", "setTextSize", "Landroid/widget/EditText;", "getEditText", "setHint", "value", "setValue", "getValue", "color", "setCursorColor", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "setMaxNumber", "Landroid/text/TextWatcher;", "watcher", "setTextWatcher", "Landroid/widget/TextView$OnEditorActionListener;", "listener", "setOnEditorActionListener", "Landroid/view/View$OnFocusChangeListener;", "setEditFocusChangeListener", "Lim3/a;", "setOnClearListener", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/text/TextWatcher;", "getMTextWatcher", "()Landroid/text/TextWatcher;", "setMTextWatcher", "(Landroid/text/TextWatcher;)V", "mTextWatcher", "b", "Landroid/widget/TextView$OnEditorActionListener;", "getMOnEditorActionListener", "()Landroid/widget/TextView$OnEditorActionListener;", "setMOnEditorActionListener", "(Landroid/widget/TextView$OnEditorActionListener;)V", "mOnEditorActionListener", "c", "Landroid/view/View$OnFocusChangeListener;", "getMOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setMOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "mOnFocusChangeListener", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getMErrorHintTv", "()Landroid/widget/TextView;", "setMErrorHintTv", "(Landroid/widget/TextView;)V", "mErrorHintTv", "e", "Landroid/widget/EditText;", "getMEditText", "()Landroid/widget/EditText;", "setMEditText", "(Landroid/widget/EditText;)V", "mEditText", "mOnClearListener", "Lim3/a;", "getMOnClearListener", "()Lim3/a;", "setMOnClearListener", "(Lim3/a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class InputView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextWatcher f187669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView.OnEditorActionListener f187670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnFocusChangeListener f187671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f187672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EditText f187673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f187674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f187675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f187676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f187677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f187678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f187679k;

    public static final class a {
    }

    static {
    }

    public abstract void b();

    public abstract void c();

    public abstract void d(TypedArray r100);

    public abstract void e();

    public abstract int getLayoutID();

    public final im3.a getMOnClearListener() {
        return null;
    }

    public final void setMOnClearListener(im3.a r100) {
    }

    public final void setOnClearListener(im3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public final void f() {
        if (this.f187675g == 0) goto L24;
        EditText r100 = this.f187673e;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L7:
        r100.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f187675g)});
        if (this.f187678j == false) goto L19;
        TextView r101 = this.f187674f;
        if (r101 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mMaxNumberTv");
    L12:
        r101.setVisibility(0);
        EditText r102 = this.f187673e;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L15:
        int r103 = r102.length();
        TextView r104 = this.f187674f;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mMaxNumberTv");
    L18:
        StringBuilder r105 = new StringBuilder();
        r105.append(r103);
        r105.append('/');
        r105.append(this.f187675g);
        r104.setText(r105.toString());
        return;
    L19:
        TextView r106 = this.f187674f;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mMaxNumberTv");
    L22:
        r106.setVisibility(8);
        return;
    }

    public final EditText getEditText() {
        EditText r100 = this.f187673e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        return r100;
    }

    public final EditText getMEditText() {
        EditText r100 = this.f187673e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        return r100;
    }

    public final TextView getMErrorHintTv() {
        TextView r100 = this.f187672d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorHintTv");
    L5:
        return r100;
    }

    public final String getValue() {
        EditText r100 = this.f187673e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        Editable r101 = r100.getEditableText();
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.toString();
    }

    public final TextView.OnEditorActionListener getMOnEditorActionListener() {
        return this.f187670b;
    }

    public final View.OnFocusChangeListener getMOnFocusChangeListener() {
        return this.f187671c;
    }

    public final TextWatcher getMTextWatcher() {
        return this.f187669a;
    }

    public void a(Editable r100) {
        TextWatcher r101 = this.f187669a;
        if (r101 == null) goto L6;
        r101.afterTextChanged(r100);
        return;
    }

    public final void setCursorColor(int r100) {
        EditText r101 = this.f187673e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        g(r101, r100);
    }

    public final void setEditFocusChangeListener(View.OnFocusChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f187671c = r100;
    }

    public final void setErrorHint(String r100) {
        if (r100 != null) goto L11;
        TextView r101 = this.f187672d;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorHintTv");
    L7:
        r101.setVisibility(8);
        TextView r102 = this.f187672d;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorHintTv");
    L10:
        r102.setText(null);
        b();
        return;
    L11:
        TextView r103 = this.f187672d;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorHintTv");
    L14:
        r103.setVisibility(0);
        TextView r104 = this.f187672d;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorHintTv");
    L17:
        r104.setText(r100);
        c();
    }

    public final void setHint(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        EditText r101 = this.f187673e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        r101.setHint(r100);
    }

    public final void setInputType(int r100) {
        EditText r101 = this.f187673e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        r101.setInputType(r100);
    }

    public final void setMEditText(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187673e = r100;
    }

    public final void setMErrorHintTv(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187672d = r100;
    }

    public final void setMOnEditorActionListener(TextView.OnEditorActionListener r100) {
        this.f187670b = r100;
    }

    public final void setMOnFocusChangeListener(View.OnFocusChangeListener r100) {
        this.f187671c = r100;
    }

    public final void setMTextWatcher(TextWatcher r100) {
        this.f187669a = r100;
    }

    public final void setMaxNumber(int r100) {
        this.f187675g = r100;
        f();
    }

    public final void setOnEditorActionListener(TextView.OnEditorActionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f187670b = r100;
    }

    public final void setTextSize(float r100) {
        this.f187679k = r100;
        EditText r101 = this.f187673e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        r101.setTextSize(1, this.f187679k);
    }

    public final void setTextWatcher(TextWatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
        this.f187669a = r100;
    }

    public final void setValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        EditText r101 = this.f187673e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        r101.setText(r100);
        EditText r102 = this.f187673e;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L8:
        Editable r103 = r102.getText();
        if (r103 == null) goto L15;
        EditText r104 = this.f187673e;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L13:
        r104.setSelection(r103.toString().length());
        return;
    }

    public InputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributes");
        super(r100, r101);
        this.f187679k = 15.0f;
        LayoutInflater.from(r100).inflate(getLayoutID(), this, true);
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.enableClear, R.attr.hint, R.attr.inputTextSize, R.attr.input_type, R.attr.isMustFill, R.attr.maxNumber, R.attr.showNumberLimit, R.attr.title, R.attr.titleOrientation, R.attr.titleWidth, R.attr.value});
        this.f187675g = r102.getInt(5, 0);
        this.f187678j = r102.getBoolean(6, false);
        this.f187677i = r102.getString(10);
        this.f187676h = r102.getString(1);
        this.f187679k = r102.getDimension(2, e.a(getContext(), 15.0f));
        d(r102);
        r102.recycle();
        this.f187672d = (TextView) findViewById(R.id.input_view_hint_tv);
        EditText r103 = (EditText) findViewById(R.id.input_view_et);
        this.f187673e = r103;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        r103.setTextSize(0, this.f187679k);
        EditText r104 = this.f187673e;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L8:
        r104.addTextChangedListener(new jm3.a(this));
        EditText r105 = this.f187673e;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L11:
        r105.setOnEditorActionListener(new b(this));
        EditText r106 = this.f187673e;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L14:
        r106.setOnFocusChangeListener(new c(this));
        EditText r107 = this.f187673e;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L17:
        g(r107, getContext().getResources().getColor(R.color.ttlive_std_brand));
        String r108 = this.f187676h;
        if (r108 == null) goto L23;
        EditText r109 = this.f187673e;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L22:
        r109.setHint(r108);
    L23:
        String r110 = this.f187677i;
        if (r110 == null) goto L29;
        EditText r111 = this.f187673e;
        if (r111 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L28:
        r111.setText(r110);
    L29:
        this.f187674f = (TextView) findViewById(R.id.input_view_max_number);
        f();
        e();
    }

    public final void g(TextView r100, int r101) {
        Field r102 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L5
        r102.setAccessible(true);     // Catch: Throwable -> L5
    L6:
        if (r102 != null) goto L26;
    L12:
        Object r103 = r100;
    L13:
        if (r102 != null) goto L15;
        Class<?> r104 = TextView.class;
    L16:
        Field r105 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L10
        r105.setAccessible(true);     // Catch: Throwable -> L10
        Drawable r106 = getContext().getDrawable(r105.getInt(r100));     // Catch: Throwable -> L10
        if (r106 != null) goto L19;
        return;
    L19:
        r106.setTint(r101);     // Catch: Throwable -> L10
        if (Build.VERSION.SDK_INT < 28) goto L22;
        Field r107 = r104.getDeclaredField("mDrawableForCursor");     // Catch: Throwable -> L10
        r107.setAccessible(true);     // Catch: Throwable -> L10
        r107.set(r103, r106);     // Catch: Throwable -> L10
        return;
    L22:
        Field r108 = r104.getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L10
        r108.setAccessible(true);     // Catch: Throwable -> L10
        r108.set(r103, new Drawable[]{r106, r106});     // Catch: Throwable -> L10
        return;
    L15:
        r104 = r103.getClass();     // Catch: Throwable -> L10
        goto L16
    L26:
        r103 = r102.get(r100);     // Catch: Throwable -> L10
        if (r103 != null) goto L13;
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        r102 = null;
        goto L6
    }
}
