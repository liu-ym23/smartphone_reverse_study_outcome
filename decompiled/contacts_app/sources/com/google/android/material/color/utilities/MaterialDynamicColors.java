package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialDynamicColors {
    private static final double CONTAINER_ACCENT_TONE_DELTA = 15.0d;
    public static final DynamicColor background = null;
    public static final DynamicColor controlActivated = null;
    public static final DynamicColor controlHighlight = null;
    public static final DynamicColor controlNormal = null;
    public static final DynamicColor error = null;
    public static final DynamicColor errorContainer = null;
    public static final DynamicColor onBackground = null;
    public static final DynamicColor onError = null;
    public static final DynamicColor onErrorContainer = null;
    public static final DynamicColor onPrimary = null;
    public static final DynamicColor onPrimaryContainer = null;
    public static final DynamicColor onPrimaryFixed = null;
    public static final DynamicColor onPrimaryFixedVariant = null;
    public static final DynamicColor onSecondary = null;
    public static final DynamicColor onSecondaryContainer = null;
    public static final DynamicColor onSecondaryFixed = null;
    public static final DynamicColor onSecondaryFixedVariant = null;
    public static final DynamicColor onSurface = null;
    public static final DynamicColor onSurfaceInverse = null;
    public static final DynamicColor onSurfaceVariant = null;
    public static final DynamicColor onTertiary = null;
    public static final DynamicColor onTertiaryContainer = null;
    public static final DynamicColor onTertiaryFixed = null;
    public static final DynamicColor onTertiaryFixedVariant = null;
    public static final DynamicColor outline = null;
    public static final DynamicColor outlineVariant = null;
    public static final DynamicColor primary = null;
    public static final DynamicColor primaryContainer = null;
    public static final DynamicColor primaryFixed = null;
    public static final DynamicColor primaryFixedDarker = null;
    public static final DynamicColor primaryInverse = null;
    public static final DynamicColor secondary = null;
    public static final DynamicColor secondaryContainer = null;
    public static final DynamicColor secondaryFixed = null;
    public static final DynamicColor secondaryFixedDarker = null;
    public static final DynamicColor surface = null;
    public static final DynamicColor surfaceAdd1 = null;
    public static final DynamicColor surfaceAdd2 = null;
    public static final DynamicColor surfaceBright = null;
    public static final DynamicColor surfaceContainer = null;
    public static final DynamicColor surfaceDim = null;
    public static final DynamicColor surfaceInverse = null;
    public static final DynamicColor surfaceSub1 = null;
    public static final DynamicColor surfaceSub2 = null;
    public static final DynamicColor surfaceVariant = null;
    public static final DynamicColor tertiary = null;
    public static final DynamicColor tertiaryContainer = null;
    public static final DynamicColor tertiaryFixed = null;
    public static final DynamicColor tertiaryFixedDarker = null;
    public static final DynamicColor textHintInverse = null;
    public static final DynamicColor textPrimaryInverse = null;
    public static final DynamicColor textPrimaryInverseDisableOnly = null;
    public static final DynamicColor textSecondaryAndTertiaryInverse = null;
    public static final DynamicColor textSecondaryAndTertiaryInverseDisabled = null;

    private MaterialDynamicColors() {
    }

    public static DynamicColor highestSurface(DynamicScheme r0) {
        if (r0.isDark == false) goto L6;
        return surfaceBright;
    L6:
        return surfaceDim;
    }

    static {
        background = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda75(), new MaterialDynamicColors$$ExternalSyntheticLambda113());
        onBackground = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda125(), new MaterialDynamicColors$$ExternalSyntheticLambda137(), new MaterialDynamicColors$$ExternalSyntheticLambda149());
        surface = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda9(), new MaterialDynamicColors$$ExternalSyntheticLambda21());
        surfaceInverse = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda34(), new MaterialDynamicColors$$ExternalSyntheticLambda46());
        surfaceBright = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda58(), new MaterialDynamicColors$$ExternalSyntheticLambda44());
        surfaceDim = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda69(), new MaterialDynamicColors$$ExternalSyntheticLambda81());
        surfaceSub2 = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda93(), new MaterialDynamicColors$$ExternalSyntheticLambda105());
        surfaceSub1 = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda107(), new MaterialDynamicColors$$ExternalSyntheticLambda109());
        surfaceContainer = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda110(), new MaterialDynamicColors$$ExternalSyntheticLambda111());
        surfaceAdd1 = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda112(), new MaterialDynamicColors$$ExternalSyntheticLambda114());
        surfaceAdd2 = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda115(), new MaterialDynamicColors$$ExternalSyntheticLambda116());
        onSurface = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda117(), new MaterialDynamicColors$$ExternalSyntheticLambda118(), new MaterialDynamicColors$$ExternalSyntheticLambda120());
        onSurfaceInverse = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda121(), new MaterialDynamicColors$$ExternalSyntheticLambda122(), new MaterialDynamicColors$$ExternalSyntheticLambda123());
        surfaceVariant = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda124(), new MaterialDynamicColors$$ExternalSyntheticLambda126());
        onSurfaceVariant = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda127(), new MaterialDynamicColors$$ExternalSyntheticLambda128(), new MaterialDynamicColors$$ExternalSyntheticLambda129());
        outline = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda131(), new MaterialDynamicColors$$ExternalSyntheticLambda132(), new MaterialDynamicColors$$ExternalSyntheticLambda133());
        outlineVariant = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda134(), new MaterialDynamicColors$$ExternalSyntheticLambda135(), new MaterialDynamicColors$$ExternalSyntheticLambda136());
        primaryContainer = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda138(), new MaterialDynamicColors$$ExternalSyntheticLambda139(), new MaterialDynamicColors$$ExternalSyntheticLambda140());
        onPrimaryContainer = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda142(), new MaterialDynamicColors$$ExternalSyntheticLambda143(), new MaterialDynamicColors$$ExternalSyntheticLambda144(), null);
        primary = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda145(), new MaterialDynamicColors$$ExternalSyntheticLambda146(), new MaterialDynamicColors$$ExternalSyntheticLambda147(), new MaterialDynamicColors$$ExternalSyntheticLambda148());
        primaryInverse = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda150(), new MaterialDynamicColors$$ExternalSyntheticLambda151(), new MaterialDynamicColors$$ExternalSyntheticLambda1());
        onPrimary = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda2(), new MaterialDynamicColors$$ExternalSyntheticLambda3(), new MaterialDynamicColors$$ExternalSyntheticLambda4());
        secondaryContainer = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda5(), new MaterialDynamicColors$$ExternalSyntheticLambda6(), new MaterialDynamicColors$$ExternalSyntheticLambda7());
        onSecondaryContainer = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda8(), new MaterialDynamicColors$$ExternalSyntheticLambda10(), new MaterialDynamicColors$$ExternalSyntheticLambda12());
        secondary = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda13(), new MaterialDynamicColors$$ExternalSyntheticLambda14(), new MaterialDynamicColors$$ExternalSyntheticLambda15(), new MaterialDynamicColors$$ExternalSyntheticLambda16());
        onSecondary = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda17(), new MaterialDynamicColors$$ExternalSyntheticLambda18(), new MaterialDynamicColors$$ExternalSyntheticLambda19());
        tertiaryContainer = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda20(), new MaterialDynamicColors$$ExternalSyntheticLambda23(), new MaterialDynamicColors$$ExternalSyntheticLambda24());
        onTertiaryContainer = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda25(), new MaterialDynamicColors$$ExternalSyntheticLambda26(), new MaterialDynamicColors$$ExternalSyntheticLambda27());
        tertiary = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda28(), new MaterialDynamicColors$$ExternalSyntheticLambda29(), new MaterialDynamicColors$$ExternalSyntheticLambda30(), new MaterialDynamicColors$$ExternalSyntheticLambda31());
        onTertiary = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda32(), new MaterialDynamicColors$$ExternalSyntheticLambda35(), new MaterialDynamicColors$$ExternalSyntheticLambda36());
        errorContainer = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda37(), new MaterialDynamicColors$$ExternalSyntheticLambda38(), new MaterialDynamicColors$$ExternalSyntheticLambda39());
        onErrorContainer = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda40(), new MaterialDynamicColors$$ExternalSyntheticLambda41(), new MaterialDynamicColors$$ExternalSyntheticLambda42());
        error = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda43(), new MaterialDynamicColors$$ExternalSyntheticLambda45(), new MaterialDynamicColors$$ExternalSyntheticLambda47(), new MaterialDynamicColors$$ExternalSyntheticLambda48());
        onError = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda49(), new MaterialDynamicColors$$ExternalSyntheticLambda50(), new MaterialDynamicColors$$ExternalSyntheticLambda51());
        primaryFixed = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda52(), new MaterialDynamicColors$$ExternalSyntheticLambda53(), new MaterialDynamicColors$$ExternalSyntheticLambda54());
        primaryFixedDarker = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda56(), new MaterialDynamicColors$$ExternalSyntheticLambda57(), new MaterialDynamicColors$$ExternalSyntheticLambda86());
        onPrimaryFixed = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda97(), new MaterialDynamicColors$$ExternalSyntheticLambda108(), new MaterialDynamicColors$$ExternalSyntheticLambda119());
        onPrimaryFixedVariant = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda130(), new MaterialDynamicColors$$ExternalSyntheticLambda141(), new MaterialDynamicColors$$ExternalSyntheticLambda152());
        secondaryFixed = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda11(), new MaterialDynamicColors$$ExternalSyntheticLambda22(), new MaterialDynamicColors$$ExternalSyntheticLambda33());
        secondaryFixedDarker = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda55(), new MaterialDynamicColors$$ExternalSyntheticLambda59(), new MaterialDynamicColors$$ExternalSyntheticLambda60());
        onSecondaryFixed = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda61(), new MaterialDynamicColors$$ExternalSyntheticLambda62(), new MaterialDynamicColors$$ExternalSyntheticLambda63());
        onSecondaryFixedVariant = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda65(), new MaterialDynamicColors$$ExternalSyntheticLambda66(), new MaterialDynamicColors$$ExternalSyntheticLambda67());
        tertiaryFixed = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda68(), new MaterialDynamicColors$$ExternalSyntheticLambda70(), new MaterialDynamicColors$$ExternalSyntheticLambda71());
        tertiaryFixedDarker = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda72(), new MaterialDynamicColors$$ExternalSyntheticLambda73(), new MaterialDynamicColors$$ExternalSyntheticLambda74());
        onTertiaryFixed = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda76(), new MaterialDynamicColors$$ExternalSyntheticLambda77(), new MaterialDynamicColors$$ExternalSyntheticLambda78());
        onTertiaryFixedVariant = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda79(), new MaterialDynamicColors$$ExternalSyntheticLambda80(), new MaterialDynamicColors$$ExternalSyntheticLambda82());
        controlActivated = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda83(), new MaterialDynamicColors$$ExternalSyntheticLambda84(), null);
        controlNormal = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda85(), new MaterialDynamicColors$$ExternalSyntheticLambda87());
        controlHighlight = new DynamicColor(new MaterialDynamicColors$$ExternalSyntheticLambda88(), new MaterialDynamicColors$$ExternalSyntheticLambda89(), new MaterialDynamicColors$$ExternalSyntheticLambda90(), new MaterialDynamicColors$$ExternalSyntheticLambda91(), null, new MaterialDynamicColors$$ExternalSyntheticLambda92(), new MaterialDynamicColors$$ExternalSyntheticLambda94(), null);
        textPrimaryInverse = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda95(), new MaterialDynamicColors$$ExternalSyntheticLambda96());
        textSecondaryAndTertiaryInverse = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda98(), new MaterialDynamicColors$$ExternalSyntheticLambda99());
        textPrimaryInverseDisableOnly = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda100(), new MaterialDynamicColors$$ExternalSyntheticLambda101());
        textSecondaryAndTertiaryInverseDisabled = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda102(), new MaterialDynamicColors$$ExternalSyntheticLambda103());
        textHintInverse = DynamicColor.fromPalette(new MaterialDynamicColors$$ExternalSyntheticLambda104(), new MaterialDynamicColors$$ExternalSyntheticLambda106());
    }

    static /* synthetic */ TonalPalette lambda$static$0(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$1(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 6.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 98.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$2(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$3(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 90.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 10.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$4(DynamicScheme r0) {
        return background;
    }

    static /* synthetic */ TonalPalette lambda$static$5(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$6(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 6.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 98.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$7(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$8(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 90.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 20.0d;
        goto L7
    }

    static /* synthetic */ Double lambda$static$10(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 24.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 98.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$9(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ TonalPalette lambda$static$11(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$12(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 6.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 87.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$13(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$14(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 4.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 100.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$15(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$16(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 10.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 96.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$17(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$18(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 12.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 94.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$19(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$20(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 17.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 92.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$21(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$22(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 22.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 90.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$23(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$24(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 90.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 10.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$25(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$26(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$27(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 20.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 95.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$28(DynamicScheme r0) {
        return surfaceInverse;
    }

    static /* synthetic */ TonalPalette lambda$static$29(DynamicScheme r0) {
        return r0.neutralVariantPalette;
    }

    static /* synthetic */ Double lambda$static$30(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 30.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 90.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$31(DynamicScheme r0) {
        return r0.neutralVariantPalette;
    }

    static /* synthetic */ Double lambda$static$32(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 80.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 30.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$33(DynamicScheme r0) {
        return surfaceVariant;
    }

    static /* synthetic */ TonalPalette lambda$static$34(DynamicScheme r0) {
        return r0.neutralVariantPalette;
    }

    static /* synthetic */ Double lambda$static$35(DynamicScheme r2) {
        return Double.valueOf(50.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$36(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$37(DynamicScheme r0) {
        return r0.neutralVariantPalette;
    }

    static /* synthetic */ Double lambda$static$38(DynamicScheme r2) {
        return Double.valueOf(80.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$39(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$40(DynamicScheme r0) {
        return r0.primaryPalette;
    }

    static /* synthetic */ Double lambda$static$41(DynamicScheme r2) {
        if (isFidelity(r2) == true) goto L11;
        if (r2.isDark == false) goto L7;
        double r0 = 30.0d;
    L9:
        return Double.valueOf(r0);
    L7:
        r0 = 90.0d;
        goto L9
    L11:
        return Double.valueOf(performAlbers(r2.sourceColorHct, r2));
    }

    static /* synthetic */ DynamicColor lambda$static$42(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$43(DynamicScheme r0) {
        return r0.primaryPalette;
    }

    static /* synthetic */ Double lambda$static$44(DynamicScheme r4) {
        if (isFidelity(r4) == true) goto L11;
        if (r4.isDark == false) goto L7;
        double r0 = 90.0d;
    L9:
        return Double.valueOf(r0);
    L7:
        r0 = 10.0d;
        goto L9
    L11:
        return Double.valueOf(DynamicColor.contrastingTone(primaryContainer.getTone(r4), 4.5d));
    }

    static /* synthetic */ DynamicColor lambda$static$45(DynamicScheme r0) {
        return primaryContainer;
    }

    static /* synthetic */ TonalPalette lambda$static$46(DynamicScheme r0) {
        return r0.primaryPalette;
    }

    static /* synthetic */ Double lambda$static$47(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 80.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 40.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$48(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ ToneDeltaConstraint lambda$static$49(DynamicScheme r4) {
        DynamicColor r1 = primaryContainer;
        if (r4.isDark == false) goto L5;
        TonePolarity r5 = TonePolarity.DARKER;
    L7:
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, r1, r5);
    L5:
        r5 = TonePolarity.LIGHTER;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$50(DynamicScheme r0) {
        return r0.primaryPalette;
    }

    static /* synthetic */ Double lambda$static$51(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 40.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 80.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$52(DynamicScheme r0) {
        return surfaceInverse;
    }

    static /* synthetic */ TonalPalette lambda$static$53(DynamicScheme r0) {
        return r0.primaryPalette;
    }

    static /* synthetic */ Double lambda$static$54(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 20.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 100.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$55(DynamicScheme r0) {
        return primary;
    }

    static /* synthetic */ TonalPalette lambda$static$56(DynamicScheme r0) {
        return r0.secondaryPalette;
    }

    static /* synthetic */ Double lambda$static$57(DynamicScheme r9) {
        if (r9.isDark == false) goto L5;
        double r0 = 30.0d;
    L6:
        double r6 = r0;
        if (isFidelity(r9) == true) goto L11;
        return Double.valueOf(r6);
    L11:
        return Double.valueOf(performAlbers(r9.secondaryPalette.getHct(findDesiredChromaByTone(r9.secondaryPalette.getHue(), r9.secondaryPalette.getChroma(), r6, !r9.isDark)), r9));
    L5:
        r0 = 90.0d;
        goto L6
    }

    static /* synthetic */ DynamicColor lambda$static$58(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$59(DynamicScheme r0) {
        return r0.secondaryPalette;
    }

    static /* synthetic */ Double lambda$static$60(DynamicScheme r4) {
        if (isFidelity(r4) == true) goto L11;
        if (r4.isDark == false) goto L7;
        double r0 = 90.0d;
    L9:
        return Double.valueOf(r0);
    L7:
        r0 = 10.0d;
        goto L9
    L11:
        return Double.valueOf(DynamicColor.contrastingTone(secondaryContainer.getTone(r4), 4.5d));
    }

    static /* synthetic */ DynamicColor lambda$static$61(DynamicScheme r0) {
        return secondaryContainer;
    }

    static /* synthetic */ TonalPalette lambda$static$62(DynamicScheme r0) {
        return r0.secondaryPalette;
    }

    static /* synthetic */ Double lambda$static$63(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 80.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 40.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$64(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ ToneDeltaConstraint lambda$static$65(DynamicScheme r4) {
        DynamicColor r1 = secondaryContainer;
        if (r4.isDark == false) goto L5;
        TonePolarity r5 = TonePolarity.DARKER;
    L7:
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, r1, r5);
    L5:
        r5 = TonePolarity.LIGHTER;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$66(DynamicScheme r0) {
        return r0.secondaryPalette;
    }

    static /* synthetic */ Double lambda$static$67(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 20.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 100.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$68(DynamicScheme r0) {
        return secondary;
    }

    static /* synthetic */ TonalPalette lambda$static$69(DynamicScheme r0) {
        return r0.tertiaryPalette;
    }

    static /* synthetic */ Double lambda$static$70(DynamicScheme r3) {
        if (isFidelity(r3) == false) goto L5;
        double r0 = performAlbers(r3.tertiaryPalette.getHct(r3.sourceColorHct.getTone()), r3);
        return Double.valueOf(DislikeAnalyzer.fixIfDisliked(r3.tertiaryPalette.getHct(r0)).getTone());
    L5:
        if (r3.isDark == false) goto L7;
        double r1 = 30.0d;
    L9:
        return Double.valueOf(r1);
    L7:
        r1 = 90.0d;
        goto L9
    }

    static /* synthetic */ DynamicColor lambda$static$71(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$72(DynamicScheme r0) {
        return r0.tertiaryPalette;
    }

    static /* synthetic */ Double lambda$static$73(DynamicScheme r4) {
        if (isFidelity(r4) == true) goto L11;
        if (r4.isDark == false) goto L7;
        double r0 = 90.0d;
    L9:
        return Double.valueOf(r0);
    L7:
        r0 = 10.0d;
        goto L9
    L11:
        return Double.valueOf(DynamicColor.contrastingTone(tertiaryContainer.getTone(r4), 4.5d));
    }

    static /* synthetic */ DynamicColor lambda$static$74(DynamicScheme r0) {
        return tertiaryContainer;
    }

    static /* synthetic */ TonalPalette lambda$static$75(DynamicScheme r0) {
        return r0.tertiaryPalette;
    }

    static /* synthetic */ Double lambda$static$76(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 80.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 40.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$77(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ ToneDeltaConstraint lambda$static$78(DynamicScheme r4) {
        DynamicColor r1 = tertiaryContainer;
        if (r4.isDark == false) goto L5;
        TonePolarity r5 = TonePolarity.DARKER;
    L7:
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, r1, r5);
    L5:
        r5 = TonePolarity.LIGHTER;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$79(DynamicScheme r0) {
        return r0.tertiaryPalette;
    }

    static /* synthetic */ Double lambda$static$80(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 20.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 100.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$81(DynamicScheme r0) {
        return tertiary;
    }

    static /* synthetic */ TonalPalette lambda$static$82(DynamicScheme r0) {
        return r0.errorPalette;
    }

    static /* synthetic */ Double lambda$static$83(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 30.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 90.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$84(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$85(DynamicScheme r0) {
        return r0.errorPalette;
    }

    static /* synthetic */ Double lambda$static$86(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 90.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 10.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$87(DynamicScheme r0) {
        return errorContainer;
    }

    static /* synthetic */ TonalPalette lambda$static$88(DynamicScheme r0) {
        return r0.errorPalette;
    }

    static /* synthetic */ Double lambda$static$89(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 80.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 40.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$90(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ ToneDeltaConstraint lambda$static$91(DynamicScheme r4) {
        DynamicColor r1 = errorContainer;
        if (r4.isDark == false) goto L5;
        TonePolarity r5 = TonePolarity.DARKER;
    L7:
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, r1, r5);
    L5:
        r5 = TonePolarity.LIGHTER;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$92(DynamicScheme r0) {
        return r0.errorPalette;
    }

    static /* synthetic */ Double lambda$static$93(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 20.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 100.0d;
        goto L7
    }

    static /* synthetic */ DynamicColor lambda$static$94(DynamicScheme r0) {
        return error;
    }

    static /* synthetic */ TonalPalette lambda$static$95(DynamicScheme r0) {
        return r0.primaryPalette;
    }

    static /* synthetic */ Double lambda$static$96(DynamicScheme r2) {
        return Double.valueOf(90.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$97(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ DynamicColor lambda$static$100(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$98(DynamicScheme r0) {
        return r0.primaryPalette;
    }

    static /* synthetic */ Double lambda$static$99(DynamicScheme r2) {
        return Double.valueOf(80.0d);
    }

    static /* synthetic */ TonalPalette lambda$static$101(DynamicScheme r0) {
        return r0.primaryPalette;
    }

    static /* synthetic */ Double lambda$static$102(DynamicScheme r2) {
        return Double.valueOf(10.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$103(DynamicScheme r0) {
        return primaryFixedDarker;
    }

    static /* synthetic */ TonalPalette lambda$static$104(DynamicScheme r0) {
        return r0.primaryPalette;
    }

    static /* synthetic */ Double lambda$static$105(DynamicScheme r2) {
        return Double.valueOf(30.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$106(DynamicScheme r0) {
        return primaryFixedDarker;
    }

    static /* synthetic */ TonalPalette lambda$static$107(DynamicScheme r0) {
        return r0.secondaryPalette;
    }

    static /* synthetic */ Double lambda$static$108(DynamicScheme r2) {
        return Double.valueOf(90.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$109(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$110(DynamicScheme r0) {
        return r0.secondaryPalette;
    }

    static /* synthetic */ Double lambda$static$111(DynamicScheme r2) {
        return Double.valueOf(80.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$112(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$113(DynamicScheme r0) {
        return r0.secondaryPalette;
    }

    static /* synthetic */ Double lambda$static$114(DynamicScheme r2) {
        return Double.valueOf(10.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$115(DynamicScheme r0) {
        return secondaryFixedDarker;
    }

    static /* synthetic */ TonalPalette lambda$static$116(DynamicScheme r0) {
        return r0.secondaryPalette;
    }

    static /* synthetic */ Double lambda$static$117(DynamicScheme r2) {
        return Double.valueOf(30.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$118(DynamicScheme r0) {
        return secondaryFixedDarker;
    }

    static /* synthetic */ TonalPalette lambda$static$119(DynamicScheme r0) {
        return r0.tertiaryPalette;
    }

    static /* synthetic */ Double lambda$static$120(DynamicScheme r2) {
        return Double.valueOf(90.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$121(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$122(DynamicScheme r0) {
        return r0.tertiaryPalette;
    }

    static /* synthetic */ Double lambda$static$123(DynamicScheme r2) {
        return Double.valueOf(80.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$124(DynamicScheme r0) {
        return highestSurface(r0);
    }

    static /* synthetic */ TonalPalette lambda$static$125(DynamicScheme r0) {
        return r0.tertiaryPalette;
    }

    static /* synthetic */ Double lambda$static$126(DynamicScheme r2) {
        return Double.valueOf(10.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$127(DynamicScheme r0) {
        return tertiaryFixedDarker;
    }

    static /* synthetic */ TonalPalette lambda$static$128(DynamicScheme r0) {
        return r0.tertiaryPalette;
    }

    static /* synthetic */ Double lambda$static$129(DynamicScheme r2) {
        return Double.valueOf(30.0d);
    }

    static /* synthetic */ DynamicColor lambda$static$130(DynamicScheme r0) {
        return tertiaryFixedDarker;
    }

    static /* synthetic */ TonalPalette lambda$static$131(DynamicScheme r0) {
        return r0.primaryPalette;
    }

    static /* synthetic */ Double lambda$static$132(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 30.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 90.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$133(DynamicScheme r0) {
        return r0.neutralVariantPalette;
    }

    static /* synthetic */ Double lambda$static$134(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 80.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 30.0d;
        goto L7
    }

    static /* synthetic */ Double lambda$static$135(DynamicScheme r2) {
        return Double.valueOf(0.0d);
    }

    static /* synthetic */ Double lambda$static$136(DynamicScheme r2) {
        return Double.valueOf(0.0d);
    }

    static /* synthetic */ Double lambda$static$137(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 100.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 0.0d;
        goto L7
    }

    static /* synthetic */ Double lambda$static$138(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 0.2d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 0.12d;
        goto L7
    }

    static /* synthetic */ Double lambda$static$140(DynamicScheme r2) {
        return Double.valueOf(DynamicColor.toneMinContrastDefault(new MaterialDynamicColors$$ExternalSyntheticLambda64(), null, r2, null));
    }

    static /* synthetic */ Double lambda$static$139(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 100.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 0.0d;
        goto L7
    }

    static /* synthetic */ Double lambda$static$142(DynamicScheme r2) {
        return Double.valueOf(DynamicColor.toneMaxContrastDefault(new MaterialDynamicColors$$ExternalSyntheticLambda0(), null, r2, null));
    }

    static /* synthetic */ Double lambda$static$141(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 100.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 0.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$143(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$144(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 10.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 90.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$145(DynamicScheme r0) {
        return r0.neutralVariantPalette;
    }

    static /* synthetic */ Double lambda$static$146(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 30.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 80.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$147(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$148(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 10.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 90.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$149(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$150(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 10.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 90.0d;
        goto L7
    }

    static /* synthetic */ TonalPalette lambda$static$151(DynamicScheme r0) {
        return r0.neutralPalette;
    }

    static /* synthetic */ Double lambda$static$152(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 10.0d;
    L7:
        return Double.valueOf(r0);
    L5:
        r0 = 90.0d;
        goto L7
    }

    private static ViewingConditions viewingConditionsForAlbers(DynamicScheme r2) {
        if (r2.isDark == false) goto L5;
        double r0 = 30.0d;
    L7:
        return ViewingConditions.defaultWithBackgroundLstar(r0);
    L5:
        r0 = 80.0d;
        goto L7
    }

    private static boolean isFidelity(DynamicScheme r2) {
        if (r2.variant != Variant.FIDELITY) goto L5;
    L8:
        return true;
    L5:
        if (r2.variant == Variant.CONTENT) goto L8;
        return false;
    }

    static double findDesiredChromaByTone(double r11, double r13, double r15, boolean r17) {
        Hct r0 = Hct.from(r11, r13, r15);
        if (r0.getChroma() >= r13) goto L22;
        Hct r6 = r0;
        double r7 = r0.getChroma();
        double r1 = r15;
    L6:
        if (r6.getChroma() >= r13) goto L28;
        if (r17 == false) goto L9;
        double r2 = -1.0d;
    L10:
        double r9 = r1 + r2;
        Hct r3 = Hct.from(r11, r13, r9);
        if (r7 > r3.getChroma()) goto L29;
        if (Math.abs(r3.getChroma() - r13) < 0.4d) goto L30;
        if (Math.abs(r3.getChroma() - r13) >= Math.abs(r6.getChroma() - r13)) goto L19;
        r6 = r3;
    L19:
        r7 = Math.max(r7, r3.getChroma());
        r1 = r9;
        goto L6
    L30:
        return r9;
    L29:
        return r9;
    L9:
        r2 = 1.0d;
        goto L10
    L28:
        return r1;
    L22:
        return r15;
    }

    static double performAlbers(Hct r2, DynamicScheme r3) {
        Hct r4 = r2.inViewingConditions(viewingConditionsForAlbers(r3));
        if (DynamicColor.tonePrefersLightForeground(r2.getTone()) == false) goto L9;
        if (DynamicColor.toneAllowsLightForeground(r4.getTone()) == true) goto L9;
        return DynamicColor.enableLightForeground(r2.getTone());
    L9:
        return DynamicColor.enableLightForeground(r4.getTone());
    }
}
