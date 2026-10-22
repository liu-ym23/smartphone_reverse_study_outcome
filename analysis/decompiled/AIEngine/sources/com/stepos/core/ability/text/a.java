package com.stepos.core.ability.text;

import com.stepos.core.data.TextContent;
import v6.c;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7364a;

    public /* synthetic */ a(int i10) {
        this.f7364a = i10;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7364a) {
            case 0:
                return ((TextContent) obj).getText();
            default:
                return TaskClassifyAbility.extractText$lambda$0((c.g) obj);
        }
    }
}
