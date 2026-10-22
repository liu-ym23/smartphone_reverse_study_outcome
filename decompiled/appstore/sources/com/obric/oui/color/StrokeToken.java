package com.obric.oui.color;

import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bH\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000e\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\tJ9\u0010\u0012\u001a\u00020\u00072\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00110\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0012\u0010\u000fJ'\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R,\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0019R,\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u0012\u0004\b$\u0010\u0003\u001a\u0004\b#\u0010\u001eR\u0014\u0010%\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0019R,\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b'\u0010\u001c\u0012\u0004\b)\u0010\u0003\u001a\u0004\b(\u0010\u001eR\u0014\u0010*\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0019R,\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b,\u0010\u001c\u0012\u0004\b.\u0010\u0003\u001a\u0004\b-\u0010\u001eR\u0014\u0010/\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b/\u0010\u0019R\u0014\u00100\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0019R\u0014\u00101\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b1\u0010\u0019R\u0014\u00102\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0019R,\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b3\u0010\u001c\u0012\u0004\b5\u0010\u0003\u001a\u0004\b4\u0010\u001eR\u0014\u00106\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b6\u0010\u0019R\u0014\u00107\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b7\u0010\u0019R,\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b8\u0010\u001c\u0012\u0004\b:\u0010\u0003\u001a\u0004\b9\u0010\u001eR\u0014\u0010;\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b;\u0010\u0019R\u0014\u0010<\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b<\u0010\u0019R,\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b=\u0010\u001c\u0012\u0004\b?\u0010\u0003\u001a\u0004\b>\u0010\u001eR\u0014\u0010@\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b@\u0010\u0019R\u0014\u0010A\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u0010\u0019R,\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bB\u0010\u001c\u0012\u0004\bD\u0010\u0003\u001a\u0004\bC\u0010\u001eR\u0014\u0010E\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bE\u0010\u0019R\u0014\u0010F\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010\u0019R,\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bG\u0010\u001c\u0012\u0004\bI\u0010\u0003\u001a\u0004\bH\u0010\u001eR\u0014\u0010J\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u0019R\u0014\u0010K\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010\u0019R,\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bL\u0010\u001c\u0012\u0004\bN\u0010\u0003\u001a\u0004\bM\u0010\u001eR\u0014\u0010O\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010\u0019R\u0014\u0010P\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010\u0019R,\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bQ\u0010\u001c\u0012\u0004\bS\u0010\u0003\u001a\u0004\bR\u0010\u001eR\u0014\u0010T\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bT\u0010\u0019R\u0014\u0010U\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bU\u0010\u0019R,\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bV\u0010\u001c\u0012\u0004\bX\u0010\u0003\u001a\u0004\bW\u0010\u001e¨\u0006Y"}, d2 = {"Lcom/obric/oui/color/StrokeToken;", "", "<init>", "()V", "customTokenOwner", "", "overrideExisting", "", "register", "(Ljava/lang/Object;Z)V", "", "", "Lcom/obric/oui/color/j0;", "customTokens", "registerTokens", "(Ljava/util/Map;Z)V", "registerProvider", "Lkotlin/Function1;", "registerProviderTokens", "name", "parse", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;", "isLight", "(Ljava/lang/String;Z)Lcom/obric/oui/color/j0;", "OUI_Effect_Stroke_Regular_Light", "Lcom/obric/oui/color/j0;", "OUI_Effect_Stroke_Regular_Dark", "OUI_Effect_Stroke_Regular", "Lkotlin/jvm/functions/Function1;", "getOUI_Effect_Stroke_Regular", "()Lkotlin/jvm/functions/Function1;", "getOUI_Effect_Stroke_Regular$annotations", "OUI_Effect_Stroke_UltraThin_Light", "OUI_Effect_Stroke_UltraThin_Dark", "OUI_Effect_Stroke_UltraThin", "getOUI_Effect_Stroke_UltraThin", "getOUI_Effect_Stroke_UltraThin$annotations", "OUI_Effect_Stroke_Thin_Light", "OUI_Effect_Stroke_Thin_Dark", "OUI_Effect_Stroke_Thin", "getOUI_Effect_Stroke_Thin", "getOUI_Effect_Stroke_Thin$annotations", "OUI_Effect_Stroke_Thick_Light", "OUI_Effect_Stroke_Thick_Dark", "OUI_Effect_Stroke_Thick", "getOUI_Effect_Stroke_Thick", "getOUI_Effect_Stroke_Thick$annotations", "OUI_Effect_Stroke_Tinted_Light", "OUI_Effect_Stroke_Tinted_Dark", "OUI_Effect_Stroke_Blue_Regular_Light", "OUI_Effect_Stroke_Blue_Regular_Dark", "OUI_Effect_Stroke_Blue_Regular", "getOUI_Effect_Stroke_Blue_Regular", "getOUI_Effect_Stroke_Blue_Regular$annotations", "OUI_Effect_Stroke_Blue_Thin_Light", "OUI_Effect_Stroke_Blue_Thin_Dark", "OUI_Effect_Stroke_Blue_Thin", "getOUI_Effect_Stroke_Blue_Thin", "getOUI_Effect_Stroke_Blue_Thin$annotations", "OUI_Effect_Stroke_Red_Regular_Light", "OUI_Effect_Stroke_Red_Regular_Dark", "OUI_Effect_Stroke_Red_Regular", "getOUI_Effect_Stroke_Red_Regular", "getOUI_Effect_Stroke_Red_Regular$annotations", "OUI_Effect_Stroke_Red_Thin_Light", "OUI_Effect_Stroke_Red_Thin_Dark", "OUI_Effect_Stroke_Red_Thin", "getOUI_Effect_Stroke_Red_Thin", "getOUI_Effect_Stroke_Red_Thin$annotations", "OUI_Effect_Stroke_Green_Regular_Light", "OUI_Effect_Stroke_Green_Regular_Dark", "OUI_Effect_Stroke_Green_Regular", "getOUI_Effect_Stroke_Green_Regular", "getOUI_Effect_Stroke_Green_Regular$annotations", "OUI_Effect_Stroke_Green_Thin_Light", "OUI_Effect_Stroke_Green_Thin_Dark", "OUI_Effect_Stroke_Green_Thin", "getOUI_Effect_Stroke_Green_Thin", "getOUI_Effect_Stroke_Green_Thin$annotations", "OUI_Effect_Stroke_Yellow_Regular_Light", "OUI_Effect_Stroke_Yellow_Regular_Dark", "OUI_Effect_Stroke_Yellow_Regular", "getOUI_Effect_Stroke_Yellow_Regular", "getOUI_Effect_Stroke_Yellow_Regular$annotations", "OUI_Effect_Stroke_Yellow_Thin_Light", "OUI_Effect_Stroke_Yellow_Thin_Dark", "OUI_Effect_Stroke_Yellow_Thin", "getOUI_Effect_Stroke_Yellow_Thin", "getOUI_Effect_Stroke_Yellow_Thin$annotations", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StrokeToken {

    @NotNull
    public static final StrokeToken INSTANCE = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_Blue_Regular = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Blue_Regular_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Blue_Regular_Light = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_Blue_Thin = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Blue_Thin_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Blue_Thin_Light = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_Green_Regular = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Green_Regular_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Green_Regular_Light = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_Green_Thin = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Green_Thin_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Green_Thin_Light = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_Red_Regular = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Red_Regular_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Red_Regular_Light = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_Red_Thin = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Red_Thin_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Red_Thin_Light = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_Regular = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Regular_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Regular_Light = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_Thick = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Thick_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Thick_Light = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_Thin = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Thin_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Thin_Light = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Tinted_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Tinted_Light = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_UltraThin = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_UltraThin_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_UltraThin_Light = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_Yellow_Regular = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Yellow_Regular_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Yellow_Regular_Light = null;

    @NotNull
    private static final kotlin.jvm.functions.Function1<Boolean, j0> OUI_Effect_Stroke_Yellow_Thin = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Yellow_Thin_Dark = null;

    @JvmField
    @NotNull
    public static final j0 OUI_Effect_Stroke_Yellow_Thin_Light = null;

    static {
        INSTANCE = new StrokeToken();
        k0 r10 = a1.f12874c;
        kotlin.jvm.internal.q.f(r10, "OUI_Effect_Stroke_Regular_Light");
        OUI_Effect_Stroke_Regular_Light = l0.a(r10);
        k0 r11 = a1.f12875d;
        kotlin.jvm.internal.q.f(r11, "OUI_Effect_Stroke_Regular_Dark");
        OUI_Effect_Stroke_Regular_Dark = l0.a(r11);
        OUI_Effect_Stroke_Regular = StrokeToken$OUI_Effect_Stroke_Regular$1.INSTANCE;
        k0 r12 = a1.f12877f;
        kotlin.jvm.internal.q.f(r12, "OUI_Effect_Stroke_UltraThin_Light");
        OUI_Effect_Stroke_UltraThin_Light = l0.a(r12);
        k0 r13 = a1.f12878g;
        kotlin.jvm.internal.q.f(r13, "OUI_Effect_Stroke_UltraThin_Dark");
        OUI_Effect_Stroke_UltraThin_Dark = l0.a(r13);
        OUI_Effect_Stroke_UltraThin = StrokeToken$OUI_Effect_Stroke_UltraThin$1.INSTANCE;
        k0 r14 = a1.f12880i;
        kotlin.jvm.internal.q.f(r14, "OUI_Effect_Stroke_Thin_Light");
        OUI_Effect_Stroke_Thin_Light = l0.a(r14);
        k0 r15 = a1.f12881j;
        kotlin.jvm.internal.q.f(r15, "OUI_Effect_Stroke_Thin_Dark");
        OUI_Effect_Stroke_Thin_Dark = l0.a(r15);
        OUI_Effect_Stroke_Thin = StrokeToken$OUI_Effect_Stroke_Thin$1.INSTANCE;
        k0 r16 = a1.f12883l;
        kotlin.jvm.internal.q.f(r16, "OUI_Effect_Stroke_Thick_Light");
        OUI_Effect_Stroke_Thick_Light = l0.a(r16);
        k0 r17 = a1.f12884m;
        kotlin.jvm.internal.q.f(r17, "OUI_Effect_Stroke_Thick_Dark");
        OUI_Effect_Stroke_Thick_Dark = l0.a(r17);
        OUI_Effect_Stroke_Thick = StrokeToken$OUI_Effect_Stroke_Thick$1.INSTANCE;
        k0 r18 = a1.f12886o;
        kotlin.jvm.internal.q.f(r18, "OUI_Effect_Stroke_Tinted_Light");
        OUI_Effect_Stroke_Tinted_Light = l0.a(r18);
        k0 r19 = a1.f12887p;
        kotlin.jvm.internal.q.f(r19, "OUI_Effect_Stroke_Tinted_Dark");
        OUI_Effect_Stroke_Tinted_Dark = l0.a(r19);
        k0 r20 = a1.f12888q;
        kotlin.jvm.internal.q.f(r20, "OUI_Effect_Stroke_Blue_Regular_Light");
        OUI_Effect_Stroke_Blue_Regular_Light = l0.a(r20);
        k0 r21 = a1.f12889r;
        kotlin.jvm.internal.q.f(r21, "OUI_Effect_Stroke_Blue_Regular_Dark");
        OUI_Effect_Stroke_Blue_Regular_Dark = l0.a(r21);
        OUI_Effect_Stroke_Blue_Regular = StrokeToken$OUI_Effect_Stroke_Blue_Regular$1.INSTANCE;
        k0 r22 = a1.f12891t;
        kotlin.jvm.internal.q.f(r22, "OUI_Effect_Stroke_Blue_Thin_Light");
        OUI_Effect_Stroke_Blue_Thin_Light = l0.a(r22);
        k0 r23 = a1.f12892u;
        kotlin.jvm.internal.q.f(r23, "OUI_Effect_Stroke_Blue_Thin_Dark");
        OUI_Effect_Stroke_Blue_Thin_Dark = l0.a(r23);
        OUI_Effect_Stroke_Blue_Thin = StrokeToken$OUI_Effect_Stroke_Blue_Thin$1.INSTANCE;
        k0 r24 = a1.f12894w;
        kotlin.jvm.internal.q.f(r24, "OUI_Effect_Stroke_Red_Regular_Light");
        OUI_Effect_Stroke_Red_Regular_Light = l0.a(r24);
        k0 r25 = a1.f12895x;
        kotlin.jvm.internal.q.f(r25, "OUI_Effect_Stroke_Red_Regular_Dark");
        OUI_Effect_Stroke_Red_Regular_Dark = l0.a(r25);
        OUI_Effect_Stroke_Red_Regular = StrokeToken$OUI_Effect_Stroke_Red_Regular$1.INSTANCE;
        k0 r26 = a1.f12897z;
        kotlin.jvm.internal.q.f(r26, "OUI_Effect_Stroke_Red_Thin_Light");
        OUI_Effect_Stroke_Red_Thin_Light = l0.a(r26);
        k0 r27 = a1.A;
        kotlin.jvm.internal.q.f(r27, "OUI_Effect_Stroke_Red_Thin_Dark");
        OUI_Effect_Stroke_Red_Thin_Dark = l0.a(r27);
        OUI_Effect_Stroke_Red_Thin = StrokeToken$OUI_Effect_Stroke_Red_Thin$1.INSTANCE;
        k0 r28 = a1.C;
        kotlin.jvm.internal.q.f(r28, "OUI_Effect_Stroke_Green_Regular_Light");
        OUI_Effect_Stroke_Green_Regular_Light = l0.a(r28);
        k0 r29 = a1.D;
        kotlin.jvm.internal.q.f(r29, "OUI_Effect_Stroke_Green_Regular_Dark");
        OUI_Effect_Stroke_Green_Regular_Dark = l0.a(r29);
        OUI_Effect_Stroke_Green_Regular = StrokeToken$OUI_Effect_Stroke_Green_Regular$1.INSTANCE;
        k0 r30 = a1.F;
        kotlin.jvm.internal.q.f(r30, "OUI_Effect_Stroke_Green_Thin_Light");
        OUI_Effect_Stroke_Green_Thin_Light = l0.a(r30);
        k0 r31 = a1.G;
        kotlin.jvm.internal.q.f(r31, "OUI_Effect_Stroke_Green_Thin_Dark");
        OUI_Effect_Stroke_Green_Thin_Dark = l0.a(r31);
        OUI_Effect_Stroke_Green_Thin = StrokeToken$OUI_Effect_Stroke_Green_Thin$1.INSTANCE;
        k0 r32 = a1.I;
        kotlin.jvm.internal.q.f(r32, "OUI_Effect_Stroke_Yellow_Regular_Light");
        OUI_Effect_Stroke_Yellow_Regular_Light = l0.a(r32);
        k0 r33 = a1.f12871J;
        kotlin.jvm.internal.q.f(r33, "OUI_Effect_Stroke_Yellow_Regular_Dark");
        OUI_Effect_Stroke_Yellow_Regular_Dark = l0.a(r33);
        OUI_Effect_Stroke_Yellow_Regular = StrokeToken$OUI_Effect_Stroke_Yellow_Regular$1.INSTANCE;
        k0 r34 = a1.L;
        kotlin.jvm.internal.q.f(r34, "OUI_Effect_Stroke_Yellow_Thin_Light");
        OUI_Effect_Stroke_Yellow_Thin_Light = l0.a(r34);
        k0 r35 = a1.M;
        kotlin.jvm.internal.q.f(r35, "OUI_Effect_Stroke_Yellow_Thin_Dark");
        OUI_Effect_Stroke_Yellow_Thin_Dark = l0.a(r35);
        OUI_Effect_Stroke_Yellow_Thin = StrokeToken$OUI_Effect_Stroke_Yellow_Thin$1.INSTANCE;
    }

    private StrokeToken() {
    }

    public static /* synthetic */ k0 a(kotlin.jvm.functions.Function1 r10, Boolean r11) {
        return m15registerProviderTokens$lambda2$lambda1(r10, r11);
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_Blue_Regular() {
        return OUI_Effect_Stroke_Blue_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Regular$annotations() {
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_Blue_Thin() {
        return OUI_Effect_Stroke_Blue_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Thin$annotations() {
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_Green_Regular() {
        return OUI_Effect_Stroke_Green_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Regular$annotations() {
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_Green_Thin() {
        return OUI_Effect_Stroke_Green_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Thin$annotations() {
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_Red_Regular() {
        return OUI_Effect_Stroke_Red_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Regular$annotations() {
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_Red_Thin() {
        return OUI_Effect_Stroke_Red_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Thin$annotations() {
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_Regular() {
        return OUI_Effect_Stroke_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Regular$annotations() {
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_Thick() {
        return OUI_Effect_Stroke_Thick;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Thick$annotations() {
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_Thin() {
        return OUI_Effect_Stroke_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Thin$annotations() {
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_UltraThin() {
        return OUI_Effect_Stroke_UltraThin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_UltraThin$annotations() {
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_Yellow_Regular() {
        return OUI_Effect_Stroke_Yellow_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Regular$annotations() {
    }

    @NotNull
    public static final kotlin.jvm.functions.Function1<Boolean, j0> getOUI_Effect_Stroke_Yellow_Thin() {
        return OUI_Effect_Stroke_Yellow_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Thin$annotations() {
    }

    @JvmStatic
    @Nullable
    public static final kotlin.jvm.functions.Function1<Boolean, j0> parse(@Nullable String r10) {
        final Function1 r11 = a1.D(INSTANCE, r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass1(r11);
    }

    @JvmStatic
    public static final void register(@NotNull Object r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "customTokenOwner");
        a1.E(INSTANCE, r10, r11);
    }

    public static /* synthetic */ void register$default(Object r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        register(r10, r11);
    }

    @JvmStatic
    public static final void registerProvider(@NotNull Object r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "customTokenOwner");
        a1.F(INSTANCE, r10, r11);
    }

    public static /* synthetic */ void registerProvider$default(Object r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        registerProvider(r10, r11);
    }

    @JvmStatic
    public static final void registerProviderTokens(@NotNull Map<String, ? extends kotlin.jvm.functions.Function1<? super Boolean, j0>> r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "customTokens");
        StrokeToken r12 = INSTANCE;
        LinkedHashMap r13 = new LinkedHashMap(kotlin.collections.j0.e(r10.size()));
        Iterator<T> r14 = r10.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Map.Entry r15 = (Map.Entry) r14.next();
        Object r16 = r15.getKey();
        final kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r15.getValue();
        r13.put(r16, new m0(r17));
        goto L4
    L6:
        a1.G(r12, r13, r11);
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        registerProviderTokens(r10, r11);
    }

    /* JADX INFO: renamed from: registerProviderTokens$lambda-2$lambda-1, reason: not valid java name */
    private static final k0 m15registerProviderTokens$lambda2$lambda1(kotlin.jvm.functions.Function1 r10, Boolean r11) {
        kotlin.jvm.internal.q.g(r10, "$provider");
        kotlin.jvm.internal.q.f(r11, "isLight");
        return ((j0) r10.invoke(r11)).d();
    }

    @JvmStatic
    public static final void registerTokens(@NotNull Map<String, j0> r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "customTokens");
        StrokeToken r12 = INSTANCE;
        LinkedHashMap r13 = new LinkedHashMap(kotlin.collections.j0.e(r10.size()));
        Iterator<T> r14 = r10.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13.put(r15.getKey(), ((j0) r15.getValue()).d());
        goto L4
    L6:
        a1.H(r12, r13, r11);
    }

    public static /* synthetic */ void registerTokens$default(Map r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        registerTokens(r10, r11);
    }

    @JvmStatic
    @Nullable
    public static final j0 parse(@Nullable String r10, boolean r11) {
        k0 r12 = a1.C(INSTANCE, r10, r11);
        if (r12 != null) goto L6;
        return null;
    L6:
        return l0.a(r12);
    }
}
