package com.stepos.deepbinder.core.entity.wrapper;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0003R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/deepbinder/core/entity/wrapper/BaseWrapper;", "", "<init>", "()V", "LY8/t;", "recycle", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseWrapper {
    private String name = "";

    public final String getName() {
        return this.name;
    }

    public abstract void recycle();

    public final void setName(String str) {
        p.i(str, "<set-?>");
        this.name = str;
    }
}
