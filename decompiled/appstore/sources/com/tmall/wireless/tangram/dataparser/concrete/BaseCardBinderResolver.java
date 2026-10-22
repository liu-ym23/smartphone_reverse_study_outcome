package com.tmall.wireless.tangram.dataparser.concrete;

import androidx.annotation.NonNull;
import com.tmall.wireless.tangram.core.protocol.LayoutBinderResolver;
import com.tmall.wireless.tangram.util.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public class BaseCardBinderResolver extends LayoutBinderResolver<Card, BaseLayoutBinder> {

    @NonNull
    private CardResolver mDelegate;

    public BaseCardBinderResolver(@NonNull CardResolver r10) {
        this.mDelegate = (CardResolver) Preconditions.checkNotNull(r10, "delegate resolver should not be null");
    }

    @Override // com.tmall.wireless.tangram.core.resolver.InstanceResolver, com.tmall.wireless.tangram.core.resolver.Resolver
    public /* bridge */ /* synthetic */ Object create(int r10) {
        return create(r10);
    }

    @Override // com.tmall.wireless.tangram.core.resolver.BaseResolver, com.tmall.wireless.tangram.core.resolver.Resolver
    public /* bridge */ /* synthetic */ void register(int r10, Object r11) {
        register(r10, (BaseLayoutBinder) r11);
    }

    @Override // com.tmall.wireless.tangram.core.resolver.BaseResolver, com.tmall.wireless.tangram.core.resolver.Resolver
    public int size() {
        return this.mDelegate.size();
    }

    @Override // com.tmall.wireless.tangram.core.resolver.BaseResolver, com.tmall.wireless.tangram.core.resolver.Resolver
    public /* bridge */ /* synthetic */ int type(Object r10) {
        return type((BaseLayoutBinder) r10);
    }

    @Override // com.tmall.wireless.tangram.core.resolver.InstanceResolver, com.tmall.wireless.tangram.core.resolver.Resolver
    public BaseLayoutBinder create(int r10) {
        if (this.mDelegate.hasType(r10) == true) goto L5;
        return null;
    L5:
        return new BaseLayoutBinder();
    }

    public void register(int r10, BaseLayoutBinder r11) {
        throw new UnsupportedOperationException("BaseCardBinderResolver doesn't support register new type");
    }

    public int type(BaseLayoutBinder r10) {
        throw new UnsupportedOperationException("BaseCardBinderResolver doesn't support check type by controller");
    }
}
