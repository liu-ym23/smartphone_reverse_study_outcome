package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.ui.widget.FlowLayout;
import com.google.common.primitives.Ints;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final l f894b0 = null;
    public boolean A;
    public boolean B;
    public androidx.cursoradapter.widget.a C;
    public boolean D;
    public CharSequence E;
    public boolean F;
    public boolean G;
    public int H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public CharSequence f895J;
    public CharSequence K;
    public boolean L;
    public int M;
    public SearchableInfo N;
    public Bundle O;
    public final Runnable P;
    public Runnable Q;
    public final WeakHashMap R;
    public final View.OnClickListener S;
    public View.OnKeyListener T;
    public final TextView.OnEditorActionListener U;
    public final AdapterView.OnItemClickListener V;
    public final AdapterView.OnItemSelectedListener W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchAutoComplete f896a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public TextWatcher f897a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m f906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Rect f907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Rect f908l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f909m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f910n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ImageView f911o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Drawable f912p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f913q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f914r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Intent f915s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Intent f916t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CharSequence f917u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public OnQueryTextListener f918v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OnCloseListener f919w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View.OnFocusChangeListener f920x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OnSuggestionListener f921y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View.OnClickListener f922z;

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String r10);

        boolean onQueryTextSubmit(String r10);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int r10);

        boolean onSuggestionSelect(int r10);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isIconified;

        public class a implements Parcelable.ClassLoaderCreator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState b(Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeValue(Boolean.valueOf(this.isIconified));
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            this.isIconified = ((Boolean) r10.readValue(null)).booleanValue();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SearchView f924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Runnable f926d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SearchAutoComplete f927a;

            public a(SearchAutoComplete r10) {
                this.f927a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f927a.c();
            }
        }

        public SearchAutoComplete(Context r10) {
            this(r10, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration r10 = getResources().getConfiguration();
            int r11 = r10.screenWidthDp;
            int r12 = r10.screenHeightDp;
            if (r11 < 960) goto L11;
            if (r12 < 720) goto L11;
            if (r10.orientation != 2) goto L11;
            return 256;
        L11:
            if (r11 < 600) goto L13;
            return 192;
        L13:
            if (r11 >= 640) goto L15;
            return 160;
        L15:
            if (r12 >= 480) goto L22;
            return 160;
        L22:
            return 192;
        }

        public void a() {
            k.b(this, 1);
            if (enoughToFilter() == false) goto L6;
            showDropDown();
            return;
        }

        public boolean b() {
            if (TextUtils.getTrimmedLength(getText()) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void c() {
            if (this.f925c == false) goto L6;
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
            this.f925c = false;
            return;
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            if (this.f923a > 0) goto L5;
        L8:
            return true;
        L5:
            if (super.enoughToFilter() == true) goto L8;
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo r10) {
            InputConnection r11 = super.onCreateInputConnection(r10);
            if (this.f925c == false) goto L5;
            removeCallbacks(this.f926d);
            post(this.f926d);
        L5:
            return r11;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean r10, int r11, Rect r12) {
            super.onFocusChanged(r10, r11, r12);
            this.f924b.B();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int r10, KeyEvent r11) {
            if (r10 != 4) goto L24;
            if (r11.getAction() != 0) goto L13;
            if (r11.getRepeatCount() != 0) goto L13;
            KeyEvent.DispatcherState r12 = getKeyDispatcherState();
            if (r12 == null) goto L11;
            r12.startTracking(r11, this);
        L11:
            return true;
        L13:
            if (r11.getAction() != 1) goto L24;
            KeyEvent.DispatcherState r13 = getKeyDispatcherState();
            if (r13 == null) goto L18;
            r13.handleUpEvent(r11);
        L18:
            if (r11.isTracking() == false) goto L24;
            if (r11.isCanceled() == true) goto L24;
            this.f924b.clearFocus();
            setImeVisibility(false);
            return true;
        L24:
            return super.onKeyPreIme(r10, r11);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean r10) {
            super.onWindowFocusChanged(r10);
            if (r10 == true) goto L5;
            return;
        L5:
            if (this.f924b.hasFocus() == true) goto L7;
            return;
        L7:
            if (getVisibility() != 0) goto L14;
            this.f925c = true;
            if (SearchView.o(getContext()) == false) goto L15;
            a();
            return;
        L15:
            return;
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence r10) {
        }

        public void setImeVisibility(boolean r10) {
            InputMethodManager r11 = (InputMethodManager) getContext().getSystemService("input_method");
            if (r10 == true) goto L7;
            this.f925c = false;
            removeCallbacks(this.f926d);
            r11.hideSoftInputFromWindow(getWindowToken(), 0);
            return;
        L7:
            if (r11.isActive(this) == false) goto L10;
            this.f925c = false;
            removeCallbacks(this.f926d);
            r11.showSoftInput(this, 0);
            return;
        L10:
            this.f925c = true;
        }

        public void setSearchView(SearchView r10) {
            this.f924b = r10;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int r10) {
            super.setThreshold(r10);
            this.f923a = r10;
        }

        public SearchAutoComplete(Context r10, AttributeSet r11) {
            this(r10, r11, R$attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context r10, AttributeSet r11, int r12) {
            super(r10, r11, r12);
            this.f926d = new a(this);
            this.f923a = getThreshold();
        }
    }

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f928a;

        public a(SearchView r10) {
            this.f928a = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            this.f928a.A(r10);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f929a;

        public b(SearchView r10) {
            this.f929a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f929a.H();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f930a;

        public c(SearchView r10) {
            this.f930a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.cursoradapter.widget.a r10 = this.f930a.C;
            if ((r10 instanceof w) == false) goto L6;
            r10.changeCursor(null);
            return;
        }
    }

    public class d implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f931a;

        public d(SearchView r10) {
            this.f931a = r10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View r10, boolean r11) {
            SearchView r12 = this.f931a;
            View.OnFocusChangeListener r13 = r12.f920x;
            if (r13 == null) goto L6;
            r13.onFocusChange(r12, r11);
            return;
        }
    }

    public class e implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f932a;

        public e(SearchView r10) {
            this.f932a = r10;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
            this.f932a.d();
        }
    }

    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f933a;

        public f(SearchView r10) {
            this.f933a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            SearchView r11 = this.f933a;
            if (r10 != r11.f901e) goto L6;
            r11.x();
            return;
        L6:
            if (r10 != r11.f903g) goto L9;
            r11.t();
            return;
        L9:
            if (r10 != r11.f902f) goto L12;
            r11.y();
            return;
        L12:
            if (r10 != r11.f904h) goto L15;
            r11.C();
            return;
        L15:
            if (r10 != r11.f896a) goto L22;
            r11.j();
            return;
        }
    }

    public class g implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f934a;

        public g(SearchView r10) {
            this.f934a = r10;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View r10, int r11, KeyEvent r12) {
            SearchView r13 = this.f934a;
            if (r13.N != null) goto L6;
            return false;
        L6:
            if (r13.f896a.isPopupShowing() == false) goto L12;
            if (this.f934a.f896a.getListSelection() == (-1)) goto L12;
            return this.f934a.z(r10, r11, r12);
        L12:
            if (this.f934a.f896a.b() == false) goto L14;
        L21:
            return false;
        L14:
            if (r12.hasNoModifiers() == false) goto L21;
            if (r12.getAction() != 1) goto L21;
            if (r11 != 66) goto L21;
            r10.cancelLongPress();
            SearchView r14 = this.f934a;
            r14.r(0, null, r14.f896a.getText().toString());
            return true;
        }
    }

    public class h implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f935a;

        public h(SearchView r10) {
            this.f935a = r10;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView r10, int r11, KeyEvent r12) {
            this.f935a.y();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f936a;

        public i(SearchView r10) {
            this.f936a = r10;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView r10, View r11, int r12, long r13) {
            this.f936a.u(r12, 0, null);
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f937a;

        public j(SearchView r10) {
            this.f937a = r10;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView r10, View r11, int r12, long r13) {
            this.f937a.v(r12);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView r10) {
        }
    }

    public static class k {
        @DoNotInline
        public static void a(AutoCompleteTextView r10) {
            r10.refreshAutoCompleteResults();
        }

        @DoNotInline
        public static void b(SearchAutoComplete r10, int r11) {
            r10.setInputMethodMode(r11);
        }
    }

    public static class l {
    }

    public static class m extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect f940c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f942e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f943f;

        public m(Rect r10, Rect r11, View r12) {
            super(r10, r12);
            this.f942e = ViewConfiguration.get(r12.getContext()).getScaledTouchSlop();
            this.f939b = new Rect();
            this.f941d = new Rect();
            this.f940c = new Rect();
            a(r10, r11);
            this.f938a = r12;
        }

        public void a(Rect r10, Rect r11) {
            this.f939b.set(r10);
            this.f941d.set(r10);
            Rect r12 = this.f941d;
            int r13 = this.f942e;
            r12.inset(-r13, -r13);
            this.f940c.set(r11);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent r10) {
            int r11 = (int) r10.getX();
            int r12 = (int) r10.getY();
            int r13 = r10.getAction();
            boolean r14 = true;
            if (r13 == 0) goto L17;
            if (r13 == 1) goto L11;
            if (r13 == 2) goto L11;
            if (r13 != 3) goto L19;
            boolean r15 = this.f943f;
            this.f943f = false;
        L10:
            r14 = r15;
            boolean r16 = true;
        L20:
            if (r14 == false) goto L28;
            if (r16 == true) goto L23;
        L25:
            Rect r17 = this.f940c;
            r10.setLocation(r11 - r17.left, r12 - r17.top);
        L27:
            return this.f938a.dispatchTouchEvent(r10);
        L23:
            if (this.f940c.contains(r11, r12) == true) goto L25;
            r10.setLocation(this.f938a.getWidth() / 2, this.f938a.getHeight() / 2);
            goto L27
        L28:
            return false;
        L19:
            r16 = true;
            r14 = false;
        L11:
            r15 = this.f943f;
            if (r15 == false) goto L10;
            if (this.f941d.contains(r11, r12) == true) goto L10;
            r14 = r15;
            r16 = false;
            goto L20
        L17:
            if (this.f939b.contains(r11, r12) == false) goto L19;
            this.f943f = true;
            r16 = true;
            goto L20
        }
    }

    static {
    }

    public SearchView(@NonNull Context r10) {
        this(r10, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_width);
    }

    public static boolean o(Context r10) {
        if (r10.getResources().getConfiguration().orientation != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private void setQuery(CharSequence r10) {
        this.f896a.setText(r10);
        SearchAutoComplete r11 = this.f896a;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        int r12 = 0;
    L6:
        r11.setSelection(r12);
        return;
    L5:
        r12 = r10.length();
        goto L6
    }

    public void A(CharSequence r10) {
        Editable r11 = this.f896a.getText();
        this.K = r11;
        boolean r12 = TextUtils.isEmpty(r11);
        L(!r12);
        N(r12);
        G();
        K();
        if (this.f918v != null) goto L5;
    L7:
        this.f895J = r10.toString();
        return;
    L5:
        if (TextUtils.equals(r10, this.f895J) == true) goto L7;
        this.f918v.onQueryTextChange(r10.toString());
        goto L7
    }

    public void B() {
        M(n());
        D();
        if (this.f896a.hasFocus() == false) goto L6;
        j();
        return;
    }

    public void C() {
        SearchableInfo r10 = this.N;
        if (r10 != null) goto L15;
        return;
    L15:
    L12:
        Log.w("SearchView", "Could not find voice search activity");
        return;
    L6:
        if (r10.getVoiceSearchLaunchWebSearch() == false) goto L9;
        Intent r11 = h(this.f915s, r10);     // Catch: ActivityNotFoundException -> L12
        getContext().startActivity(r11);     // Catch: ActivityNotFoundException -> L12
    L14:
        return;
    L9:
        if (r10.getVoiceSearchLaunchRecognizer() == false) goto L14;
        Intent r12 = g(this.f916t, r10);     // Catch: ActivityNotFoundException -> L12
        getContext().startActivity(r12);     // Catch: ActivityNotFoundException -> L12
        goto L14
    }

    public final void D() {
        post(this.P);
    }

    public final void E(int r10) {
        Editable r11 = this.f896a.getText();
        Cursor r12 = this.C.getCursor();
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.moveToPosition(r10) == false) goto L11;
        CharSequence r13 = this.C.convertToString(r12);
        if (r13 == null) goto L10;
        setQuery(r13);
        return;
    L10:
        setQuery(r11);
        return;
    L11:
        setQuery(r11);
    }

    public void F(CharSequence r10, boolean r11) {
        this.f896a.setText(r10);
        if (r10 == null) goto L5;
        SearchAutoComplete r12 = this.f896a;
        r12.setSelection(r12.length());
        this.K = r10;
    L5:
        if (r11 == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L11;
        y();
        return;
    }

    public final void G() {
        boolean r10 = TextUtils.isEmpty(this.f896a.getText());
        int r11 = 0;
        if (r10 == true) goto L5;
    L10:
        boolean r12 = true;
    L11:
        ImageView r13 = this.f903g;
        if (r12 == true) goto L15;
        r11 = 8;
    L15:
        r13.setVisibility(r11);
        Drawable r14 = this.f903g.getDrawable();
        if (r14 == null) goto L22;
        if (r10 == true) goto L19;
        int[] r15 = ViewGroup.ENABLED_STATE_SET;
    L20:
        r14.setState(r15);
        return;
    L19:
        r15 = ViewGroup.EMPTY_STATE_SET;
        goto L20
    L22:
        return;
    L5:
        if (this.A == true) goto L7;
    L9:
        r12 = false;
        goto L11
    L7:
        if (this.L == true) goto L9;
        goto L9
    }

    public void H() {
        if (this.f896a.hasFocus() == false) goto L5;
        int[] r10 = ViewGroup.FOCUSED_STATE_SET;
    L6:
        Drawable r11 = this.f899c.getBackground();
        if (r11 == null) goto L9;
        r11.setState(r10);
    L9:
        Drawable r12 = this.f900d.getBackground();
        if (r12 == null) goto L12;
        r12.setState(r10);
    L12:
        invalidate();
        return;
    L5:
        r10 = ViewGroup.EMPTY_STATE_SET;
        goto L6
    }

    public final void I() {
        CharSequence r10 = getQueryHint();
        SearchAutoComplete r11 = this.f896a;
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r11.setHint(l(r10));
    }

    public final void J() {
        this.f896a.setThreshold(this.N.getSuggestThreshold());
        this.f896a.setImeOptions(this.N.getImeOptions());
        int r10 = this.N.getInputType();
        int r11 = 1;
        if ((r10 & 15) != 1) goto L7;
        r10 = r10 & FlowLayout.SPACING_ALIGN;
        if (this.N.getSuggestAuthority() == null) goto L7;
        r10 = r10 | 589824;
    L7:
        this.f896a.setInputType(r10);
        androidx.cursoradapter.widget.a r12 = this.C;
        if (r12 == null) goto L11;
        r12.changeCursor(null);
    L11:
        if (this.N.getSuggestAuthority() == null) goto L17;
        w r13 = new w(getContext(), this, this.N, this.R);
        this.C = r13;
        this.f896a.setAdapter(r13);
        w r14 = (w) this.C;
        if (this.F == false) goto L15;
        r11 = 2;
    L15:
        r14.t(r11);
        return;
    }

    public final void K() {
        if (p() == true) goto L5;
    L9:
        int r10 = 8;
    L10:
        this.f900d.setVisibility(r10);
        return;
    L5:
        if (this.f902f.getVisibility() != 0) goto L7;
    L8:
        r10 = 0;
        goto L10
    L7:
        if (this.f904h.getVisibility() != 0) goto L9;
        goto L8
    }

    public final void L(boolean r10) {
        if (this.D == true) goto L5;
    L12:
        int r11 = 8;
    L13:
        this.f902f.setVisibility(r11);
        return;
    L5:
        if (p() == false) goto L12;
        if (hasFocus() == false) goto L12;
        if (r10 == false) goto L10;
    L11:
        r11 = 0;
        goto L13
    L10:
        if (this.I == true) goto L12;
        goto L11
    }

    public final void M(boolean r10) {
        this.B = r10;
        int r11 = 8;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        boolean r13 = TextUtils.isEmpty(this.f896a.getText());
        this.f901e.setVisibility(r12);
        L(!r13);
        View r14 = this.f898b;
        if (r10 == false) goto L9;
        int r15 = 8;
    L10:
        r14.setVisibility(r15);
        if (this.f911o.getDrawable() != null) goto L13;
    L16:
        this.f911o.setVisibility(r11);
        G();
        N(r13);
        K();
        return;
    L13:
        if (this.A == true) goto L16;
        r11 = 0;
        goto L16
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 8;
        goto L6
    }

    public final void N(boolean r10) {
        int r11 = 8;
        if (this.I == true) goto L5;
    L8:
        this.f904h.setVisibility(r11);
        return;
    L5:
        if (n() == true) goto L8;
        if (r10 == false) goto L8;
        this.f902f.setVisibility(8);
        r11 = 0;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.G = true;
        super.clearFocus();
        this.f896a.clearFocus();
        this.f896a.setImeVisibility(false);
        this.G = false;
    }

    public void d() {
        if (this.f905i.getWidth() <= 1) goto L14;
        Resources r10 = getContext().getResources();
        int r11 = this.f899c.getPaddingLeft();
        Rect r12 = new Rect();
        boolean r13 = i0.b(this);
        if (this.A == false) goto L7;
        int r14 = r10.getDimensionPixelSize(R$dimen.abc_dropdownitem_icon_width) + r10.getDimensionPixelSize(R$dimen.abc_dropdownitem_text_padding_left);
    L8:
        this.f896a.getDropDownBackground().getPadding(r12);
        if (r13 == false) goto L11;
        int r15 = -r12.left;
    L12:
        this.f896a.setDropDownHorizontalOffset(r15);
        int r16 = (((this.f905i.getWidth() + r12.left) + r12.right) + r14) - r11;
        this.f896a.setDropDownWidth(r16);
        return;
    L11:
        r15 = r11 - (r12.left + r14);
        goto L12
    L7:
        r14 = 0;
        goto L8
    }

    public final Intent e(String r10, Uri r11, String r12, String r13, int r14, String r15) {
        Intent r16 = new Intent(r10);
        r16.addFlags(268435456);
        if (r11 == null) goto L5;
        r16.setData(r11);
    L5:
        r16.putExtra("user_query", this.K);
        if (r13 == null) goto L8;
        r16.putExtra("query", r13);
    L8:
        if (r12 == null) goto L10;
        r16.putExtra("intent_extra_data_key", r12);
    L10:
        Bundle r17 = this.O;
        if (r17 == null) goto L13;
        r16.putExtra("app_data", r17);
    L13:
        if (r14 == 0) goto L15;
        r16.putExtra("action_key", r14);
        r16.putExtra("action_msg", r15);
    L15:
        r16.setComponent(this.N.getSearchActivity());
        return r16;
    }

    public final Intent f(Cursor r10, int r11, String r12) {
        String r13 = w.k(r10, "suggest_intent_action");     // Catch: RuntimeException -> L6
        if (r13 != null) goto L8;
        r13 = this.N.getSuggestIntentAction();     // Catch: RuntimeException -> L6
    L8:
        if (r13 != null) goto L10;
        r13 = "android.intent.action.SEARCH";
    L10:
        String r14 = r13;
        String r15 = w.k(r10, "suggest_intent_data");     // Catch: RuntimeException -> L6
        if (r15 != null) goto L13;
        r15 = this.N.getSuggestIntentData();     // Catch: RuntimeException -> L6
    L13:
        if (r15 == null) goto L17;
        String r16 = w.k(r10, "suggest_intent_data_id");     // Catch: RuntimeException -> L6
        if (r16 == null) goto L17;
        r15 = r15 + LibrarianImpl.Constants.SEPARATOR + Uri.encode(r16);     // Catch: RuntimeException -> L6
    L17:
        if (r15 != null) goto L19;
        Uri r17 = null;
    L20:
        return e(r14, r17, w.k(r10, "suggest_intent_extra_data"), w.k(r10, "suggest_intent_query"), r11, r12);
    L19:
        r17 = Uri.parse(r15);     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        int r18 = r10.getPosition();     // Catch: RuntimeException -> L24
    L25:
        Log.w("SearchView", "Search suggestions cursor at row " + r18 + " returned exception.", e);
        return null;
    L24:
        r18 = -1;
        goto L25
    }

    public final Intent g(Intent r10, SearchableInfo r11) {
        ComponentName r12 = r11.getSearchActivity();
        Intent r13 = new Intent("android.intent.action.SEARCH");
        r13.setComponent(r12);
        PendingIntent r14 = PendingIntent.getActivity(getContext(), 0, r13, 1107296256);
        Bundle r15 = new Bundle();
        Bundle r16 = this.O;
        if (r16 == null) goto L5;
        r15.putParcelable("app_data", r16);
    L5:
        Intent r17 = new Intent(r10);
        Resources r18 = getResources();
        if (r11.getVoiceLanguageModeId() == 0) goto L8;
        String r19 = r18.getString(r11.getVoiceLanguageModeId());
    L9:
        String r20 = null;
        if (r11.getVoicePromptTextId() == 0) goto L12;
        String r21 = r18.getString(r11.getVoicePromptTextId());
    L14:
        if (r11.getVoiceLanguageId() == 0) goto L16;
        String r22 = r18.getString(r11.getVoiceLanguageId());
    L18:
        if (r11.getVoiceMaxResults() == 0) goto L20;
        int r23 = r11.getVoiceMaxResults();
    L21:
        r17.putExtra("android.speech.extra.LANGUAGE_MODEL", r19);
        r17.putExtra("android.speech.extra.PROMPT", r21);
        r17.putExtra("android.speech.extra.LANGUAGE", r22);
        r17.putExtra("android.speech.extra.MAX_RESULTS", r23);
        if (r12 == null) goto L25;
        r20 = r12.flattenToShortString();
    L25:
        r17.putExtra("calling_package", r20);
        r17.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", r14);
        r17.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", r15);
        return r17;
    L20:
        r23 = 1;
        goto L21
    L16:
        r22 = null;
        goto L18
    L12:
        r21 = null;
        goto L14
    L8:
        r19 = "free_form";
        goto L9
    }

    public int getImeOptions() {
        return this.f896a.getImeOptions();
    }

    public int getInputType() {
        return this.f896a.getInputType();
    }

    public int getMaxWidth() {
        return this.H;
    }

    public CharSequence getQuery() {
        return this.f896a.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence r10 = this.E;
        if (r10 != null) goto L13;
        SearchableInfo r11 = this.N;
        if (r11 == null) goto L11;
        if (r11.getHintId() == 0) goto L11;
        return getContext().getText(this.N.getHintId());
    L11:
        return this.f917u;
    L13:
        return r10;
    }

    public int getSuggestionCommitIconResId() {
        return this.f914r;
    }

    public int getSuggestionRowLayout() {
        return this.f913q;
    }

    public androidx.cursoradapter.widget.a getSuggestionsAdapter() {
        return this.C;
    }

    public final Intent h(Intent r10, SearchableInfo r11) {
        Intent r12 = new Intent(r10);
        ComponentName r13 = r11.getSearchActivity();
        if (r13 != null) goto L5;
        String r14 = null;
    L6:
        r12.putExtra("calling_package", r14);
        return r12;
    L5:
        r14 = r13.flattenToShortString();
        goto L6
    }

    public final void i() {
        this.f896a.dismissDropDown();
    }

    public void j() {
        k.a(this.f896a);
    }

    public final void k(View r10, Rect r11) {
        r10.getLocationInWindow(this.f909m);
        getLocationInWindow(this.f910n);
        int[] r12 = this.f909m;
        int r13 = r12[1];
        int[] r14 = this.f910n;
        int r15 = r13 - r14[1];
        int r16 = r12[0] - r14[0];
        r11.set(r16, r15, r10.getWidth() + r16, r10.getHeight() + r15);
    }

    public final CharSequence l(CharSequence r10) {
        if (this.A == true) goto L5;
    L9:
        return r10;
    L5:
        if (this.f912p == null) goto L9;
        int r11 = (int) (((double) this.f896a.getTextSize()) * 1.25d);
        this.f912p.setBounds(0, 0, r11, r11);
        SpannableStringBuilder r12 = new SpannableStringBuilder("   ");
        r12.setSpan(new ImageSpan(this.f912p), 1, 2, 33);
        r12.append(r10);
        return r12;
    }

    public final boolean m() {
        SearchableInfo r10 = this.N;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.getVoiceSearchEnabled() == true) goto L7;
        return false;
    L7:
        if (this.N.getVoiceSearchLaunchWebSearch() == false) goto L10;
        Intent r11 = this.f915s;
    L13:
        if (r11 != null) goto L15;
        return false;
    L15:
        if (getContext().getPackageManager().resolveActivity(r11, 65536) == null) goto L21;
        return true;
    L21:
        return false;
    L10:
        if (this.N.getVoiceSearchLaunchRecognizer() == false) goto L12;
        r11 = this.f916t;
        goto L13
    L12:
        r11 = null;
        goto L13
    }

    public boolean n() {
        return this.B;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        F("", false);
        clearFocus();
        M(true);
        this.f896a.setImeOptions(this.M);
        this.L = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (this.L == false) goto L5;
        return;
    L5:
        this.L = true;
        int r10 = this.f896a.getImeOptions();
        this.M = r10;
        this.f896a.setImeOptions(r10 | 33554432);
        this.f896a.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.P);
        post(this.Q);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (r10 == false) goto L9;
        k(this.f896a, this.f907k);
        Rect r15 = this.f908l;
        Rect r16 = this.f907k;
        r15.set(r16.left, 0, r16.right, r14 - r12);
        m r17 = this.f906j;
        if (r17 != null) goto L7;
        m r18 = new m(this.f908l, this.f907k, this.f896a);
        this.f906j = r18;
        setTouchDelegate(r18);
        return;
    L7:
        r17.a(this.f908l, this.f907k);
        return;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r10, int r11) {
        if (n() == false) goto L6;
        super.onMeasure(r10, r11);
        return;
    L6:
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        if (r12 == Integer.MIN_VALUE) goto L18;
        if (r12 == 0) goto L14;
        if (r12 != 1073741824) goto L22;
        int r14 = this.H;
        if (r14 <= 0) goto L22;
        r13 = Math.min(r14, r13);
    L22:
        int r15 = View.MeasureSpec.getMode(r11);
        int r16 = View.MeasureSpec.getSize(r11);
        if (r15 == Integer.MIN_VALUE) goto L27;
        if (r15 != 0) goto L28;
        r16 = getPreferredHeight();
    L28:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r13, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r16, Ints.MAX_POWER_OF_TWO));
        return;
    L27:
        r16 = Math.min(getPreferredHeight(), r16);
        goto L28
    L14:
        r13 = this.H;
        if (r13 > 0) goto L22;
        r13 = getPreferredWidth();
        goto L22
    L18:
        int r17 = this.H;
        if (r17 <= 0) goto L21;
        r13 = Math.min(r17, r13);
        goto L22
    L21:
        r13 = Math.min(getPreferredWidth(), r13);
        goto L22
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        M(r11.isIconified);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.isIconified = n();
        return r10;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r10) {
        super.onWindowFocusChanged(r10);
        D();
    }

    public final boolean p() {
        if (this.D == true) goto L7;
        if (this.I == true) goto L7;
    L9:
        return false;
    L7:
        if (n() == true) goto L9;
        return true;
    }

    public final void q(Intent r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        getContext().startActivity(r10);     // Catch: RuntimeException -> L6
        return;
    L6:
        e = move-exception;
        Log.e("SearchView", "Failed launch activity: " + r10, e);
    }

    public void r(int r10, String r11, String r12) {
        Intent r13 = e("android.intent.action.SEARCH", null, null, r12, r10, r11);
        getContext().startActivity(r13);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int r10, Rect r11) {
        if (this.G == false) goto L6;
        return false;
    L6:
        if (isFocusable() == true) goto L9;
        return false;
    L9:
        if (n() == true) goto L15;
        boolean r12 = this.f896a.requestFocus(r10, r11);
        if (r12 == false) goto L13;
        M(false);
    L13:
        return r12;
    L15:
        return super.requestFocus(r10, r11);
    }

    public final boolean s(int r10, int r11, String r12) {
        Cursor r13 = this.C.getCursor();
        if (r13 != null) goto L5;
        return false;
    L5:
        if (r13.moveToPosition(r10) == false) goto L10;
        q(f(r13, r11, r12));
        return true;
    L10:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle r10) {
        this.O = r10;
    }

    public void setIconified(boolean r10) {
        if (r10 == false) goto L4;
        t();
        return;
    L4:
        x();
    }

    public void setIconifiedByDefault(boolean r10) {
        if (this.A != r10) goto L5;
        return;
    L5:
        this.A = r10;
        M(r10);
        I();
    }

    public void setImeOptions(int r10) {
        this.f896a.setImeOptions(r10);
    }

    public void setInputType(int r10) {
        this.f896a.setInputType(r10);
    }

    public void setMaxWidth(int r10) {
        this.H = r10;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener r10) {
        this.f919w = r10;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener r10) {
        this.f920x = r10;
    }

    public void setOnQueryTextListener(OnQueryTextListener r10) {
        this.f918v = r10;
    }

    public void setOnSearchClickListener(View.OnClickListener r10) {
        this.f922z = r10;
    }

    public void setOnSuggestionListener(OnSuggestionListener r10) {
        this.f921y = r10;
    }

    public void setQueryHint(@Nullable CharSequence r10) {
        this.E = r10;
        I();
    }

    public void setQueryRefinementEnabled(boolean r10) {
        this.F = r10;
        androidx.cursoradapter.widget.a r11 = this.C;
        if ((r11 instanceof w) == false) goto L10;
        w r12 = (w) r11;
        if (r10 == false) goto L7;
        int r13 = 2;
    L8:
        r12.t(r13);
        return;
    L7:
        r13 = 1;
        goto L8
    }

    public void setSearchableInfo(SearchableInfo r10) {
        this.N = r10;
        if (r10 == null) goto L5;
        J();
        I();
    L5:
        boolean r11 = m();
        this.I = r11;
        if (r11 == false) goto L8;
        this.f896a.setPrivateImeOptions("nm");
    L8:
        M(n());
    }

    public void setSubmitButtonEnabled(boolean r10) {
        this.D = r10;
        M(n());
    }

    public void setSuggestionsAdapter(androidx.cursoradapter.widget.a r10) {
        this.C = r10;
        this.f896a.setAdapter(r10);
    }

    public void t() {
        if (TextUtils.isEmpty(this.f896a.getText()) == true) goto L5;
        this.f896a.setText("");
        this.f896a.requestFocus();
        this.f896a.setImeVisibility(true);
        return;
    L5:
        if (this.A == false) goto L13;
        OnCloseListener r10 = this.f919w;
        if (r10 != null) goto L9;
    L10:
        clearFocus();
        M(true);
        return;
    L9:
        if (r10.onClose() == false) goto L10;
        return;
    }

    public boolean u(int r10, int r11, String r12) {
        OnSuggestionListener r13 = this.f921y;
        if (r13 != null) goto L5;
    L8:
        s(r10, 0, null);
        this.f896a.setImeVisibility(false);
        i();
        return true;
    L5:
        if (r13.onSuggestionClick(r10) == false) goto L8;
        return false;
    }

    public boolean v(int r10) {
        OnSuggestionListener r11 = this.f921y;
        if (r11 != null) goto L5;
    L9:
        E(r10);
        return true;
    L5:
        if (r11.onSuggestionSelect(r10) == false) goto L9;
        return false;
    }

    public void w(CharSequence r10) {
        setQuery(r10);
    }

    public void x() {
        M(false);
        this.f896a.requestFocus();
        this.f896a.setImeVisibility(true);
        View.OnClickListener r10 = this.f922z;
        if (r10 == null) goto L6;
        r10.onClick(this);
        return;
    }

    public void y() {
        Editable r10 = this.f896a.getText();
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.getTrimmedLength(r10) <= 0) goto L16;
        OnQueryTextListener r11 = this.f918v;
        if (r11 == null) goto L11;
        if (r11.onQueryTextSubmit(r10.toString()) == false) goto L11;
        return;
    L11:
        if (this.N == null) goto L13;
        r(0, null, r10.toString());
    L13:
        this.f896a.setImeVisibility(false);
        i();
        return;
    }

    public boolean z(View r10, int r11, KeyEvent r12) {
        if (this.N != null) goto L6;
        return false;
    L6:
        if (this.C != null) goto L9;
        return false;
    L9:
        if (r12.getAction() == 0) goto L11;
    L35:
        return false;
    L11:
        if (r12.hasNoModifiers() == false) goto L35;
        if (r11 == 66) goto L34;
        if (r11 == 84) goto L34;
        if (r11 == 61) goto L34;
        if (r11 != 21) goto L22;
    L28:
        if (r11 != 21) goto L30;
        int r13 = 0;
    L31:
        this.f896a.setSelection(r13);
        this.f896a.setListSelection(0);
        this.f896a.clearListSelection();
        this.f896a.a();
        return true;
    L30:
        r13 = this.f896a.length();
        goto L31
    L22:
        if (r11 == 22) goto L28;
        if (r11 != 19) goto L35;
        this.f896a.getListSelection();
        return false;
    L34:
        return u(this.f896a.getListSelection(), 0, null);
    }

    public SearchView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.searchViewStyle);
    }

    public SearchView(@NonNull Context r17, @Nullable AttributeSet r18, int r19) {
        super(r17, r18, r19);
        this.f907k = new Rect();
        this.f908l = new Rect();
        this.f909m = new int[2];
        this.f910n = new int[2];
        this.P = new b(this);
        this.Q = new c(this);
        this.R = new WeakHashMap();
        f r10 = new f(this);
        this.S = r10;
        this.T = new g(this);
        h r11 = new h(this);
        this.U = r11;
        i r12 = new i(this);
        this.V = r12;
        j r13 = new j(this);
        this.W = r13;
        this.f897a0 = new a(this);
        int[] r14 = R$styleable.SearchView;
        b0 r15 = b0.v(r17, r18, r14, r19, 0);
        ViewCompat.n0(this, r17, r14, r18, r15.r(), r19, 0);
        LayoutInflater.from(r17).inflate(r15.n(R$styleable.SearchView_layout, R$layout.abc_search_view), this, true);
        SearchAutoComplete r16 = (SearchAutoComplete) findViewById(R$id.search_src_text);
        this.f896a = r16;
        r16.setSearchView(this);
        this.f898b = findViewById(R$id.search_edit_frame);
        View r20 = findViewById(R$id.search_plate);
        this.f899c = r20;
        View r21 = findViewById(R$id.submit_area);
        this.f900d = r21;
        ImageView r22 = (ImageView) findViewById(R$id.search_button);
        this.f901e = r22;
        ImageView r23 = (ImageView) findViewById(R$id.search_go_btn);
        this.f902f = r23;
        ImageView r24 = (ImageView) findViewById(R$id.search_close_btn);
        this.f903g = r24;
        ImageView r110 = (ImageView) findViewById(R$id.search_voice_btn);
        this.f904h = r110;
        ImageView r111 = (ImageView) findViewById(R$id.search_mag_icon);
        this.f911o = r111;
        ViewCompat.t0(r20, r15.g(R$styleable.SearchView_queryBackground));
        ViewCompat.t0(r21, r15.g(R$styleable.SearchView_submitBackground));
        int r25 = R$styleable.SearchView_searchIcon;
        r22.setImageDrawable(r15.g(r25));
        r23.setImageDrawable(r15.g(R$styleable.SearchView_goIcon));
        r24.setImageDrawable(r15.g(R$styleable.SearchView_closeIcon));
        r110.setImageDrawable(r15.g(R$styleable.SearchView_voiceIcon));
        r111.setImageDrawable(r15.g(r25));
        this.f912p = r15.g(R$styleable.SearchView_searchHintIcon);
        g0.a(r22, getResources().getString(R$string.abc_searchview_description_search));
        this.f913q = r15.n(R$styleable.SearchView_suggestionRowLayout, R$layout.abc_search_dropdown_item_icons_2line);
        this.f914r = r15.n(R$styleable.SearchView_commitIcon, 0);
        r22.setOnClickListener(r10);
        r24.setOnClickListener(r10);
        r23.setOnClickListener(r10);
        r110.setOnClickListener(r10);
        r16.setOnClickListener(r10);
        r16.addTextChangedListener(this.f897a0);
        r16.setOnEditorActionListener(r11);
        r16.setOnItemClickListener(r12);
        r16.setOnItemSelectedListener(r13);
        r16.setOnKeyListener(this.T);
        r16.setOnFocusChangeListener(new d(this));
        setIconifiedByDefault(r15.a(R$styleable.SearchView_iconifiedByDefault, true));
        int r26 = r15.f(R$styleable.SearchView_android_maxWidth, -1);
        if (r26 == (-1)) goto L5;
        setMaxWidth(r26);
    L5:
        this.f917u = r15.p(R$styleable.SearchView_defaultQueryHint);
        this.E = r15.p(R$styleable.SearchView_queryHint);
        int r27 = r15.k(R$styleable.SearchView_android_imeOptions, -1);
        if (r27 == (-1)) goto L8;
        setImeOptions(r27);
    L8:
        int r28 = r15.k(R$styleable.SearchView_android_inputType, -1);
        if (r28 == (-1)) goto L11;
        setInputType(r28);
    L11:
        setFocusable(r15.a(R$styleable.SearchView_android_focusable, true));
        r15.w();
        Intent r29 = new Intent("android.speech.action.WEB_SEARCH");
        this.f915s = r29;
        r29.addFlags(268435456);
        r29.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent r30 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f916t = r30;
        r30.addFlags(268435456);
        View r31 = findViewById(r16.getDropDownAnchor());
        this.f905i = r31;
        if (r31 == null) goto L14;
        r31.addOnLayoutChangeListener(new e(this));
    L14:
        M(this.A);
        I();
    }
}
