package com.android.ttcjpaysdk.base.h5.xelement;

import com.android.ttcjpaysdk.base.h5.xelement.keyboard.KeyBoardFactory;
import ge4.a;
import ie4.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/xelement/XElementHelper;", "Lge4/a;", "Lie4/c;", "getKeyBoardFactory", "<init>", "()V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class XElementHelper implements a {
    public XElementHelper() {
    }

    @Override // ge4.a
    public c getKeyBoardFactory() {
        return new KeyBoardFactory();
    }
}
