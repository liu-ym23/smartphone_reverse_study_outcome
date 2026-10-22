package com.bytedanceos.appstore.buss.utilities;

import com.bytedanceos.appstore.buss.cms.beta.TemplateHelper;
import com.bytedanceos.appstore.buss.cms.beta.entity.BetaTemplateEntity;
import com.bytedanceos.appstore.buss.cms.beta.item.ElementItem;
import com.bytedanceos.appstore.buss.cms.beta.item.TemplateItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementPrimaryNavigationItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplatePrimaryNavigationItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementPrimaryNavigationItem;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.utilities.CmsHelper$parseCMSNavigationData$2", f = "CmsHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nCmsHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CmsHelper.kt\ncom/bytedanceos/appstore/buss/utilities/CmsHelper$parseCMSNavigationData$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1864#2,2:104\n1855#2,2:106\n1866#2:108\n*S KotlinDebug\n*F\n+ 1 CmsHelper.kt\ncom/bytedanceos/appstore/buss/utilities/CmsHelper$parseCMSNavigationData$2\n*L\n87#1:104,2\n91#1:106,2\n87#1:108\n*E\n"})
final class CmsHelper$parseCMSNavigationData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<ElementPrimaryNavigationItem>>, Object> {
    final /* synthetic */ List<BetaTemplateEntity> $templateList;
    int label;

    public CmsHelper$parseCMSNavigationData$2(List<BetaTemplateEntity> r10, Continuation<? super CmsHelper$parseCMSNavigationData$2> r11) {
        this.$templateList = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new CmsHelper$parseCMSNavigationData$2(this.$templateList, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super ArrayList<ElementPrimaryNavigationItem>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L28;
        kotlin.c.b(r10);
        ArrayList r11 = new ArrayList();
        List<BetaTemplateEntity> r12 = this.$templateList;
        if (r12 != null) goto L7;
    L26:
        return r11;
    L7:
        if (r12.isEmpty() == true) goto L26;
        Iterator<T> r13 = TemplateHelper.INSTANCE.buildTemplateItemList(this.$templateList).iterator();
        int r14 = 0;
    L11:
        if (r13.hasNext() == false) goto L26;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L15;
        kotlin.collections.t.q();
    L15:
        TemplateItem r17 = (TemplateItem) r15;
        if ((r17 instanceof TemplatePrimaryNavigationItem) == false) goto L25;
        if (r17.isAvailable() == false) goto L25;
        Iterator<T> r18 = r17.getItemList().iterator();
    L21:
        if (r18.hasNext() == false) goto L25;
        ElementItem r19 = (ElementItem) r18.next();
        if ((r19 instanceof ElementPrimaryNavigationItem) == false) goto L21;
        r11.add(r19);
    L25:
        r14 = r16;
        goto L11
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super ArrayList<ElementPrimaryNavigationItem>> r11) {
        return ((CmsHelper$parseCMSNavigationData$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
