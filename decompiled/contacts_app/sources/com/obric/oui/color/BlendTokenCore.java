package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.TokenCoreParser;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class BlendTokenCore {
    public static final Function1<Boolean, BlendConfig[]> Blend_Base_Regular = null;
    public static final BlendConfig[] Blend_Base_Regular_Dark = null;
    public static final BlendConfig[] Blend_Base_Regular_Light = null;
    public static final Function1<Boolean, BlendConfig[]> Blend_Base_Thick = null;
    public static final BlendConfig[] Blend_Base_Thick_Dark = null;
    public static final BlendConfig[] Blend_Base_Thick_Light = null;
    public static final Function1<Boolean, BlendConfig[]> Blend_Blue_4 = null;
    public static final BlendConfig[] Blend_Blue_4_Dark = null;
    public static final BlendConfig[] Blend_Blue_4_Light = null;
    public static final Function1<Boolean, BlendConfig[]> Blend_Blue_6 = null;
    public static final BlendConfig[] Blend_Blue_6_Dark = null;
    public static final BlendConfig[] Blend_Blue_6_Light = null;
    public static final Function1<Boolean, BlendConfig[]> Blend_Fill_Element_2 = null;
    public static final BlendConfig[] Blend_Fill_Element_2_Dark = null;
    public static final BlendConfig[] Blend_Fill_Element_2_Light = null;
    public static final Function1<Boolean, BlendConfig[]> Blend_Fluid_Thin = null;
    public static final BlendConfig[] Blend_Fluid_Thin_Dark = null;
    public static final BlendConfig[] Blend_Fluid_Thin_Light = null;
    public static final Function1<Boolean, BlendConfig[]> Blend_Green_4 = null;
    public static final BlendConfig[] Blend_Green_4_Dark = null;
    public static final BlendConfig[] Blend_Green_4_Light = null;
    public static final Function1<Boolean, BlendConfig[]> Blend_Green_6 = null;
    public static final BlendConfig[] Blend_Green_6_Dark = null;
    public static final BlendConfig[] Blend_Green_6_Light = null;
    public static final Function1<Boolean, BlendConfig[]> Blend_Red_4 = null;
    public static final BlendConfig[] Blend_Red_4_Dark = null;
    public static final BlendConfig[] Blend_Red_4_Light = null;
    public static final Function1<Boolean, BlendConfig[]> Blend_Red_6 = null;
    public static final BlendConfig[] Blend_Red_6_Dark = null;
    public static final BlendConfig[] Blend_Red_6_Light = null;
    public static final Function1<Boolean, BlendConfig[]> Blend_Yellow_4 = null;
    public static final BlendConfig[] Blend_Yellow_4_Dark = null;
    public static final BlendConfig[] Blend_Yellow_4_Light = null;
    public static final Function1<Boolean, BlendConfig[]> Blend_Yellow_6 = null;
    public static final BlendConfig[] Blend_Yellow_6_Dark = null;
    public static final BlendConfig[] Blend_Yellow_6_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Blue_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Blue_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Blue_Regular_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Blue_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Blue_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Blue_Thin_Light = null;
    public static final BlendConfig[] OUI_Color_Blend_Fill_Tinted_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Fill_Tinted_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Fluid_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Regular_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Fluid_Thick = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Thick_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Thick_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Fluid_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Thin_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Fluid_UltraThin = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_UltraThin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_UltraThin_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Frost_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Regular_Light = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Thick_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Thick_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Frost_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Thin_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Frost_UltraThin = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_UltraThin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_UltraThin_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Green_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Green_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Green_Regular_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Green_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Green_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Green_Thin_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Red_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Red_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Red_Regular_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Red_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Red_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Red_Thin_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Text_Primary = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Primary_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Primary_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Text_Secondary = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Secondary_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Secondary_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Text_Tertiary = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Tertiary_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Tertiary_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Yellow_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Yellow_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Yellow_Regular_Light = null;
    public static final Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Yellow_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Yellow_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Yellow_Thin_Light = null;
    public static final BlendConfig[] OUI_Color_Fills_Thick_Dark = null;
    public static final BlendConfig[] OUI_Color_Fills_Thick_Light = null;
    public static final BlendConfig OUI_Color_State_Active_Dark = null;
    public static final BlendConfig OUI_Color_State_Active_Light = null;
    public static final BlendConfig OUI_Color_State_Press_Dark = null;
    public static final BlendConfig OUI_Color_State_Press_Light = null;
    private static volatile ConcurrentHashMap<String, Function1<Boolean, BlendConfig[]>> providers;
    private static volatile ConcurrentHashMap<String, BlendConfig[]> tokens;

    static {
        Blend_Base_Thick_Light = new BlendConfig[]{new BlendConfig(-1726013665, BlendMode.COLOR_DODGE), new BlendConfig(-604571914, BlendMode.SRC_OVER)};
        Blend_Base_Thick_Dark = new BlendConfig[]{new BlendConfig(-3355444, BlendMode.COLOR_BURN), new BlendConfig(-618388444, BlendMode.SRC_OVER)};
        Blend_Base_Thick = new BlendTokenCore$$ExternalSyntheticLambda0();
        Blend_Base_Regular_Light = new BlendConfig[]{new BlendConfig(-14737633, BlendMode.COLOR_DODGE), new BlendConfig(-855638017, BlendMode.SRC_OVER)};
        Blend_Base_Regular_Dark = new BlendConfig[]{new BlendConfig(-3355444, BlendMode.COLOR_BURN), new BlendConfig(-666746302, BlendMode.SRC_OVER)};
        Blend_Base_Regular = new BlendTokenCore$$ExternalSyntheticLambda2();
        OUI_Color_Blend_Frost_Regular_Light = new BlendConfig[]{new BlendConfig(-14737633, BlendMode.COLOR_DODGE), new BlendConfig(-855638017, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Regular_Dark = new BlendConfig[]{new BlendConfig(-3355444, BlendMode.COLOR_BURN), new BlendConfig(-868072894, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Regular = new BlendTokenCore$$ExternalSyntheticLambda14();
        OUI_Color_Blend_Fluid_Regular_Light = new BlendConfig[]{new BlendConfig(-1716342094, BlendMode.LUMINOSITY), new BlendConfig(-13421773, BlendMode.COLOR_DODGE), new BlendConfig(1626074091, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular_Dark = new BlendConfig[]{new BlendConfig(-1718052712, BlendMode.LUMINOSITY), new BlendConfig(-860572492, BlendMode.COLOR_BURN), new BlendConfig(335544320, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular = new BlendTokenCore$$ExternalSyntheticLambda15();
        OUI_Color_Blend_Frost_UltraThin_Light = new BlendConfig[]{new BlendConfig(-14737633, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Frost_UltraThin_Dark = new BlendConfig[]{new BlendConfig(-14737633, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Frost_UltraThin = new BlendTokenCore$$ExternalSyntheticLambda16();
        OUI_Color_Blend_Fluid_UltraThin_Light = new BlendConfig[]{new BlendConfig(-15461356, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Fluid_UltraThin_Dark = new BlendConfig[]{new BlendConfig(-15461356, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Fluid_UltraThin = new BlendTokenCore$$ExternalSyntheticLambda17();
        OUI_Color_Blend_Frost_Thin_Light = new BlendConfig[]{new BlendConfig(1722329256, BlendMode.LUMINOSITY), new BlendConfig(-13421773, BlendMode.COLOR_DODGE), new BlendConfig(-1711276033, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Thin_Dark = new BlendConfig[]{new BlendConfig(-2137417319, BlendMode.LUMINOSITY)};
        OUI_Color_Blend_Frost_Thin = new BlendTokenCore$$ExternalSyntheticLambda18();
        OUI_Color_Blend_Fluid_Thin_Light = new BlendConfig[]{new BlendConfig(869059788, BlendMode.LUMINOSITY), new BlendConfig(-1724697805, BlendMode.COLOR_DODGE), new BlendConfig(352321535, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thin_Dark = new BlendConfig[]{new BlendConfig(1721342361, BlendMode.LUMINOSITY)};
        OUI_Color_Blend_Fluid_Thin = new BlendTokenCore$$ExternalSyntheticLambda19();
        OUI_Color_Blend_Frost_Thick_Light = new BlendConfig[]{new BlendConfig(-1726013665, BlendMode.COLOR_DODGE), new BlendConfig(-604506121, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Thick_Dark = new BlendConfig[]{new BlendConfig(-3355444, BlendMode.COLOR_BURN), new BlendConfig(-618059479, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Light = new BlendConfig[]{new BlendConfig(-1726013665, BlendMode.COLOR_DODGE), new BlendConfig(-604506121, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Dark = new BlendConfig[]{new BlendConfig(-858993460, BlendMode.COLOR_BURN), new BlendConfig(-869717719, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick = new BlendTokenCore$$ExternalSyntheticLambda20();
        OUI_Color_Fills_Thick_Light = new BlendConfig[]{new BlendConfig(251658240, BlendMode.SRC_OVER)};
        OUI_Color_Fills_Thick_Dark = new BlendConfig[]{new BlendConfig(620756991, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Text_Primary_Light = new BlendConfig[]{new BlendConfig(-13421773, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Primary_Dark = new BlendConfig[]{new BlendConfig(-2500135, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Primary = new BlendTokenCore$$ExternalSyntheticLambda21();
        OUI_Color_Blend_Text_Secondary_Light = new BlendConfig[]{new BlendConfig(-6710887, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Secondary_Dark = new BlendConfig[]{new BlendConfig(-9211021, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Secondary = new BlendTokenCore$$ExternalSyntheticLambda11();
        OUI_Color_Blend_Text_Tertiary_Light = new BlendConfig[]{new BlendConfig(-4342339, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Tertiary_Dark = new BlendConfig[]{new BlendConfig(-10921639, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Tertiary = new BlendTokenCore$$ExternalSyntheticLambda22();
        OUI_Color_Blend_Fill_Tinted_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-1, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Fill_Tinted_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-16777216, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-10049793, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-10049793, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin = new BlendTokenCore$$ExternalSyntheticLambda23();
        OUI_Color_Blend_Blue_Regular_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-14253569, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Regular_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-14253569, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Regular = new BlendTokenCore$$ExternalSyntheticLambda24();
        OUI_Color_Blend_Red_Thin_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-30841, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Thin_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-30841, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Thin = new BlendTokenCore$$ExternalSyntheticLambda25();
        OUI_Color_Blend_Red_Regular_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-45747, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Regular_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-45747, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Regular = new BlendTokenCore$$ExternalSyntheticLambda26();
        OUI_Color_Blend_Green_Thin_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-8917601, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Thin_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-8917601, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Thin = new BlendTokenCore$$ExternalSyntheticLambda27();
        OUI_Color_Blend_Green_Regular_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15415472, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Regular_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15415472, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Regular = new BlendTokenCore$$ExternalSyntheticLambda28();
        OUI_Color_Blend_Yellow_Thin_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-11671, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Thin_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-11671, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Thin = new BlendTokenCore$$ExternalSyntheticLambda29();
        OUI_Color_Blend_Yellow_Regular_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15078, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Regular_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15078, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Regular = new BlendTokenCore$$ExternalSyntheticLambda1();
        OUI_Color_State_Press_Light = new BlendConfig(-13421773, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Press_Dark = new BlendConfig(-1724697805, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Active_Light = new BlendConfig(-6710887, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Active_Dark = new BlendConfig(-6710887, BlendMode.PLUS_LIGHTER);
        Blend_Blue_6_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15042049, BlendMode.PLUS_DARKER)};
        Blend_Blue_6_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15042049, BlendMode.PLUS_DARKER)};
        Blend_Blue_6 = new BlendTokenCore$$ExternalSyntheticLambda3();
        Blend_Blue_4_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-10049793, BlendMode.PLUS_DARKER)};
        Blend_Blue_4_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-10049793, BlendMode.PLUS_DARKER)};
        Blend_Blue_4 = new BlendTokenCore$$ExternalSyntheticLambda4();
        Blend_Yellow_6_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-873984, BlendMode.PLUS_DARKER)};
        Blend_Yellow_6_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-873984, BlendMode.PLUS_DARKER)};
        Blend_Yellow_6 = new BlendTokenCore$$ExternalSyntheticLambda5();
        Blend_Yellow_4_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-11671, BlendMode.PLUS_DARKER)};
        Blend_Yellow_4_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-11671, BlendMode.PLUS_DARKER)};
        Blend_Yellow_4 = new BlendTokenCore$$ExternalSyntheticLambda6();
        Blend_Green_6_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-16722873, BlendMode.PLUS_DARKER)};
        Blend_Green_6_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-16722873, BlendMode.PLUS_DARKER)};
        Blend_Green_6 = new BlendTokenCore$$ExternalSyntheticLambda7();
        Blend_Green_4_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-8917601, BlendMode.PLUS_DARKER)};
        Blend_Green_4_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-8917601, BlendMode.PLUS_DARKER)};
        Blend_Green_4 = new BlendTokenCore$$ExternalSyntheticLambda8();
        Blend_Red_6_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-53971, BlendMode.PLUS_DARKER)};
        Blend_Red_6_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-53971, BlendMode.PLUS_DARKER)};
        Blend_Red_6 = new BlendTokenCore$$ExternalSyntheticLambda9();
        Blend_Red_4_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-30841, BlendMode.PLUS_DARKER)};
        Blend_Red_4_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-30841, BlendMode.PLUS_DARKER)};
        Blend_Red_4 = new BlendTokenCore$$ExternalSyntheticLambda10();
        Blend_Fill_Element_2_Light = new BlendConfig[]{new BlendConfig(167772160, BlendMode.SRC_OVER)};
        Blend_Fill_Element_2_Dark = new BlendConfig[]{new BlendConfig(536870911, BlendMode.SRC_OVER)};
        Blend_Fill_Element_2 = new BlendTokenCore$$ExternalSyntheticLambda12();
        Blend_Fluid_Thin_Light = new BlendConfig[]{new BlendConfig(-13421773, BlendMode.COLOR_DODGE), new BlendConfig(1088018905, BlendMode.SRC_OVER)};
        Blend_Fluid_Thin_Dark = new BlendConfig[]{new BlendConfig(-13421773, BlendMode.COLOR_DODGE), new BlendConfig(1088018905, BlendMode.SRC_OVER)};
        Blend_Fluid_Thin = new BlendTokenCore$$ExternalSyntheticLambda13();
    }

    static /* synthetic */ BlendConfig[] lambda$static$0(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Base_Thick_Light;
    L6:
        return Blend_Base_Thick_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$1(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Base_Regular_Light;
    L6:
        return Blend_Base_Regular_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$2(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_Regular_Light;
    L6:
        return OUI_Color_Blend_Frost_Regular_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$3(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Regular_Light;
    L6:
        return OUI_Color_Blend_Fluid_Regular_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$4(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_UltraThin_Light;
    L6:
        return OUI_Color_Blend_Frost_UltraThin_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$5(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_UltraThin_Light;
    L6:
        return OUI_Color_Blend_Fluid_UltraThin_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$6(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_Thin_Light;
    L6:
        return OUI_Color_Blend_Frost_Thin_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$7(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Thin_Light;
    L6:
        return OUI_Color_Blend_Fluid_Thin_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$8(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Thick_Light;
    L6:
        return OUI_Color_Blend_Fluid_Thick_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$9(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Primary_Light;
    L6:
        return OUI_Color_Blend_Text_Primary_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$10(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Secondary_Light;
    L6:
        return OUI_Color_Blend_Text_Secondary_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$11(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Tertiary_Light;
    L6:
        return OUI_Color_Blend_Text_Tertiary_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$12(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Blue_Thin_Light;
    L6:
        return OUI_Color_Blend_Blue_Thin_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$13(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Blue_Regular_Light;
    L6:
        return OUI_Color_Blend_Blue_Regular_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$14(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Red_Thin_Light;
    L6:
        return OUI_Color_Blend_Red_Thin_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$15(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Red_Regular_Light;
    L6:
        return OUI_Color_Blend_Red_Regular_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$16(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Green_Thin_Light;
    L6:
        return OUI_Color_Blend_Green_Thin_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$17(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Green_Regular_Light;
    L6:
        return OUI_Color_Blend_Green_Regular_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$18(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Yellow_Thin_Light;
    L6:
        return OUI_Color_Blend_Yellow_Thin_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$19(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Yellow_Regular_Light;
    L6:
        return OUI_Color_Blend_Yellow_Regular_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$20(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Blue_6_Light;
    L6:
        return Blend_Blue_6_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$21(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Blue_4_Light;
    L6:
        return Blend_Blue_4_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$22(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Yellow_6_Light;
    L6:
        return Blend_Yellow_6_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$23(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Yellow_4_Light;
    L6:
        return Blend_Yellow_4_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$24(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Green_6_Light;
    L6:
        return Blend_Green_6_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$25(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Green_4_Light;
    L6:
        return Blend_Green_4_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$26(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Red_6_Light;
    L6:
        return Blend_Red_6_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$27(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Red_4_Light;
    L6:
        return Blend_Red_4_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$28(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Fill_Element_2_Light;
    L6:
        return Blend_Fill_Element_2_Dark;
    }

    static /* synthetic */ BlendConfig[] lambda$static$29(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Fluid_Thin_Light;
    L6:
        return Blend_Fluid_Thin_Dark;
    }

    private BlendTokenCore() {
    }

    public static void register(Object r1, Object r2, boolean r3) {
        TokenCoreParser.register(getTokens(r1), r2, BlendConfig[].class, r3);
    }

    public static void registerTokens(Object r0, Map<String, BlendConfig[]> r1, boolean r2) {
        TokenCoreParser.registerTokens(getTokens(r0), r1, r2);
    }

    public static void registerProvider(Object r1, Object r2, boolean r3) {
        TokenCoreParser.register(getProviders(r1), r2, Function1.class, r3);
    }

    public static void registerProviderTokens(Object r0, Map<String, ? extends Function1<Boolean, BlendConfig[]>> r1, boolean r2) {
        TokenCoreParser.registerTokens(getProviders(r0), r1, r2);
    }

    public static Function1<Boolean, BlendConfig[]> parseProvider(Object r0, String r1) {
        return (Function1) TokenCoreParser.parse(r1, getProviders(r0));
    }

    public static BlendConfig[] parse(Object r1, String r2, boolean r3) {
        BlendConfig[] r0 = (BlendConfig[]) TokenCoreParser.parse(r2, getTokens(r1));
        if (r0 != null) goto L10;
        StringBuilder r4 = new StringBuilder().append(r2);
        if (r3 == false) goto L7;
        String r5 = "_light";
    L9:
        return (BlendConfig[]) TokenCoreParser.parse(r4.append(r5).toString(), getTokens(r1));
    L7:
        r5 = "_dark";
        goto L9
    L10:
        return r0;
    }

    private static ConcurrentHashMap<String, BlendConfig[]> getTokens(Object r2) {
        ConcurrentHashMap<String, BlendConfig[]> r0 = tokens;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(BlendTokenCore.class);
        r0 = tokens;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        ConcurrentHashMap<String, BlendConfig[]> r3 = TokenCoreParser.createTokenMap(r2, BlendConfig[].class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
        r0 = r3;
    L9:
        monitor-exit(BlendTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, Function1<Boolean, BlendConfig[]>> getProviders(Object r2) {
        ConcurrentHashMap<String, Function1<Boolean, BlendConfig[]>> r0 = providers;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(BlendTokenCore.class);
        r0 = providers;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        ConcurrentHashMap<String, Function1<Boolean, BlendConfig[]>> r3 = TokenCoreParser.createTokenMap(r2, Function1.class);     // Catch: Throwable -> L11
        providers = r3;     // Catch: Throwable -> L11
        r0 = r3;
    L9:
        monitor-exit(BlendTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
