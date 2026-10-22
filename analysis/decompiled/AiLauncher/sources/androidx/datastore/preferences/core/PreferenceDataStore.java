package androidx.datastore.preferences.core;

import J0.d;
import M0.a;
import Xa.b;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\n\u001a\u00020\u00022\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Landroidx/datastore/preferences/core/PreferenceDataStore;", "LJ0/d;", "LM0/a;", "delegate", "<init>", "(LJ0/d;)V", "Lkotlin/Function2;", "Le9/c;", "", "transform", Const.INTENT_KEY_APIKEY, "(Lp9/p;Le9/c;)Ljava/lang/Object;", "LJ0/d;", "LXa/b;", "getData", "()LXa/b;", "data", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PreferenceDataStore implements d<a> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final d<a> delegate;

    public PreferenceDataStore(d<a> delegate) {
        p.i(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // J0.d
    public Object a(p9.p<? super a, ? super InterfaceC4014c<? super a>, ? extends Object> pVar, InterfaceC4014c<? super a> interfaceC4014c) {
        return this.delegate.a(new PreferenceDataStore$updateData$2(pVar, null), interfaceC4014c);
    }

    @Override // J0.d
    public b<a> getData() {
        return this.delegate.getData();
    }
}
