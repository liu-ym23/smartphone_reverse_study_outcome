package com.bytedance.android.livesdk.revenue.datacenter;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class d<Env, T> implements ReadWriteProperty<Env, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f157120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f157121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f157122c;

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final T getValue(Env r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        if (this.f157121b.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        return (T) this.f157120a.get(this.f157121b, this.f157122c);
    L10:
        return this.f157122c;
    L5:
        r102 = false;
        goto L6
    }

    public d(DataCenter r100, String r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "key");
        this.f157120a = r100;
        this.f157121b = r101;
        this.f157122c = r102;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Env r100, KProperty<?> r101, T r102) {
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        if (this.f157121b.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return;
    L9:
        if ((r102 instanceof vh7.e) == false) goto L11;
        this.f157120a.put(this.f157121b, ((vh7.e) r102).getFlexInstance());
        return;
    L11:
        this.f157120a.put(this.f157121b, r102);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
