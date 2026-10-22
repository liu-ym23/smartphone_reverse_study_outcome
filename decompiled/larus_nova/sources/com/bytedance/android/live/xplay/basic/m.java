package com.bytedance.android.live.xplay.basic;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class m extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f102851c;

    @Override // com.bytedance.android.live.xplay.basic.o
    public final String getName() {
        return this.f102851c;
    }

    public m(List r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "tasks");
        Intrinsics.checkNotNullParameter(RootDescription.ROOT_ELEMENT, "name");
        super(r100, r101);
        this.f102851c = RootDescription.ROOT_ELEMENT;
    }
}
