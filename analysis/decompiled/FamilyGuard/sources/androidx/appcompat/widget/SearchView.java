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
import g.C0728a;
import java.util.WeakHashMap;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements androidx.appcompat.view.c {

    /* renamed from: h0, reason: collision with root package name */
    static final e f8252h0 = null;

    /* renamed from: A, reason: collision with root package name */
    private int[] f8253A;

    /* renamed from: B, reason: collision with root package name */
    private final ImageView f8254B;

    /* renamed from: C, reason: collision with root package name */
    private final Drawable f8255C;

    /* renamed from: D, reason: collision with root package name */
    private final int f8256D;

    /* renamed from: E, reason: collision with root package name */
    private final int f8257E;

    /* renamed from: F, reason: collision with root package name */
    private final Intent f8258F;

    /* renamed from: G, reason: collision with root package name */
    private final Intent f8259G;

    /* renamed from: H, reason: collision with root package name */
    private final CharSequence f8260H;

    /* renamed from: I, reason: collision with root package name */
    View.OnFocusChangeListener f8261I;

    /* renamed from: J, reason: collision with root package name */
    private View.OnClickListener f8262J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f8263K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f8264L;

    /* renamed from: M, reason: collision with root package name */
    H.a f8265M;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f8266Q;

    /* renamed from: R, reason: collision with root package name */
    private CharSequence f8267R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f8268S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f8269T;

    /* renamed from: U, reason: collision with root package name */
    private int f8270U;

    /* renamed from: V, reason: collision with root package name */
    private boolean f8271V;

    /* renamed from: W, reason: collision with root package name */
    private CharSequence f8272W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f8273a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f8274b0;

    /* renamed from: c0, reason: collision with root package name */
    SearchableInfo f8275c0;

    /* renamed from: d0, reason: collision with root package name */
    private Bundle f8276d0;

    /* renamed from: e0, reason: collision with root package name */
    private final Runnable f8277e0;

    /* renamed from: f0, reason: collision with root package name */
    private Runnable f8278f0;

    /* renamed from: g0, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f8279g0;

    /* renamed from: p, reason: collision with root package name */
    final SearchAutoComplete f8280p;

    /* renamed from: q, reason: collision with root package name */
    private final View f8281q;

    /* renamed from: r, reason: collision with root package name */
    private final View f8282r;

    /* renamed from: s, reason: collision with root package name */
    final ImageView f8283s;

    /* renamed from: t, reason: collision with root package name */
    final ImageView f8284t;

    /* renamed from: u, reason: collision with root package name */
    final ImageView f8285u;

    /* renamed from: v, reason: collision with root package name */
    final ImageView f8286v;

    /* renamed from: w, reason: collision with root package name */
    private g f8287w;

    /* renamed from: x, reason: collision with root package name */
    private Rect f8288x;

    /* renamed from: y, reason: collision with root package name */
    private Rect f8289y;

    /* renamed from: z, reason: collision with root package name */
    private int[] f8290z;

    public static class SearchAutoComplete extends C0434d {

        /* renamed from: e, reason: collision with root package name */
        private int f8291e;

        /* renamed from: f, reason: collision with root package name */
        private SearchView f8292f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f8293g;

        /* renamed from: h, reason: collision with root package name */
        final Runnable f8294h;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.c();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0728a.f16841r);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i5 = configuration.screenWidthDp;
            int i6 = configuration.screenHeightDp;
            if (i5 >= 960 && i6 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i5 < 600) {
                return (i5 < 640 || i6 < 480) ? 160 : 192;
            }
            return 192;
        }

        void b() {
            a.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        void c() {
            if (this.f8293g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f8293g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f8291e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.C0434d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f8293g) {
                removeCallbacks(this.f8294h);
                post(this.f8294h);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z5, int i5, Rect rect) {
            super.onFocusChanged(z5, i5, rect);
            this.f8292f.P();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i5, KeyEvent keyEvent) {
            if (i5 == 4) {
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
                        this.f8292f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i5, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z5) {
            super.onWindowFocusChanged(z5);
            if (z5 && this.f8292f.hasFocus() && getVisibility() == 0) {
                this.f8293g = true;
                if (SearchView.I(getContext())) {
                    b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z5) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z5) {
                this.f8293g = false;
                removeCallbacks(this.f8294h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f8293g = true;
                    return;
                }
                this.f8293g = false;
                removeCallbacks(this.f8294h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f8292f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i5) {
            super.setThreshold(i5);
            this.f8291e = i5;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i5) {
            super(context, attributeSet, i5);
            this.f8294h = new a();
            this.f8291e = getThreshold();
        }
    }

    static class a {
        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        static void b(SearchAutoComplete searchAutoComplete, int i5) {
            searchAutoComplete.setInputMethodMode(i5);
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    private static class e {
    }

    static class f extends androidx.customview.view.a {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        boolean f8296a;

        class a implements Parcelable.ClassLoaderCreator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i5) {
                return new f[i5];
            }
        }

        f(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f8296a + "}";
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeValue(Boolean.valueOf(this.f8296a));
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8296a = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    private static class g extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        private final View f8297a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f8298b;

        /* renamed from: c, reason: collision with root package name */
        private final Rect f8299c;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f8300d;

        /* renamed from: e, reason: collision with root package name */
        private final int f8301e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f8302f;

        public g(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f8301e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f8298b = new Rect();
            this.f8300d = new Rect();
            this.f8299c = new Rect();
            a(rect, rect2);
            this.f8297a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f8298b.set(rect);
            this.f8300d.set(rect);
            Rect rect3 = this.f8300d;
            int i5 = this.f8301e;
            rect3.inset(-i5, -i5);
            this.f8299c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z5;
            boolean z6;
            int x5 = (int) motionEvent.getX();
            int y5 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z7 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z6 = this.f8302f;
                    if (z6 && !this.f8300d.contains(x5, y5)) {
                        z7 = z6;
                        z5 = false;
                    }
                } else {
                    if (action == 3) {
                        z6 = this.f8302f;
                        this.f8302f = false;
                    }
                    z5 = true;
                    z7 = false;
                }
                z7 = z6;
                z5 = true;
            } else if (this.f8298b.contains(x5, y5)) {
                this.f8302f = true;
                z5 = true;
            } else {
                z5 = true;
                z7 = false;
            }
            if (!z7) {
                return false;
            }
            if (!z5 || this.f8299c.contains(x5, y5)) {
                Rect rect = this.f8299c;
                motionEvent.setLocation(x5 - rect.left, y5 - rect.top);
            } else {
                motionEvent.setLocation(this.f8297a.getWidth() / 2, this.f8297a.getHeight() / 2);
            }
            return this.f8297a.dispatchTouchEvent(motionEvent);
        }
    }

    private Intent B(String str, Uri uri, String str2, String str3, int i5, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f8272W);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f8276d0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i5 != 0) {
            intent.putExtra("action_key", i5);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f8275c0.getSearchActivity());
        return intent;
    }

    private void C() {
        this.f8280p.dismissDropDown();
    }

    private void E(View view, Rect rect) {
        view.getLocationInWindow(this.f8290z);
        getLocationInWindow(this.f8253A);
        int[] iArr = this.f8290z;
        int i5 = iArr[1];
        int[] iArr2 = this.f8253A;
        int i6 = i5 - iArr2[1];
        int i7 = iArr[0] - iArr2[0];
        rect.set(i7, i6, view.getWidth() + i7, view.getHeight() + i6);
    }

    private CharSequence F(CharSequence charSequence) {
        if (!this.f8263K || this.f8255C == null) {
            return charSequence;
        }
        int textSize = (int) (this.f8280p.getTextSize() * 1.25d);
        this.f8255C.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f8255C), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean G() {
        SearchableInfo searchableInfo = this.f8275c0;
        if (searchableInfo != null && searchableInfo.getVoiceSearchEnabled()) {
            Intent intent = this.f8275c0.getVoiceSearchLaunchWebSearch() ? this.f8258F : this.f8275c0.getVoiceSearchLaunchRecognizer() ? this.f8259G : null;
            if (intent != null && getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                return true;
            }
        }
        return false;
    }

    static boolean I(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean J() {
        return (this.f8266Q || this.f8271V) && !H();
    }

    private void Q() {
        post(this.f8277e0);
    }

    private void S() {
        boolean zIsEmpty = TextUtils.isEmpty(this.f8280p.getText());
        this.f8285u.setVisibility(!zIsEmpty || (this.f8263K && !this.f8273a0) ? 0 : 8);
        Drawable drawable = this.f8285u.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void T() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f8280p;
        if (queryHint == null) {
            queryHint = BuildConfig.FLAVOR;
        }
        searchAutoComplete.setHint(F(queryHint));
    }

    private void U() {
        this.f8280p.setThreshold(this.f8275c0.getSuggestThreshold());
        this.f8280p.setImeOptions(this.f8275c0.getImeOptions());
        int inputType = this.f8275c0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f8275c0.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f8280p.setInputType(inputType);
        H.a aVar = this.f8265M;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.f8275c0.getSuggestAuthority() != null) {
            U u5 = new U(getContext(), this, this.f8275c0, this.f8279g0);
            this.f8265M = u5;
            this.f8280p.setAdapter(u5);
            ((U) this.f8265M).w(this.f8268S ? 2 : 1);
        }
    }

    private void V() {
        this.f8282r.setVisibility((J() && (this.f8284t.getVisibility() == 0 || this.f8286v.getVisibility() == 0)) ? 0 : 8);
    }

    private void W(boolean z5) {
        this.f8284t.setVisibility((this.f8266Q && J() && hasFocus() && (z5 || !this.f8271V)) ? 0 : 8);
    }

    private void X(boolean z5) {
        this.f8264L = z5;
        int i5 = 8;
        int i6 = z5 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f8280p.getText());
        this.f8283s.setVisibility(i6);
        W(!zIsEmpty);
        this.f8281q.setVisibility(z5 ? 8 : 0);
        if (this.f8254B.getDrawable() != null && !this.f8263K) {
            i5 = 0;
        }
        this.f8254B.setVisibility(i5);
        S();
        Y(zIsEmpty);
        V();
    }

    private void Y(boolean z5) {
        int i5 = 8;
        if (this.f8271V && !H() && z5) {
            this.f8284t.setVisibility(8);
            i5 = 0;
        }
        this.f8286v.setVisibility(i5);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(g.d.f16863e);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(g.d.f16864f);
    }

    private void setQuery(CharSequence charSequence) {
        this.f8280p.setText(charSequence);
        this.f8280p.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void D() {
        a.a(this.f8280p);
    }

    public boolean H() {
        return this.f8264L;
    }

    void K(int i5, String str, String str2) {
        getContext().startActivity(B("android.intent.action.SEARCH", null, null, str2, i5, str));
    }

    void L() {
        if (!TextUtils.isEmpty(this.f8280p.getText())) {
            this.f8280p.setText(BuildConfig.FLAVOR);
            this.f8280p.requestFocus();
            this.f8280p.setImeVisibility(true);
        } else if (this.f8263K) {
            clearFocus();
            X(true);
        }
    }

    protected void M(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void N() {
        X(false);
        this.f8280p.requestFocus();
        this.f8280p.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f8262J;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void O() {
        Editable text = this.f8280p.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f8275c0 != null) {
            K(0, null, text.toString());
        }
        this.f8280p.setImeVisibility(false);
        C();
    }

    void P() {
        X(H());
        Q();
        if (this.f8280p.hasFocus()) {
            D();
        }
    }

    public void R(CharSequence charSequence, boolean z5) {
        this.f8280p.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f8280p;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f8272W = charSequence;
        }
        if (!z5 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        O();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f8269T = true;
        super.clearFocus();
        this.f8280p.clearFocus();
        this.f8280p.setImeVisibility(false);
        this.f8269T = false;
    }

    public int getImeOptions() {
        return this.f8280p.getImeOptions();
    }

    public int getInputType() {
        return this.f8280p.getInputType();
    }

    public int getMaxWidth() {
        return this.f8270U;
    }

    public CharSequence getQuery() {
        return this.f8280p.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f8267R;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f8275c0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f8260H : getContext().getText(this.f8275c0.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.f8257E;
    }

    int getSuggestionRowLayout() {
        return this.f8256D;
    }

    public H.a getSuggestionsAdapter() {
        return this.f8265M;
    }

    @Override // androidx.appcompat.view.c
    public void onActionViewCollapsed() {
        R(BuildConfig.FLAVOR, false);
        clearFocus();
        X(true);
        this.f8280p.setImeOptions(this.f8274b0);
        this.f8273a0 = false;
    }

    @Override // androidx.appcompat.view.c
    public void onActionViewExpanded() {
        if (this.f8273a0) {
            return;
        }
        this.f8273a0 = true;
        int imeOptions = this.f8280p.getImeOptions();
        this.f8274b0 = imeOptions;
        this.f8280p.setImeOptions(imeOptions | 33554432);
        this.f8280p.setText(BuildConfig.FLAVOR);
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f8277e0);
        post(this.f8278f0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        if (z5) {
            E(this.f8280p, this.f8288x);
            Rect rect = this.f8289y;
            Rect rect2 = this.f8288x;
            rect.set(rect2.left, 0, rect2.right, i8 - i6);
            g gVar = this.f8287w;
            if (gVar != null) {
                gVar.a(this.f8289y, this.f8288x);
                return;
            }
            g gVar2 = new g(this.f8289y, this.f8288x, this.f8280p);
            this.f8287w = gVar2;
            setTouchDelegate(gVar2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7;
        if (H()) {
            super.onMeasure(i5, i6);
            return;
        }
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        if (mode == Integer.MIN_VALUE) {
            int i8 = this.f8270U;
            size = i8 > 0 ? Math.min(i8, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f8270U;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i7 = this.f8270U) > 0) {
            size = Math.min(i7, size);
        }
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        X(fVar.f8296a);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        fVar.f8296a = H();
        return fVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        Q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i5, Rect rect) {
        if (this.f8269T || !isFocusable()) {
            return false;
        }
        if (H()) {
            return super.requestFocus(i5, rect);
        }
        boolean zRequestFocus = this.f8280p.requestFocus(i5, rect);
        if (zRequestFocus) {
            X(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f8276d0 = bundle;
    }

    public void setIconified(boolean z5) {
        if (z5) {
            L();
        } else {
            N();
        }
    }

    public void setIconifiedByDefault(boolean z5) {
        if (this.f8263K == z5) {
            return;
        }
        this.f8263K = z5;
        X(z5);
        T();
    }

    public void setImeOptions(int i5) {
        this.f8280p.setImeOptions(i5);
    }

    public void setInputType(int i5) {
        this.f8280p.setInputType(i5);
    }

    public void setMaxWidth(int i5) {
        this.f8270U = i5;
        requestLayout();
    }

    public void setOnCloseListener(b bVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f8261I = onFocusChangeListener;
    }

    public void setOnQueryTextListener(c cVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f8262J = onClickListener;
    }

    public void setOnSuggestionListener(d dVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f8267R = charSequence;
        T();
    }

    public void setQueryRefinementEnabled(boolean z5) {
        this.f8268S = z5;
        H.a aVar = this.f8265M;
        if (aVar instanceof U) {
            ((U) aVar).w(z5 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f8275c0 = searchableInfo;
        if (searchableInfo != null) {
            U();
            T();
        }
        boolean zG = G();
        this.f8271V = zG;
        if (zG) {
            this.f8280p.setPrivateImeOptions("nm");
        }
        X(H());
    }

    public void setSubmitButtonEnabled(boolean z5) {
        this.f8266Q = z5;
        X(H());
    }

    public void setSuggestionsAdapter(H.a aVar) {
        this.f8265M = aVar;
        this.f8280p.setAdapter(aVar);
    }
}
