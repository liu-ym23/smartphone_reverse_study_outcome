package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes2.dex */
public class HctSolver {
    static final double[] CRITICAL_PLANES = null;
    static final double[][] LINRGB_FROM_SCALED_DISCOUNT = null;
    static final double[][] SCALED_DISCOUNT_FROM_LINRGB = null;
    static final double[] Y_FROM_LINRGB = null;

    static double intercept(double r0, double r2, double r4) {
        return (r2 - r0) / (r4 - r0);
    }

    static boolean isBounded(double r2) {
        if (0.0d <= r2) goto L5;
    L7:
        return false;
    L5:
        if (r2 > 100.0d) goto L7;
        return true;
    }

    static double sanitizeRadians(double r2) {
        return (r2 + 25.132741228718345d) % 6.283185307179586d;
    }

    private HctSolver() {
    }

    static {
        SCALED_DISCOUNT_FROM_LINRGB = new double[][]{new double[]{0.001200833568784504d, 0.002389694492170889d, 2.795742885861124E-4d}, new double[]{5.891086651375999E-4d, 0.0029785502573438758d, 3.270666104008398E-4d}, new double[]{1.0146692491640572E-4d, 5.364214359186694E-4d, 0.0032979401770712076d}};
        LINRGB_FROM_SCALED_DISCOUNT = new double[][]{new double[]{1373.2198709594231d, -1100.4251190754821d, -7.278681089101213d}, new double[]{-271.815969077903d, 559.6580465940733d, -32.46047482791194d}, new double[]{1.9622899599665666d, -57.173814538844006d, 308.7233197812385d}};
        Y_FROM_LINRGB = new double[]{0.2126d, 0.7152d, 0.0722d};
        CRITICAL_PLANES = new double[]{0.015176349177441876d, 0.045529047532325624d, 0.07588174588720938d, 0.10623444424209313d, 0.13658714259697685d, 0.16693984095186062d, 0.19729253930674434d, 0.2276452376616281d, 0.2579979360165119d, 0.28835063437139563d, 0.3188300904430532d, 0.350925934958123d, 0.3848314933096426d, 0.42057480301049466d, 0.458183274052838d, 0.4976837250274023d, 0.5391024159806381d, 0.5824650784040898d, 0.6277969426914107d, 0.6751227633498623d, 0.7244668422128921d, 0.775853049866786d, 0.829304845476233d, 0.8848452951698498d, 0.942497089126609d, 1.0022825574869039d, 1.0642236851973577d, 1.1283421258858297d, 1.1946592148522128d, 1.2631959812511864d, 1.3339731595349034d, 1.407011200216447d, 1.4823302800086415d, 1.5599503113873272d, 1.6398909516233677d, 1.7221716113234105d, 1.8068114625156377d, 1.8938294463134073d, 1.9832442801866852d, 2.075074464868551d, 2.1693382909216234d, 2.2660538449872063d, 2.36523901573795d, 2.4669114995532007d, 2.5710888059345764d, 2.6777882626779785d, 2.7870270208169257d, 2.898822059350997d, 3.0131901897720907d, 3.1301480604002863d, 3.2497121605402226d, 3.3718988244681087d, 3.4967242352587946d, 3.624204428461639d, 3.754355295633311d, 3.887192587735158d, 4.022731918402185d, 4.160988767090289d, 4.301978482107941d, 4.445716283538092d, 4.592217266055746d, 4.741496401646282d, 4.893568542229298d, 5.048448422192488d, 5.20615066083972d, 5.3666897647573375d, 5.5300801301023865d, 5.696336044816294d, 5.865471690767354d, 6.037501145825082d, 6.212438385869475d, 6.390297286737924d, 6.571091626112461d, 6.7548350853498045d, 6.941541251256611d, 7.131223617812143d, 7.323895587840543d, 7.5195704746346665d, 7.7182615035334345d, 7.919981813454504d, 8.124744458384042d, 8.332562408825165d, 8.543448553206703d, 8.757415699253682d, 8.974476575321063d, 9.194643831691977d, 9.417930041841839d, 9.644347703669503d, 9.873909240696694d, 10.106627003236781d, 10.342513269534024d, 10.58158024687427d, 10.8238400726681d, 11.069304815507364d, 11.317986476196008d, 11.569896988756009d, 11.825048221409341d, 12.083451977536606d, 12.345119996613247d, 12.610063955123938d, 12.878295467455942d, 13.149826086772048d, 13.42466730586372d, 13.702830557985108d, 13.984327217668513d, 14.269168601521828d, 14.55736596900856d, 14.848930523210871d, 15.143873411576273d, 15.44220572664832d, 15.743938506781891d, 16.04908273684337d, 16.35764934889634d, 16.66964922287304d, 16.985093187232053d, 17.30399201960269d, 17.62635644741625d, 17.95219714852476d, 18.281524751807332d, 18.614349837764564d, 18.95068293910138d, 19.290534541298456d, 19.633915083172692d, 19.98083495742689d, 20.331304511189067d, 20.685334046541502d, 21.042933821039977d, 21.404114048223256d, 21.76888489811322d, 22.137256497705877d, 22.50923893145328d, 22.884842241736916d, 23.264076429332462d, 23.6469514538663d, 24.033477234264016d, 24.42366364919083d, 24.817520537484558d, 25.21505769858089d, 25.61628489293138d, 26.021211842414342d, 26.429848230738664d, 26.842203703840827d, 27.258287870275353d, 27.678110301598522d, 28.10168053274597d, 28.529008062403893d, 28.96010235337422d, 29.39497283293396d, 29.83362889318845d, 30.276079891419332d, 30.722335150426627d, 31.172403958865512d, 31.62629557157785d, 32.08401920991837d, 32.54558406207592d, 33.010999283389665d, 33.4802739966603d, 33.953417292456834d, 34.430438229418264d, 34.911345834551085d, 35.39614910352207d, 35.88485700094671d, 36.37747846067349d, 36.87402238606382d, 37.37449765026789d, 37.87891309649659d, 38.38727753828926d, 38.89959975977785d, 39.41588851594697d, 39.93615253289054d, 40.460400508064545d, 40.98864111053629d, 41.520882981230194d, 42.05713473317016d, 42.597404951718396d, 43.141702194811224d, 43.6900349931913d, 44.24241185063697d, 44.798841244188324d, 45.35933162437017d, 45.92389141541209d, 46.49252901546552d, 47.065252796817916d, 47.64207110610409d, 48.22299226451468d, 48.808024568002054d, 49.3971762874833d, 49.9904556690408d, 50.587870934119984d, 51.189430279724725d, 51.79514187861014d, 52.40501387947288d, 53.0190544071392d, 53.637271562750364d, 54.259673423945976d, 54.88626804504493d, 55.517063457223934d, 56.15206766869424d, 56.79128866487574d, 57.43473440856916d, 58.08241284012621d, 58.734331877617365d, 59.39049941699807d, 60.05092333227251d, 60.715611475655585d, 61.38457167773311d, 62.057811747619894d, 62.7353394731159d, 63.417162620860914d, 64.10328893648692d, 64.79372614476921d, 65.48848194977529d, 66.18756403501224d, 66.89098006357258d, 67.59873767827808d, 68.31084450182222d, 69.02730813691093d, 69.74813616640164d, 70.47333615344107d, 71.20291564160104d, 71.93688215501312d, 72.67524319850172d, 73.41800625771542d, 74.16517879925733d, 74.9167682708136d, 75.67278210128072d, 76.43322770089146d, 77.1981124613393d, 77.96744375590167d, 78.74122893956174d, 79.51947534912904d, 80.30219030335869d, 81.08938110306934d, 81.88105503125999d, 82.67721935322541d, 83.4778813166706d, 84.28304815182372d, 85.09272707154808d, 85.90692527145302d, 86.72564993000343d, 87.54890820862819d, 88.3767072518277d, 89.2090541872801d, 90.04595612594655d, 90.88742016217518d, 91.73345337380438d, 92.58406282226491d, 93.43925555268066d, 94.29903859396902d, 95.16341895893969d, 96.03240364439274d, 96.9059996312159d, 97.78421388448044d, 98.6670533535366d, 99.55452497210776d};
    }

    static double trueDelinearized(double r2) {
        double r3 = r2 / 100.0d;
        if (r3 > 0.0031308d) goto L5;
        double r4 = r3 * 12.92d;
    L7:
        return r4 * 255.0d;
    L5:
        r4 = (Math.pow(r3, 0.4166666666666667d) * 1.055d) - 0.055d;
        goto L7
    }

    static double chromaticAdaptation(double r4) {
        double r0 = Math.pow(Math.abs(r4), 0.42d);
        return ((((double) MathUtils.signum(r4)) * 400.0d) * r0) / (r0 + 27.13d);
    }

    static double hueOf(double[] r12) {
        double[] r13 = MathUtils.matrixMultiply(r12, SCALED_DISCOUNT_FROM_LINRGB);
        double r0 = chromaticAdaptation(r13[0]);
        double r2 = chromaticAdaptation(r13[1]);
        double r4 = chromaticAdaptation(r13[2]);
        double r8 = (((r0 * 11.0d) + ((-12.0d) * r2)) + r4) / 11.0d;
        return Math.atan2(((r0 + r2) - (r4 * 2.0d)) / 9.0d, r8);
    }

    static boolean areInCyclicOrder(double r0, double r2, double r4) {
        if (sanitizeRadians(r2 - r0) >= sanitizeRadians(r4 - r0)) goto L5;
        return true;
    L5:
        return false;
    }

    static double[] lerpPoint(double[] r6, double r7, double[] r9) {
        double r2 = r6[0];
        double r3 = r6[1];
        double r4 = r6[2];
        return new double[]{r2 + ((r9[0] - r2) * r7), r3 + ((r9[1] - r3) * r7), r4 + ((r9[2] - r4) * r7)};
    }

    static double[] setCoordinate(double[] r6, double r7, double[] r9, int r10) {
        return lerpPoint(r6, intercept(r6[r10], r7, r9[r10]), r9);
    }

    static double[] nthVertex(double r17, int r19) {
        double[] r1 = Y_FROM_LINRGB;
        double r3 = r1[0];
        double r6 = r1[1];
        double r9 = r1[2];
        double r11 = 0.0d;
        if ((r19 % 4) > 1) goto L5;
        double r15 = 0.0d;
    L7:
        if ((r19 % 2) == 0) goto L11;
        r11 = 100.0d;
    L11:
        if (r19 >= 4) goto L19;
        double r7 = ((r17 - (r6 * r15)) - (r9 * r11)) / r3;
        if (isBounded(r7) == false) goto L17;
        return new double[]{r7, r15, r11};
    L17:
        return new double[]{-1.0d, -1.0d, -1.0d};
    L19:
        if (r19 >= 8) goto L26;
        double r4 = ((r17 - (r3 * r11)) - (r9 * r15)) / r6;
        if (isBounded(r4) == false) goto L25;
        return new double[]{r11, r4, r15};
    L25:
        return new double[]{-1.0d, -1.0d, -1.0d};
    L26:
        double r5 = ((r17 - (r3 * r15)) - (r6 * r11)) / r9;
        if (isBounded(r5) == false) goto L31;
        return new double[]{r15, r11, r5};
    L31:
        return new double[]{-1.0d, -1.0d, -1.0d};
    L5:
        r15 = 100.0d;
        goto L7
    }

    static double[][] bisectToSegment(double r22, double r24) {
        double[] r0 = {-1.0d, -1.0d, -1.0d};
        double[] r5 = r0;
        double r15 = 0.0d;
        double r17 = 0.0d;
        int r6 = 0;
        boolean r7 = false;
        boolean r8 = true;
    L4:
        if (r6 >= 12) goto L20;
        double[] r19 = nthVertex(r22, r6);
        if (r19[0] < 0.0d) goto L18;
        double r20 = hueOf(r19);
        if (r7 == true) goto L11;
        r7 = true;
        r0 = r19;
        r5 = r0;
        r15 = r20;
        r17 = r15;
        goto L18
    L11:
        if (r8 == true) goto L15;
        if (areInCyclicOrder(r15, r20, r17) == false) goto L18;
    L15:
        if (areInCyclicOrder(r15, r24, r20) == false) goto L17;
        r8 = false;
        r5 = r19;
        r17 = r20;
        goto L18
    L17:
        r8 = false;
        r0 = r19;
        r15 = r20;
    L18:
        r6 = r6 + 1;
        goto L4
    L20:
        return new double[][]{r0, r5};
    }

    static double[] midpoint(double[] r8, double[] r9) {
        return new double[]{(r8[0] + r9[0]) / 2.0d, (r8[1] + r9[1]) / 2.0d, (r8[2] + r9[2]) / 2.0d};
    }

    static int criticalPlaneBelow(double r2) {
        return (int) Math.floor(r2 - 0.5d);
    }

    static int criticalPlaneAbove(double r2) {
        return (int) Math.ceil(r2 - 0.5d);
    }

    static double[] bisectToLimit(double r20, double r22) {
        double[][] r0 = bisectToSegment(r20, r22);
        double[] r2 = r0[0];
        double r3 = hueOf(r2);
        double[] r1 = r0[1];
        int r6 = 0;
    L4:
        if (r6 >= 3) goto L24;
        double r7 = r2[r6];
        double r9 = r1[r6];
        if (r7 == r9) goto L22;
        if (r7 >= r9) goto L10;
        int r8 = criticalPlaneBelow(trueDelinearized(r7));
        int r10 = criticalPlaneAbove(trueDelinearized(r1[r6]));
    L11:
        int r15 = 0;
        int r13 = r8;
        int r14 = r10;
    L13:
        if (r15 >= 8) goto L22;
        if (Math.abs(r14 - r13) <= 1) goto L22;
        int r11 = (int) Math.floor(((double) (r13 + r14)) / 2.0d);
        double[] r16 = setCoordinate(r2, CRITICAL_PLANES[r11], r1, r6);
        double r17 = hueOf(r16);
        if (areInCyclicOrder(r3, r22, r17) == false) goto L20;
        r1 = r16;
        r14 = r11;
    L21:
        r15 = r15 + 1;
        goto L13
    L20:
        r2 = r16;
        r3 = r17;
        r13 = r11;
        goto L21
    L10:
        r8 = criticalPlaneAbove(trueDelinearized(r7));
        r10 = criticalPlaneBelow(trueDelinearized(r1[r6]));
    L22:
        r6 = r6 + 1;
        goto L4
    L24:
        return midpoint(r2, r1);
    }

    static double inverseChromaticAdaptation(double r6) {
        double r0 = Math.abs(r6);
        double r1 = Math.max(0.0d, (27.13d * r0) / (400.0d - r0));
        return ((double) MathUtils.signum(r6)) * Math.pow(r1, 2.380952380952381d);
    }

    static int findResultByJ(double r36, double r38, double r40) {
        double r0 = Math.sqrt(r40) * 11.0d;
        ViewingConditions r4 = ViewingConditions.DEFAULT;
        double r5 = 1.0d / Math.pow(1.64d - Math.pow(0.29d, r4.getN()), 0.73d);
        double r11 = ((((Math.cos(r36 + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * r4.getNc()) * r4.getNcb();
        double r13 = Math.sin(r36);
        double r15 = Math.cos(r36);
        int r9 = 0;
    L4:
        if (r9 >= 5) goto L37;
        double r2 = r0 / 100.0d;
        if (r38 != 0.0d) goto L8;
    L11:
        double r24 = 0.0d;
    L12:
        double r7 = r24 * r5;
        double r25 = r5;
        double r6 = Math.pow(r7, 1.1111111111111112d);
        double r37 = r0;
        double r8 = (r4.getAw() * Math.pow(r2, (1.0d / r4.getC()) / r4.getZ())) / r4.getNbb();
        double r1 = (((0.305d + r8) * 23.0d) * r6) / (((23.0d * r11) + ((r6 * 11.0d) * r15)) + ((r6 * 108.0d) * r13));
        double r3 = r1 * r15;
        double r10 = r1 * r13;
        double r12 = r8 * 460.0d;
        double[] r14 = MathUtils.matrixMultiply(new double[]{inverseChromaticAdaptation((((451.0d * r3) + r12) + (288.0d * r10)) / 1403.0d), inverseChromaticAdaptation(((r12 - (891.0d * r3)) - (261.0d * r10)) / 1403.0d), inverseChromaticAdaptation(((r12 - (r3 * 220.0d)) - (r10 * 6300.0d)) / 1403.0d)}, LINRGB_FROM_SCALED_DISCOUNT);
        double r16 = r14[0];
        if (r16 < 0.0d) goto L37;
        double r17 = r14[1];
        if (r17 < 0.0d) goto L37;
        double r28 = r14[2];
        if (r28 < 0.0d) goto L37;
        double[] r18 = Y_FROM_LINRGB;
        double r30 = ((r18[0] * r16) + (r18[1] * r17)) + (r18[2] * r28);
        if (r30 <= 0.0d) goto L21;
        if (r9 == 4) goto L29;
        double r19 = r30 - r40;
        if (Math.abs(r19) < 0.002d) goto L29;
        r0 = r37 - ((r19 * r37) / (r30 * 2.0d));
        r9 = r9 + 1;
        r5 = r25;
    L29:
        if (r14[0] > 100.01d) goto L37;
        if (r14[1] > 100.01d) goto L37;
        if (r14[2] > 100.01d) goto L37;
        return ColorUtils.argbFromLinrgb(r14);
    L21:
        return 0;
    L8:
        if (r0 == 0.0d) goto L11;
        r24 = r38 / Math.sqrt(r2);
    L37:
        return 0;
    }

    public static int solveToInt(double r8, double r10, double r12) {
        if (r10 < 1.0E-4d) goto L15;
        if (r12 < 1.0E-4d) goto L15;
        if (r12 > 99.9999d) goto L15;
        double r9 = (MathUtils.sanitizeDegreesDouble(r8) / 180.0d) * 3.141592653589793d;
        double r13 = ColorUtils.yFromLstar(r12);
        int r11 = findResultByJ(r9, r10, r13);
        if (r11 == 0) goto L13;
        return r11;
    L13:
        return ColorUtils.argbFromLinrgb(bisectToLimit(r13, r9));
    L15:
        return ColorUtils.argbFromLstar(r12);
    }

    public static Cam16 solveToCam(double r0, double r2, double r4) {
        return Cam16.fromInt(solveToInt(r0, r2, r4));
    }
}
