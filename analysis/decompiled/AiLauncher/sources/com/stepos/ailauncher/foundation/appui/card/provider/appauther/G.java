package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import Z8.C1174w;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.C3302q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\b\u0000\u0018\u0000 &2\u00020\u0001:\u0002'(B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u000e\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u0015J\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/G;", "", "Landroid/widget/LinearLayout;", "container", "<init>", "(Landroid/widget/LinearLayout;)V", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/r;", "fields", "", "visible", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q$a;", "key", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;ZLcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q$a;)V", "", "", "s", "()Ljava/util/Map;", "m", "()V", "n", "t", "(Ljava/util/List;)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/G$b;", "row", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/G$b;)V", "o", "l", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/widget/LinearLayout;", "", "rows", "Ljava/util/List;", "draftKey", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q$a;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G {
    private static final a Companion = new a(null);

    @Deprecated
    public static final float FIELD_GAP_DP = 16.0f;
    private final LinearLayout container;
    private C3302q.Key draftKey;
    private final List<b> rows;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/G$a;", "", "<init>", "()V", "", "FIELD_GAP_DP", "F", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/G$b;", "", "", "name", "", "secret", "label", "LT5/i;", "binding", "<init>", "(Ljava/lang/String;ZLjava/lang/String;LT5/i;)V", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Z", "e", "()Z", Const.INTENT_KEY_PKGNAME, "LT5/i;", Const.INTENT_KEY_APIKEY, "()LT5/i;", "plainVisible", Const.INTENT_KEY_UMID, "f", "(Z)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        private final T5.i binding;
        private final String label;
        private final String name;
        private boolean plainVisible;
        private final boolean secret;

        public b(String name, boolean z10, String label, T5.i binding) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(label, "label");
            kotlin.jvm.internal.p.i(binding, "binding");
            this.name = name;
            this.secret = z10;
            this.label = label;
            this.binding = binding;
        }

        /* renamed from: a, reason: from getter */
        public final T5.i getBinding() {
            return this.binding;
        }

        /* renamed from: b, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: c, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getPlainVisible() {
            return this.plainVisible;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getSecret() {
            return this.secret;
        }

        public final void f(boolean z10) {
            this.plainVisible = z10;
        }
    }

    public G(LinearLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        this.container = container;
        this.rows = new ArrayList();
    }

    public static final void j(b bVar, G g10, View view) {
        bVar.f(!bVar.getPlainVisible());
        g10.g(bVar);
        R5.b.INSTANCE.c("auther.key.toggle", Y8.j.a("visible", Boolean.valueOf(bVar.getPlainVisible())));
    }

    public static final void k(G g10, b bVar, View view) {
        g10.o(bVar);
    }

    public static final Y8.t p(C3302q.Key key, b bVar, String value) {
        kotlin.jvm.internal.p.i(value, "value");
        C3302q.INSTANCE.b(key, bVar.getName(), value);
        return Y8.t.f7040a;
    }

    public static final Y8.t q(C3302q.Key key, b bVar, String str) {
        C3302q.INSTANCE.b(key, bVar.getName(), str);
        return Y8.t.f7040a;
    }

    public static final Y8.t r(C3302q.Key key, b bVar, G g10, String value) {
        kotlin.jvm.internal.p.i(value, "value");
        C3302q.INSTANCE.b(key, bVar.getName(), value);
        bVar.getBinding().etKeyFieldValue.setText(value);
        g10.g(bVar);
        R5.b.INSTANCE.c("auther.key.filled", Y8.j.a("field", bVar.getName()), Y8.j.a("len", Integer.valueOf(value.length())));
        return Y8.t.f7040a;
    }

    public static final CharSequence u(b it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getName();
    }

    public final void g(b row) {
        EditText etKeyFieldValue = row.getBinding().etKeyFieldValue;
        kotlin.jvm.internal.p.h(etKeyFieldValue, "etKeyFieldValue");
        etKeyFieldValue.setInputType(row.getPlainVisible() ? 145 : 129);
        Editable text = etKeyFieldValue.getText();
        etKeyFieldValue.setSelection(text != null ? text.length() : 0);
        if (row.getSecret()) {
            row.getBinding().ivKeyFieldEye.setImageResource(row.getPlainVisible() ? R$drawable.ic_card_auther_eye : R$drawable.ic_card_auther_eye_off);
            row.getBinding().ivKeyFieldEye.setContentDescription(row.getPlainVisible() ? "隐藏密匙" : "显示密匙");
        }
    }

    public final void h(List<AppAutherField> fields, boolean visible, C3302q.Key key) {
        kotlin.jvm.internal.p.i(fields, "fields");
        kotlin.jvm.internal.p.i(key, "key");
        C3302q.Key key2 = this.draftKey;
        if (key2 != null && !kotlin.jvm.internal.p.d(key2, key)) {
            n();
            C3302q.INSTANCE.a(key2);
            l();
        }
        this.draftKey = key;
        this.container.setVisibility(visible ? 0 : 8);
        if (!visible) {
            m();
            return;
        }
        List<AppAutherField> list = fields;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String name = ((AppAutherField) it.next()).getName();
            if (name == null) {
                name = "";
            }
            arrayList.add(name);
        }
        List<b> list2 = this.rows;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((b) it2.next()).getName());
        }
        if (kotlin.jvm.internal.p.d(arrayList, arrayList2)) {
            return;
        }
        t(fields);
    }

    public final void i(final b row) {
        T5.i binding = row.getBinding();
        binding.tvKeyFieldLabel.setText(row.getLabel());
        binding.ivKeyFieldEye.setVisibility(row.getSecret() ? 0 : 8);
        if (row.getSecret()) {
            binding.ivKeyFieldEye.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    G.j(row, this, view);
                }
            });
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.B
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                G.k(this.f27324a, row, view);
            }
        };
        binding.llKeyFieldRow.setOnClickListener(onClickListener);
        binding.etKeyFieldValue.setOnClickListener(onClickListener);
        g(row);
    }

    public final void l() {
        Iterator<T> it = this.rows.iterator();
        while (it.hasNext()) {
            ((b) it.next()).getBinding().etKeyFieldValue.setText((CharSequence) null);
        }
    }

    public final void m() {
        n();
        C3302q.Key key = this.draftKey;
        if (key != null) {
            C3302q.INSTANCE.a(key);
        }
        l();
    }

    public final void n() {
        S.INSTANCE.w(this);
    }

    public final void o(final b row) {
        final C3302q.Key key = this.draftKey;
        if (key == null) {
            return;
        }
        Editable text = row.getBinding().etKeyFieldValue.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        final String str = string;
        S s10 = S.INSTANCE;
        LinearLayout llKeyFieldRow = row.getBinding().llKeyFieldRow;
        kotlin.jvm.internal.p.h(llKeyFieldRow, "llKeyFieldRow");
        s10.L(this, llKeyFieldRow, row.getLabel(), str, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.C
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return G.p(key, row, (String) obj);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.D
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return G.q(key, row, str);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return G.r(key, row, this, (String) obj);
            }
        });
    }

    public final Map<String, String> s() {
        String string;
        List<b> list = this.rows;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
        for (b bVar : list) {
            String name = bVar.getName();
            Editable text = bVar.getBinding().etKeyFieldValue.getText();
            String string2 = (text == null || (string = text.toString()) == null) ? null : La.H.D1(string).toString();
            if (string2 == null) {
                string2 = "";
            }
            Pair pairA = Y8.j.a(name, string2);
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(java.util.List<com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherField> r12) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.appauther.G.t(java.util.List):void");
    }
}
