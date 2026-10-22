package f2;

import android.content.Context;
import n2.InterfaceC4936a;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f32538a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4936a f32539b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC4936a f32540c;

    public g(Context context, InterfaceC4936a interfaceC4936a, InterfaceC4936a interfaceC4936a2) {
        this.f32538a = context;
        this.f32539b = interfaceC4936a;
        this.f32540c = interfaceC4936a2;
    }

    public AbstractC4051f a(String str) {
        return AbstractC4051f.a(this.f32538a, this.f32539b, this.f32540c, str);
    }
}
