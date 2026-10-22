package com.stepos.stepclaw.provider.handlers;

import a6.f0;
import android.content.ContentValues;
import b5.a0;
import f5.c;
import h5.e;
import h5.i;
import kotlin.Metadata;
import org.bouncycastle.asn1.BERTags;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lcom/stepos/stepclaw/provider/backend/ConfigData;", "<anonymous>", "(La6/f0;)Lcom/stepos/stepclaw/provider/backend/ConfigData;"}, k = 3, mv = {2, 2, 0})
@e(c = "com.stepos.stepclaw.provider.handlers.ConfigModelHandler$update$updated$1", f = "ConfigModelHandler.kt", l = {BERTags.DATE, 44}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class ConfigModelHandler$update$updated$1 extends i implements p {
    final /* synthetic */ ContentValues $values;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ConfigModelHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigModelHandler$update$updated$1(ConfigModelHandler configModelHandler, ContentValues contentValues, c cVar) {
        super(2, cVar);
        this.this$0 = configModelHandler;
        this.$values = contentValues;
    }

    @Override // h5.a
    public final c create(Object obj, c cVar) {
        return new ConfigModelHandler$update$updated$1(this.this$0, this.$values, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, c cVar) {
        return ((ConfigModelHandler$update$updated$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d9 A[RETURN] */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.handlers.ConfigModelHandler$update$updated$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
