package aob;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.base.e;
import com.ss.android.lark.keyboard.base.f;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.base.l;
import com.ss.android.lark.keyboard.base.q;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements wnb.b<a>, l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0204a f15809e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f15810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f15811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wnb.c f15812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f15813d;

    /* JADX INFO: renamed from: aob.a$a, reason: collision with other inner class name */
    public static final class C0204a implements wnb.b.a<a> {
        public C0204a() {
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f15814a;

        public b(a r100) {
            this.f15814a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.ss.android.lark.keyboard.keyboard2.b r101 = this.f15814a.f().L();
            if ((r101 instanceof f) == false) goto L5;
            f r102 = (f) r101;
        L6:
            if (r102 == null) goto L9;
            r102.D();
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f15815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f15816b;

        /* JADX INFO: renamed from: aob.a$c$a, reason: collision with other inner class name */
        public static final class RunnableC0205a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f15817a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ EditText f15818b;

            public RunnableC0205a(a r100, EditText r101) {
                this.f15817a = r100;
                this.f15818b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a r100 = this.f15817a;     // Catch: Throwable -> L11
                if (this.f15818b.getLineCount() < 3) goto L5;
                boolean r101 = true;
            L6:
                C0204a r102 = a.f15809e;     // Catch: Throwable -> L11
                if (r101 == false) goto L9;
                r100.h().a(r102);     // Catch: Throwable -> L11
            L16:
                return;
            L9:
                r100.h().b(r102);     // Catch: Throwable -> L11
                goto L16
            L5:
                r101 = false;
            L11:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            }
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public c(EditText r100, a r101) {
            this.f15815a = r100;
            this.f15816b = r101;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            EditText r104 = this.f15815a;
            r104.post(new RunnableC0205a(this.f15816b, r104));
        }
    }

    static {
        f15809e = new C0204a();
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final boolean g(q r100) {
        return false;
    }

    @Override // wnb.b
    public final boolean i() {
        return false;
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final void y(boolean r100) {
    }

    @Override // wnb.b
    public final View a() {
        f r100 = null;
        View r101 = LayoutInflater.from(this.f15810a.f410096a.requireContext()).inflate(R.layout.item_icon_button_transform, null);
        ImageView r102 = (ImageView) r101.findViewById(R.id.ivTransform);
        r101.setOnClickListener(new b(this));
        this.f15813d = r101;
        com.ss.android.lark.keyboard.keyboard2.b r103 = f().L();
        if ((r103 instanceof f) == false) goto L5;
        f r104 = (f) r103;
    L6:
        if (r104 == null) goto L8;
        r104.p(this);
    L8:
        com.ss.android.lark.keyboard.keyboard2.b r105 = f().L();
        if ((r105 instanceof f) == false) goto L11;
        r100 = (f) r105;
    L11:
        boolean r106 = false;
        if (r100 == null) goto L14;
        int r107 = e.f428229a;
        r100.N(false);
    L14:
        EditText r108 = f().L().c();
        if (r108.getLineCount() < 3) goto L17;
        r106 = true;
    L17:
        C0204a r109 = f15809e;
        if (r106 == false) goto L20;
        h().a(r109);
    L21:
        r108.addTextChangedListener(new c(r108, this));
        Intrinsics.checkNotNull(r101);
        return r101;
    L20:
        h().b(r109);
        goto L21
    L5:
        r104 = null;
        goto L6
    }

    @Override // wnb.b
    public final wnb.e b() {
        return new wnb.e(UIHelper.dp2px(6.0f), 0, UIHelper.dp2px(12.0f), 0);
    }

    public final com.ss.android.lark.keyboard.b f() {
        com.ss.android.lark.keyboard.b r100 = this.f15811b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        return null;
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r100 = this.f15812c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        View r100 = this.f15813d;
        if (r100 == null) goto L5;
        r100.setOnClickListener(null);
    L5:
        View r101 = this.f15813d;
        if (r101 == null) goto L21;
        r101.setOnLongClickListener(null);
    L21:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        com.ss.android.lark.keyboard.keyboard2.b r103 = f().L();     // Catch: Throwable -> L17
        if ((r103 instanceof f) == false) goto L11;
        f r104 = (f) r103;     // Catch: Throwable -> L17
    L12:
        if (r104 == null) goto L14;
        r104.E(this);     // Catch: Throwable -> L17
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L17
    L19:
        this.f15813d = null;
        return;
    L14:
        r105 = null;
        goto L15
    L11:
        r104 = null;
    L17:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerEndVertical;
    }

    @Override // wnb.b
    public final wnb.b.a<a> getKey() {
        return f15809e;
    }

    public a(com.ss.android.lark.biz.im.api.extension.chat_window.b r100) {
        Intrinsics.checkNotNullParameter(r100, "keyboardPluginContext");
        this.f15810a = r100;
    }

    @Override // wnb.b
    public final void e(InputInnerController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f15812c = r100;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f15811b = r100;
    }
}
