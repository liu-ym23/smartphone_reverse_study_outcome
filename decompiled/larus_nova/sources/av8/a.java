package av8;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f16387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f16388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f16389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f16390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ EditText f16391e;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toString();
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        if ((r101.length() + b.a(r101)) <= this.f16389c) goto L25;
        int r102 = this.f16387a.element.length() + b.a(this.f16387a.element);
        int r103 = this.f16389c;
        if (r102 <= r103) goto L13;
        this.f16388b.element = 0;
        this.f16387a.element = "";
        r102 = 0;
    L13:
        int r104 = r103 - r102;
        int r105 = r101.length() - 1;
        int r106 = this.f16388b.element;
        int r107 = r101.length();
    L14:
        if (r106 >= r107) goto L19;
        r104 = r104 - (b.a(String.valueOf(r101.charAt(r106))) + 1);
        if (r104 < 0) goto L17;
        r106 = r106 + 1;
        goto L14
    L17:
        r105 = r106;
    L19:
        Ref.ObjectRef<String> r108 = this.f16387a;
        Ref.IntRef r109 = this.f16388b;
        EditText r110 = this.f16391e;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L22
        r101 = r101.substring(0, r105) + r108.element.substring(r109.element);     // Catch: Throwable -> L22
        r110.setText(r101);     // Catch: Throwable -> L22
        r110.setSelection(r105);     // Catch: Throwable -> L22
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        this.f16390d.invoke(r101);
        return;
    L22:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L25:
        this.f16390d.invoke(r101);
        return;
    L4:
        r101 = null;
        goto L6
    }

    public a(Ref.ObjectRef r100, Ref.IntRef r101, com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.b r102, AppCompatEditText r103) {
        this.f16387a = r100;
        this.f16388b = r101;
        this.f16389c = 180;
        this.f16390d = r102;
        this.f16391e = r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [T] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (r100 == null) goto L4;
        ?? r104 = r100.toString();
    L5:
        if (r104 != 0) goto L7;
        r104 = "";
    L7:
        this.f16387a.element = r104;
        return;
    L4:
        r104 = 0;
        goto L5
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        this.f16388b.element = r101;
    }
}
