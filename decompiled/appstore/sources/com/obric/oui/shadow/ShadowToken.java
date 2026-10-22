package com.obric.oui.shadow;

import androidx.annotation.Keep;
import com.obric.oui.material.e;
import com.obric.oui.material.p;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR-\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/shadow/ShadowToken;", "", "<init>", "()V", "", "name", "", "Lcom/obric/oui/shadow/a;", "parse", "(Ljava/lang/String;)[Lcom/obric/oui/shadow/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "tokens", "Oui_Shadow_Thin", "[Lcom/obric/oui/shadow/a;", "Oui_Shadow_Regular", "Oui_Shadow_Thick", "Oui_Shadow_UltraThick", "Oui_Shadow_Text_Regular", "Shadow_1", "Shadow_2", "Shadow_3", "Shadow_Thick", "Shadow_Text", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShadowToken {

    @NotNull
    public static final ShadowToken INSTANCE = null;

    @JvmField
    @NotNull
    public static final a[] Oui_Shadow_Regular = null;

    @JvmField
    @NotNull
    public static final a[] Oui_Shadow_Text_Regular = null;

    @JvmField
    @NotNull
    public static final a[] Oui_Shadow_Thick = null;

    @JvmField
    @NotNull
    public static final a[] Oui_Shadow_Thin = null;

    @JvmField
    @NotNull
    public static final a[] Oui_Shadow_UltraThick = null;

    @JvmField
    @NotNull
    public static final a[] Shadow_1 = null;

    @JvmField
    @NotNull
    public static final a[] Shadow_2 = null;

    @JvmField
    @NotNull
    public static final a[] Shadow_3 = null;

    @JvmField
    @NotNull
    public static final a[] Shadow_Text = null;

    @JvmField
    @NotNull
    public static final a[] Shadow_Thick = null;

    @NotNull
    private static final Lazy tokens$delegate = null;

    static {
        INSTANCE = new ShadowToken();
        tokens$delegate = kotlin.b.b(ShadowToken$tokens$2.INSTANCE);
        b[] r10 = d.f16774a;
        q.f(r10, "Oui_Shadow_Thin");
        Oui_Shadow_Thin = e.f(r10);
        b[] r11 = d.f16777d;
        q.f(r11, "Oui_Shadow_Regular");
        Oui_Shadow_Regular = e.f(r11);
        b[] r12 = d.f16780g;
        q.f(r12, "Oui_Shadow_Thick");
        Oui_Shadow_Thick = e.f(r12);
        b[] r13 = d.f16781h;
        q.f(r13, "Oui_Shadow_UltraThick");
        Oui_Shadow_UltraThick = e.f(r13);
        b[] r14 = d.f16782i;
        q.f(r14, "Oui_Shadow_Text_Regular");
        Oui_Shadow_Text_Regular = e.f(r14);
        b[] r15 = d.f16783j;
        q.f(r15, "Shadow_1");
        Shadow_1 = e.f(r15);
        b[] r16 = d.f16784k;
        q.f(r16, "Shadow_2");
        Shadow_2 = e.f(r16);
        b[] r17 = d.f16785l;
        q.f(r17, "Shadow_3");
        Shadow_3 = e.f(r17);
        b[] r18 = d.f16786m;
        q.f(r18, "Shadow_Thick");
        Shadow_Thick = e.f(r18);
        b[] r19 = d.f16787n;
        q.f(r19, "Shadow_Text");
        Shadow_Text = e.f(r19);
    }

    private ShadowToken() {
    }

    private final ConcurrentHashMap<String, a[]> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    @JvmStatic
    @Nullable
    public static final a[] parse(@Nullable String r10) {
        return (a[]) p.f15302a.a(r10, INSTANCE.getTokens());
    }
}
