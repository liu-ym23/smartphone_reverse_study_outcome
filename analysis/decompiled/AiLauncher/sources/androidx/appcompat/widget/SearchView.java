package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.customview.view.AbsSavedState;
import com.autonavi.aps.amapapi.config.Const;
import i.InterfaceC4157c;
import java.util.WeakHashMap;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements InterfaceC4157c {

    /* renamed from: M, reason: collision with root package name */
    public static final e f9027M = null;

    /* renamed from: A, reason: collision with root package name */
    public boolean f9028A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f9029B;

    /* renamed from: C, reason: collision with root package name */
    public int f9030C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f9031D;

    /* renamed from: E, reason: collision with root package name */
    public CharSequence f9032E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f9033F;

    /* renamed from: G, reason: collision with root package name */
    public int f9034G;

    /* renamed from: H, reason: collision with root package name */
    public SearchableInfo f9035H;

    /* renamed from: I, reason: collision with root package name */
    public Bundle f9036I;

    /* renamed from: J, reason: collision with root package name */
    public final Runnable f9037J;

    /* renamed from: K, reason: collision with root package name */
    public Runnable f9038K;

    /* renamed from: L, reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f9039L;

    /* renamed from: a, reason: collision with root package name */
    public final SearchAutoComplete f9040a;

    /* renamed from: b, reason: collision with root package name */
    public final View f9041b;

    /* renamed from: c, reason: collision with root package name */
    public final View f9042c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f9043d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f9044e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f9045f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f9046g;

    /* renamed from: h, reason: collision with root package name */
    public f f9047h;

    /* renamed from: i, reason: collision with root package name */
    public Rect f9048i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f9049j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f9050k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f9051l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f9052m;

    /* renamed from: n, reason: collision with root package name */
    public final Drawable f9053n;

    /* renamed from: o, reason: collision with root package name */
    public final int f9054o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9055p;

    /* renamed from: q, reason: collision with root package name */
    public final Intent f9056q;

    /* renamed from: r, reason: collision with root package name */
    public final Intent f9057r;

    /* renamed from: s, reason: collision with root package name */
    public final CharSequence f9058s;

    /* renamed from: t, reason: collision with root package name */
    public View.OnFocusChangeListener f9059t;

    /* renamed from: u, reason: collision with root package name */
    public View.OnClickListener f9060u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f9061v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f9062w;

    /* renamed from: x, reason: collision with root package name */
    public F0.a f9063x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f9064y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f9065z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean isIconified;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.isIconified));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isIconified = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public static class SearchAutoComplete extends C1290c {

        /* renamed from: a, reason: collision with root package name */
        public int f9066a;

        /* renamed from: b, reason: collision with root package name */
        public SearchView f9067b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f9068c;

        /* renamed from: d, reason: collision with root package name */
        public final Runnable f9069d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.b();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i10 >= 600) {
                return 192;
            }
            if (i10 < 640 || i11 < 480) {
                return com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME;
            }
            return 192;
        }

        public void a() {
            a.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        public void b() {
            if (this.f9068c) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f9068c = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f9066a <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.C1290c, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f9068c) {
                removeCallbacks(this.f9069d);
                post(this.f9069d);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z10, int i10, Rect rect) {
            super.onFocusChanged(z10, i10, rect);
            this.f9067b.u();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f9067b.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f9067b.hasFocus() && getVisibility() == 0) {
                this.f9068c = true;
                if (SearchView.n(getContext())) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z10) {
                this.f9068c = false;
                removeCallbacks(this.f9069d);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f9068c = true;
                    return;
                }
                this.f9068c = false;
                removeCallbacks(this.f9069d);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f9067b = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f9066a = i10;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f9069d = new a();
            this.f9066a = getThreshold();
        }
    }

    public static class a {
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        public static void b(SearchAutoComplete searchAutoComplete, int i10) {
            searchAutoComplete.setInputMethodMode(i10);
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public static class e {
    }

    public static class f extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final View f9071a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f9072b;

        /* renamed from: c, reason: collision with root package name */
        public final Rect f9073c;

        /* renamed from: d, reason: collision with root package name */
        public final Rect f9074d;

        /* renamed from: e, reason: collision with root package name */
        public final int f9075e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f9076f;

        public f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f9075e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f9072b = new Rect();
            this.f9074d = new Rect();
            this.f9073c = new Rect();
            a(rect, rect2);
            this.f9071a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f9072b.set(rect);
            this.f9074d.set(rect);
            Rect rect3 = this.f9074d;
            int i10 = this.f9075e;
            rect3.inset(-i10, -i10);
            this.f9073c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z10;
            boolean z11;
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z12 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z11 = this.f9076f;
                    if (z11 && !this.f9074d.contains(x10, y10)) {
                        z12 = z11;
                        z10 = false;
                    }
                } else {
                    if (action == 3) {
                        z11 = this.f9076f;
                        this.f9076f = false;
                    }
                    z10 = true;
                    z12 = false;
                }
                z12 = z11;
                z10 = true;
            } else if (this.f9072b.contains(x10, y10)) {
                this.f9076f = true;
                z10 = true;
            } else {
                z10 = true;
                z12 = false;
            }
            if (!z12) {
                return false;
            }
            if (!z10 || this.f9073c.contains(x10, y10)) {
                Rect rect = this.f9073c;
                motionEvent.setLocation(x10 - rect.left, y10 - rect.top);
            } else {
                motionEvent.setLocation(this.f9071a.getWidth() / 2, this.f9071a.getHeight() / 2);
            }
            return this.f9071a.dispatchTouchEvent(motionEvent);
        }
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_width);
    }

    public static boolean n(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private void setQuery(CharSequence charSequence) {
        this.f9040a.setText(charSequence);
        this.f9040a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public final void A() {
        this.f9042c.setVisibility((o() && (this.f9044e.getVisibility() == 0 || this.f9046g.getVisibility() == 0)) ? 0 : 8);
    }

    public final void B(boolean z10) {
        this.f9044e.setVisibility((this.f9064y && o() && hasFocus() && (z10 || !this.f9031D)) ? 0 : 8);
    }

    public final void C(boolean z10) {
        this.f9062w = z10;
        int i10 = 8;
        int i11 = z10 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f9040a.getText());
        this.f9043d.setVisibility(i11);
        B(!zIsEmpty);
        this.f9041b.setVisibility(z10 ? 8 : 0);
        if (this.f9052m.getDrawable() != null && !this.f9061v) {
            i10 = 0;
        }
        this.f9052m.setVisibility(i10);
        x();
        D(zIsEmpty);
        A();
    }

    public final void D(boolean z10) {
        int i10 = 8;
        if (this.f9031D && !m() && z10) {
            this.f9044e.setVisibility(8);
            i10 = 0;
        }
        this.f9046g.setVisibility(i10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f9029B = true;
        super.clearFocus();
        this.f9040a.clearFocus();
        this.f9040a.setImeVisibility(false);
        this.f9029B = false;
    }

    public final Intent g(String str, Uri uri, String str2, String str3, int i10, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f9032E);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f9036I;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i10 != 0) {
            intent.putExtra("action_key", i10);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f9035H.getSearchActivity());
        return intent;
    }

    public int getImeOptions() {
        return this.f9040a.getImeOptions();
    }

    public int getInputType() {
        return this.f9040a.getInputType();
    }

    public int getMaxWidth() {
        return this.f9030C;
    }

    public CharSequence getQuery() {
        return this.f9040a.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f9065z;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f9035H;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f9058s : getContext().getText(this.f9035H.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f9055p;
    }

    public int getSuggestionRowLayout() {
        return this.f9054o;
    }

    public F0.a getSuggestionsAdapter() {
        return this.f9063x;
    }

    public final void h() {
        this.f9040a.dismissDropDown();
    }

    public void i() {
        a.a(this.f9040a);
    }

    public final void j(View view, Rect rect) {
        view.getLocationInWindow(this.f9050k);
        getLocationInWindow(this.f9051l);
        int[] iArr = this.f9050k;
        int i10 = iArr[1];
        int[] iArr2 = this.f9051l;
        int i11 = i10 - iArr2[1];
        int i12 = iArr[0] - iArr2[0];
        rect.set(i12, i11, view.getWidth() + i12, view.getHeight() + i11);
    }

    public final CharSequence k(CharSequence charSequence) {
        if (!this.f9061v || this.f9053n == null) {
            return charSequence;
        }
        int textSize = (int) (this.f9040a.getTextSize() * 1.25d);
        this.f9053n.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f9053n), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public final boolean l() {
        SearchableInfo searchableInfo = this.f9035H;
        if (searchableInfo != null && searchableInfo.getVoiceSearchEnabled()) {
            Intent intent = this.f9035H.getVoiceSearchLaunchWebSearch() ? this.f9056q : this.f9035H.getVoiceSearchLaunchRecognizer() ? this.f9057r : null;
            if (intent != null && getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        return this.f9062w;
    }

    public final boolean o() {
        return (this.f9064y || this.f9031D) && !m();
    }

    @Override // i.InterfaceC4157c
    public void onActionViewCollapsed() {
        w("", false);
        clearFocus();
        C(true);
        this.f9040a.setImeOptions(this.f9034G);
        this.f9033F = false;
    }

    @Override // i.InterfaceC4157c
    public void onActionViewExpanded() {
        if (this.f9033F) {
            return;
        }
        this.f9033F = true;
        int imeOptions = this.f9040a.getImeOptions();
        this.f9034G = imeOptions;
        this.f9040a.setImeOptions(imeOptions | Const.FLAG_MUTABLE);
        this.f9040a.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f9037J);
        post(this.f9038K);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            j(this.f9040a, this.f9048i);
            Rect rect = this.f9049j;
            Rect rect2 = this.f9048i;
            rect.set(rect2.left, 0, rect2.right, i13 - i11);
            f fVar = this.f9047h;
            if (fVar != null) {
                fVar.a(this.f9049j, this.f9048i);
                return;
            }
            f fVar2 = new f(this.f9049j, this.f9048i, this.f9040a);
            this.f9047h = fVar2;
            setTouchDelegate(fVar2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        if (m()) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            int i13 = this.f9030C;
            size = i13 > 0 ? Math.min(i13, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f9030C;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i12 = this.f9030C) > 0) {
            size = Math.min(i12, size);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        C(savedState.isIconified);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isIconified = m();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        v();
    }

    public void p(int i10, String str, String str2) {
        getContext().startActivity(g("android.intent.action.SEARCH", null, null, str2, i10, str));
    }

    public void q() {
        if (!TextUtils.isEmpty(this.f9040a.getText())) {
            this.f9040a.setText("");
            this.f9040a.requestFocus();
            this.f9040a.setImeVisibility(true);
        } else if (this.f9061v) {
            clearFocus();
            C(true);
        }
    }

    public void r(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i10, Rect rect) {
        if (this.f9029B || !isFocusable()) {
            return false;
        }
        if (m()) {
            return super.requestFocus(i10, rect);
        }
        boolean zRequestFocus = this.f9040a.requestFocus(i10, rect);
        if (zRequestFocus) {
            C(false);
        }
        return zRequestFocus;
    }

    public void s() {
        C(false);
        this.f9040a.requestFocus();
        this.f9040a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f9060u;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setAppSearchData(Bundle bundle) {
        this.f9036I = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            q();
        } else {
            s();
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.f9061v == z10) {
            return;
        }
        this.f9061v = z10;
        C(z10);
        y();
    }

    public void setImeOptions(int i10) {
        this.f9040a.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.f9040a.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.f9030C = i10;
        requestLayout();
    }

    public void setOnCloseListener(b bVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f9059t = onFocusChangeListener;
    }

    public void setOnQueryTextListener(c cVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f9060u = onClickListener;
    }

    public void setOnSuggestionListener(d dVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f9065z = charSequence;
        y();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        this.f9028A = z10;
        F0.a aVar = this.f9063x;
        if (aVar instanceof N) {
            ((N) aVar).v(z10 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f9035H = searchableInfo;
        if (searchableInfo != null) {
            z();
            y();
        }
        boolean zL = l();
        this.f9031D = zL;
        if (zL) {
            this.f9040a.setPrivateImeOptions("nm");
        }
        C(m());
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.f9064y = z10;
        C(m());
    }

    public void setSuggestionsAdapter(F0.a aVar) {
        this.f9063x = aVar;
        this.f9040a.setAdapter(aVar);
    }

    public void t() {
        Editable text = this.f9040a.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f9035H != null) {
            p(0, null, text.toString());
        }
        this.f9040a.setImeVisibility(false);
        h();
    }

    public void u() {
        C(m());
        v();
        if (this.f9040a.hasFocus()) {
            i();
        }
    }

    public final void v() {
        post(this.f9037J);
    }

    public void w(CharSequence charSequence, boolean z10) {
        this.f9040a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f9040a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f9032E = charSequence;
        }
        if (!z10 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        t();
    }

    public final void x() {
        boolean zIsEmpty = TextUtils.isEmpty(this.f9040a.getText());
        this.f9045f.setVisibility(!zIsEmpty || (this.f9061v && !this.f9033F) ? 0 : 8);
        Drawable drawable = this.f9045f.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void y() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f9040a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(k(queryHint));
    }

    public final void z() {
        this.f9040a.setThreshold(this.f9035H.getSuggestThreshold());
        this.f9040a.setImeOptions(this.f9035H.getImeOptions());
        int inputType = this.f9035H.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f9035H.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f9040a.setInputType(inputType);
        F0.a aVar = this.f9063x;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.f9035H.getSuggestAuthority() != null) {
            N n10 = new N(getContext(), this, this.f9035H, this.f9039L);
            this.f9063x = n10;
            this.f9040a.setAdapter(n10);
            ((N) this.f9063x).v(this.f9028A ? 2 : 1);
        }
    }
}
