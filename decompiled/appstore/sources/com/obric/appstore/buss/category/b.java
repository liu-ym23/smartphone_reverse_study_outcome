package com.obric.appstore.buss.category;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.common.model.Category;
import com.bytedanceos.common.model.IAppInfoKt;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.base.j;
import com.obric.appstore.base.n;
import com.obric.appstore.base.o;
import com.obric.appstore.buss.repo.StoreRepo;
import com.obric.appstore.network.entity.CategoryResp;
import com.obric.appstore.network.entity.PageResp;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData f10605k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData f10606l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableLiveData f10607m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f10608n;

    public b() {
        this.f10605k = new MutableLiveData();
        this.f10606l = new MutableLiveData();
        this.f10607m = new MutableLiveData();
        this.f10608n = "";
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.appstore.base.IPageLoadViewModel
    public void D(PageResp r10, n r11) {
        q.g(r11, Card.KEY_API_LOAD_PARAMS);
        if (r10 == null) goto L6;
        Triple r12 = (Triple) r10.getExtras();
        if (r12 == null) goto L6;
    L7:
        CategoryResp r13 = (CategoryResp) r12.component1();
        List r14 = (List) r12.component2();
        CategoryResp r15 = (CategoryResp) r12.component3();
        MutableLiveData r16 = this.f10605k;
        Category r17 = new Category();
        String r18 = "";
        if (r13 == null) goto L11;
        String r19 = Long.valueOf(r13.getId()).toString();
        if (r19 == null) goto L11;
    L12:
        r17.setId(r19);
        if (r13 == null) goto L16;
        String r20 = r13.getName();
        if (r20 == null) goto L16;
    L17:
        r17.setName(r20);
        r16.p(r17);
        MutableLiveData r21 = this.f10606l;
        if (r14 == null) goto L23;
        Collection r22 = new ArrayList(u.r(r14, 10));
        Iterator r23 = r14.iterator();
    L21:
        if (r23.hasNext() == false) goto L24;
        CategoryResp r24 = (CategoryResp) r23.next();
        Category r25 = new Category();
        r25.setId(String.valueOf(r24.getId()));
        r25.setName(r24.getName());
        r25.setParent_id(this.f10608n);
        r22.add(r25);
    L24:
        r21.p(r22);
        CharSequence r26 = (CharSequence) this.f10607m.e();
        if (r26 != null) goto L27;
    L28:
        MutableLiveData r27 = this.f10607m;
        if (r15 == null) goto L34;
        String r28 = Long.valueOf(r15.getId()).toString();
        if (r28 == null) goto L34;
        r18 = r28;
    L41:
        r27.p(r18);
    L42:
        super.D(r10, r11);
        return;
    L34:
        List r29 = (List) this.f10606l.e();
        if (r29 == null) goto L41;
        Category r30 = (Category) b0.Z(r29);
        if (r30 == null) goto L41;
        String r31 = r30.getId();
        if (r31 == null) goto L41;
        r18 = r31.toString();
        goto L41
    L27:
        if (r26.length() != 0) goto L42;
    L23:
        r22 = t.i();
    L16:
        r20 = "";
    L11:
        r19 = "";
    L6:
        r12 = new Triple(null, null, null);
        goto L7
    }

    public final void F(String r10) {
        q.g(r10, "secondId");
        if (q.b(I(), r10) == false) goto L5;
        return;
    L5:
        if (r10.length() == 0) goto L16;
        Collection r11 = (Collection) this.f10606l.e();
        if (r11 != null) goto L10;
        return;
    L10:
        if (r11.isEmpty() == true) goto L17;
        this.f10607m.p(r10);
        a();
        ILoadViewModel.s(this, true, false, 2, null);
        return;
    L17:
        return;
    }

    public Object G(n r10, Continuation r11) {
        return StoreRepo.f10831a.g(this.f10608n, I(), r10.d(), r11);
    }

    public final String H() {
        return this.f10608n;
    }

    public final String I() {
        String r10 = (String) this.f10607m.e();
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10;
    }

    public final MutableLiveData J() {
        return this.f10606l;
    }

    public final MutableLiveData K() {
        return this.f10605k;
    }

    public final MutableLiveData L() {
        return this.f10607m;
    }

    public final void M(String r10, String r11) {
        q.g(r10, "firstId");
        q.g(r11, "secondId");
        this.f10608n = r10;
        this.f10607m.p(r11);
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public /* bridge */ /* synthetic */ Object j(j r10, Continuation r11) {
        return G((n) r10, r11);
    }

    @Override // com.obric.appstore.base.IPageLoadViewModel, com.obric.appstore.base.ILoadViewModel
    public /* bridge */ /* synthetic */ void t(Object r10, j r11) {
        D((PageResp) r10, (n) r11);
    }

    @Override // com.obric.appstore.base.IPageLoadViewModel
    public List x(List r10, List r11) {
        q.g(r10, "currList");
        q.g(r11, "moreList");
        return IAppInfoKt.filter(r11, r10);
    }
}
