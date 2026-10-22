package androidx.compose.material3.internal.colorUtil;

import androidx.camera.video.AudioStats;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0016\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J \u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0002J \u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J(\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\fH\u0002J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\"H\u0002J#\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010&\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0002¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\"2\u0006\u0010$\u001a\u00020\fH\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010$\u001a\u00020\fH\u0002J\u0018\u0010-\u001a\u00020\"2\u0006\u0010&\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0002J\u0010\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\fH\u0002J \u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002J\u001e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00105\u001a\u00020\fJ\u0010\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\fH\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/compose/material3/internal/colorUtil/HctSolver;", "", "<init>", "()V", "SCALED_DISCOUNT_FROM_LINRGB", "", "", "[[D", "LINRGB_FROM_SCALED_DISCOUNT", "Y_FROM_LINRGB", "CRITICAL_PLANES", "sanitizeRadians", "", "angle", "trueDelinearized", "rgbComponent", "chromaticAdaptation", "component", "hueOf", "linrgb", "areInCyclicOrder", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "intercept", "source", "mid", PickerReporterConstants.KEY.TARGET, "lerpPoint", "t", "setCoordinate", "coordinate", "axis", "", "isBounded", "x", "nthVertex", "y", OfficeSDKRequestTag.KEY_NEW_USER, "bisectToSegment", "targetHue", "(DD)[[D", "criticalPlaneBelow", "criticalPlaneAbove", "bisectToLimit", "inverseChromaticAdaptation", "adapted", "findResultByJ", "hueRadians", "chroma", "solveToInt", "hueDegrees", "lstar", "sanitizeDegreesDouble", "degrees", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HctSolver {
    public static final int $stable = 0;
    private static final double[] CRITICAL_PLANES = null;
    public static final HctSolver INSTANCE = null;
    private static final double[][] LINRGB_FROM_SCALED_DISCOUNT = null;
    private static final double[][] SCALED_DISCOUNT_FROM_LINRGB = null;
    private static final double[] Y_FROM_LINRGB = null;

    private HctSolver() {
    }

    private final double intercept(double r100, double r101, double r102) {
        if (r102 != r100) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return r102;
    L9:
        return (r101 - r100) / (r102 - r100);
    L5:
        r103 = false;
        goto L6
    }

    private final boolean isBounded(double r100) {
        if (AudioStats.AUDIO_AMPLITUDE_NONE <= r100) goto L5;
        return false;
    L5:
        if (r100 > 100.0d) goto L9;
        return true;
    L9:
        return false;
    }

    private final double sanitizeDegreesDouble(double r100) {
        double r101 = r100 % 360.0d;
        if (r101 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        return r101;
    L5:
        return r101 + 360.0d;
    }

    private final double sanitizeRadians(double r100) {
        return (r100 + 25.132741228718345d) % 6.283185307179586d;
    }

    static {
        INSTANCE = new HctSolver();
        SCALED_DISCOUNT_FROM_LINRGB = new double[][]{new double[]{0.001200833568784504d, 0.002389694492170889d, 2.795742885861124E-4d}, new double[]{5.891086651375999E-4d, 0.0029785502573438758d, 3.270666104008398E-4d}, new double[]{1.0146692491640572E-4d, 5.364214359186694E-4d, 0.0032979401770712076d}};
        LINRGB_FROM_SCALED_DISCOUNT = new double[][]{new double[]{1373.2198709594231d, -1100.4251190754821d, -7.278681089101213d}, new double[]{-271.815969077903d, 559.6580465940733d, -32.46047482791194d}, new double[]{1.9622899599665666d, -57.173814538844006d, 308.7233197812385d}};
        Y_FROM_LINRGB = new double[]{0.2126d, 0.7152d, 0.0722d};
        CRITICAL_PLANES = new double[]{0.015176349177441876d, 0.045529047532325624d, 0.07588174588720938d, 0.10623444424209313d, 0.13658714259697685d, 0.16693984095186062d, 0.19729253930674434d, 0.2276452376616281d, 0.2579979360165119d, 0.28835063437139563d, 0.3188300904430532d, 0.350925934958123d, 0.3848314933096426d, 0.42057480301049466d, 0.458183274052838d, 0.4976837250274023d, 0.5391024159806381d, 0.5824650784040898d, 0.6277969426914107d, 0.6751227633498623d, 0.7244668422128921d, 0.775853049866786d, 0.829304845476233d, 0.8848452951698498d, 0.942497089126609d, 1.0022825574869039d, 1.0642236851973577d, 1.1283421258858297d, 1.1946592148522128d, 1.2631959812511864d, 1.3339731595349034d, 1.407011200216447d, 1.4823302800086415d, 1.5599503113873272d, 1.6398909516233677d, 1.7221716113234105d, 1.8068114625156377d, 1.8938294463134073d, 1.9832442801866852d, 2.075074464868551d, 2.1693382909216234d, 2.2660538449872063d, 2.36523901573795d, 2.4669114995532007d, 2.5710888059345764d, 2.6777882626779785d, 2.7870270208169257d, 2.898822059350997d, 3.0131901897720907d, 3.1301480604002863d, 3.2497121605402226d, 3.3718988244681087d, 3.4967242352587946d, 3.624204428461639d, 3.754355295633311d, 3.887192587735158d, 4.022731918402185d, 4.160988767090289d, 4.301978482107941d, 4.445716283538092d, 4.592217266055746d, 4.741496401646282d, 4.893568542229298d, 5.048448422192488d, 5.20615066083972d, 5.3666897647573375d, 5.5300801301023865d, 5.696336044816294d, 5.865471690767354d, 6.037501145825082d, 6.212438385869475d, 6.390297286737924d, 6.571091626112461d, 6.7548350853498045d, 6.941541251256611d, 7.131223617812143d, 7.323895587840543d, 7.5195704746346665d, 7.7182615035334345d, 7.919981813454504d, 8.124744458384042d, 8.332562408825165d, 8.543448553206703d, 8.757415699253682d, 8.974476575321063d, 9.194643831691977d, 9.417930041841839d, 9.644347703669503d, 9.873909240696694d, 10.106627003236781d, 10.342513269534024d, 10.58158024687427d, 10.8238400726681d, 11.069304815507364d, 11.317986476196008d, 11.569896988756009d, 11.825048221409341d, 12.083451977536606d, 12.345119996613247d, 12.610063955123938d, 12.878295467455942d, 13.149826086772048d, 13.42466730586372d, 13.702830557985108d, 13.984327217668513d, 14.269168601521828d, 14.55736596900856d, 14.848930523210871d, 15.143873411576273d, 15.44220572664832d, 15.743938506781891d, 16.04908273684337d, 16.35764934889634d, 16.66964922287304d, 16.985093187232053d, 17.30399201960269d, 17.62635644741625d, 17.95219714852476d, 18.281524751807332d, 18.614349837764564d, 18.95068293910138d, 19.290534541298456d, 19.633915083172692d, 19.98083495742689d, 20.331304511189067d, 20.685334046541502d, 21.042933821039977d, 21.404114048223256d, 21.76888489811322d, 22.137256497705877d, 22.50923893145328d, 22.884842241736916d, 23.264076429332462d, 23.6469514538663d, 24.033477234264016d, 24.42366364919083d, 24.817520537484558d, 25.21505769858089d, 25.61628489293138d, 26.021211842414342d, 26.429848230738664d, 26.842203703840827d, 27.258287870275353d, 27.678110301598522d, 28.10168053274597d, 28.529008062403893d, 28.96010235337422d, 29.39497283293396d, 29.83362889318845d, 30.276079891419332d, 30.722335150426627d, 31.172403958865512d, 31.62629557157785d, 32.08401920991837d, 32.54558406207592d, 33.010999283389665d, 33.4802739966603d, 33.953417292456834d, 34.430438229418264d, 34.911345834551085d, 35.39614910352207d, 35.88485700094671d, 36.37747846067349d, 36.87402238606382d, 37.37449765026789d, 37.87891309649659d, 38.38727753828926d, 38.89959975977785d, 39.41588851594697d, 39.93615253289054d, 40.460400508064545d, 40.98864111053629d, 41.520882981230194d, 42.05713473317016d, 42.597404951718396d, 43.141702194811224d, 43.6900349931913d, 44.24241185063697d, 44.798841244188324d, 45.35933162437017d, 45.92389141541209d, 46.49252901546552d, 47.065252796817916d, 47.64207110610409d, 48.22299226451468d, 48.808024568002054d, 49.3971762874833d, 49.9904556690408d, 50.587870934119984d, 51.189430279724725d, 51.79514187861014d, 52.40501387947288d, 53.0190544071392d, 53.637271562750364d, 54.259673423945976d, 54.88626804504493d, 55.517063457223934d, 56.15206766869424d, 56.79128866487574d, 57.43473440856916d, 58.08241284012621d, 58.734331877617365d, 59.39049941699807d, 60.05092333227251d, 60.715611475655585d, 61.38457167773311d, 62.057811747619894d, 62.7353394731159d, 63.417162620860914d, 64.10328893648692d, 64.79372614476921d, 65.48848194977529d, 66.18756403501224d, 66.89098006357258d, 67.59873767827808d, 68.31084450182222d, 69.02730813691093d, 69.74813616640164d, 70.47333615344107d, 71.20291564160104d, 71.93688215501312d, 72.67524319850172d, 73.41800625771542d, 74.16517879925733d, 74.9167682708136d, 75.67278210128072d, 76.43322770089146d, 77.1981124613393d, 77.96744375590167d, 78.74122893956174d, 79.51947534912904d, 80.30219030335869d, 81.08938110306934d, 81.88105503125999d, 82.67721935322541d, 83.4778813166706d, 84.28304815182372d, 85.09272707154808d, 85.90692527145302d, 86.72564993000343d, 87.54890820862819d, 88.3767072518277d, 89.2090541872801d, 90.04595612594655d, 90.88742016217518d, 91.73345337380438d, 92.58406282226491d, 93.43925555268066d, 94.29903859396902d, 95.16341895893969d, 96.03240364439274d, 96.9059996312159d, 97.78421388448044d, 98.6670533535366d, 99.55452497210776d};
        $stable = 8;
    }

    private final double chromaticAdaptation(double r100) {
        double r101 = Math.pow(Math.abs(r100), 0.42d);
        return ((((double) CamUtils.INSTANCE.signum(r100)) * 400.0d) * r101) / (r101 + 27.13d);
    }

    private final int criticalPlaneAbove(double r100) {
        return (int) Math.ceil(r100 - 0.5d);
    }

    private final int criticalPlaneBelow(double r100) {
        return (int) Math.floor(r100 - 0.5d);
    }

    private final double hueOf(double[] r110) {
        double[][] r100 = SCALED_DISCOUNT_FROM_LINRGB;
        double r101 = r110[0];
        double[] r102 = r100[0];
        double r103 = r102[0] * r101;
        double r104 = r110[1];
        double r105 = r103 + (r102[1] * r104);
        double r111 = r110[2];
        double r106 = r105 + (r102[2] * r111);
        double[] r107 = r100[1];
        double r112 = ((r107[0] * r101) + (r107[1] * r104)) + (r107[2] * r111);
        double[] r108 = r100[2];
        double r109 = ((r101 * r108[0]) + (r104 * r108[1])) + (r111 * r108[2]);
        double r113 = chromaticAdaptation(r106);
        double r114 = chromaticAdaptation(r112);
        double r115 = chromaticAdaptation(r109);
        double r116 = (((r113 * 11.0d) + ((-12.0d) * r114)) + r115) / 11.0d;
        return Math.atan2(((r113 + r114) - (r115 * 2.0d)) / 9.0d, r116);
    }

    private final double inverseChromaticAdaptation(double r100) {
        double r101 = Math.abs(r100);
        double r102 = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, (27.13d * r101) / (400.0d - r101));
        return ((double) CamUtils.INSTANCE.signum(r100)) * Math.pow(r102, 2.380952380952381d);
    }

    private final double trueDelinearized(double r100) {
        double r101 = r100 / 100.0d;
        if (r101 > 0.0031308d) goto L5;
        double r102 = r101 * 12.92d;
    L7:
        return r102 * ((double) 255);
    L5:
        r102 = (Math.pow(r101, 0.4166666666666667d) * 1.055d) - 0.055d;
        goto L7
    }

    private final int bisectToLimit(double r210, double r211) {
        double[][] r100 = bisectToSegment(r210, r211);
        double[] r101 = r100[0];
        double r102 = hueOf(r101);
        double[] r103 = r100[1];
        int r110 = 0;
    L4:
        if (r110 >= 3) goto L27;
        double r104 = r101[r110];
        double r111 = r103[r110];
        if (r104 != r111) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L26;
        if (r104 >= r111) goto L13;
        int r106 = criticalPlaneBelow(trueDelinearized(r104));
        int r107 = criticalPlaneAbove(trueDelinearized(r103[r110]));
    L14:
        double[] r112 = r103;
        double[] r113 = r101;
        double r114 = r102;
        int r115 = r106;
        int r116 = r107;
        int r108 = 0;
    L16:
        if (r108 >= 8) goto L25;
        if (Math.abs(r116 - r115) <= 1.0d) goto L25;
        int r109 = (int) Math.floor(((double) (r115 + r116)) / 2.0d);
        double[] r117 = setCoordinate(r113, CRITICAL_PLANES[r109], r112, r110);
        double r118 = hueOf(r117);
        int r212 = r108;
        if (areInCyclicOrder(r114, r211, r118) == false) goto L23;
        r116 = r109;
        r112 = r117;
    L24:
        r108 = r212 + 1;
        goto L16
    L23:
        r115 = r109;
        r114 = r118;
        r113 = r117;
    L25:
        r103 = r112;
        r101 = r113;
        r102 = r114;
        goto L26
    L13:
        r106 = criticalPlaneAbove(trueDelinearized(r104));
        r107 = criticalPlaneBelow(trueDelinearized(r103[r110]));
    L26:
        r110 = r110 + 1;
        goto L4
    L8:
        r105 = false;
        goto L9
    L27:
        double r119 = 2;
        return CamUtils.INSTANCE.argbFromLinrgbComponents((r101[0] + r103[0]) / r119, (r101[1] + r103[1]) / r119, (r101[2] + r103[2]) / r119);
    }

    private final double[][] bisectToSegment(double r210, double r211) {
        double[] r110 = {-1.0d, -1.0d, -1.0d};
        double[] r111 = r110;
        double r112 = 0.0d;
        double r113 = 0.0d;
        int r114 = 0;
        boolean r115 = false;
        boolean r116 = true;
    L4:
        if (r114 >= 12) goto L23;
        double[] r100 = nthVertex(r210, r114);
        if (r100[0] < AudioStats.AUDIO_AMPLITUDE_NONE) goto L21;
        double r212 = hueOf(r100);
        if (r115 == true) goto L11;
        r110 = r100;
        r111 = r110;
        r112 = r212;
        r113 = r112;
        r115 = true;
        goto L21
    L11:
        if (r116 == true) goto L17;
        if (areInCyclicOrder(r112, r212, r113) == false) goto L21;
    L17:
        if (areInCyclicOrder(r112, r211, r212) == false) goto L19;
        r113 = r212;
        r111 = r100;
    L20:
        r116 = false;
        goto L21
    L19:
        r112 = r212;
        r110 = r100;
    L21:
        r114 = r114 + 1;
        goto L4
    L23:
        return new double[][]{r110, r111};
    }

    private final double[] nthVertex(double r110, int r210) {
        double[] r100 = Y_FROM_LINRGB;
        double r101 = r100[0];
        double r102 = r100[1];
        double r111 = r100[2];
        int r103 = r210 % 4;
        double r112 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r103 > 1) goto L5;
        double r113 = 0.0d;
    L7:
        if ((r210 % 2) == 0) goto L11;
        r112 = 100.0d;
    L11:
        if (r210 >= 4) goto L18;
        double r104 = ((r110 - (r102 * r113)) - (r111 * r112)) / r101;
        if (isBounded(r104) == false) goto L16;
        return new double[]{r104, r113, r112};
    L16:
        return new double[]{-1.0d, -1.0d, -1.0d};
    L18:
        if (r210 >= 8) goto L24;
        double r105 = ((r110 - (r101 * r112)) - (r111 * r113)) / r102;
        if (isBounded(r105) == false) goto L23;
        return new double[]{r112, r105, r113};
    L23:
        return new double[]{-1.0d, -1.0d, -1.0d};
    L24:
        double r106 = ((r110 - (r101 * r113)) - (r102 * r112)) / r111;
        if (isBounded(r106) == false) goto L28;
        return new double[]{r113, r112, r106};
    L28:
        return new double[]{-1.0d, -1.0d, -1.0d};
    L5:
        r113 = 100.0d;
        goto L7
    }

    private final boolean areInCyclicOrder(double r100, double r101, double r102) {
        if (sanitizeRadians(r101 - r100) >= sanitizeRadians(r102 - r100)) goto L5;
        return true;
    L5:
        return false;
    }

    private final int findResultByJ(double r310, double r410, double r411) {
        double r100 = Math.sqrt(r411) * 11.0d;
        Frame r101 = Frame.Companion.getDefault();
        double r102 = ((double) 1) / Math.pow(1.64d - Math.pow(0.29d, r101.getN()), 0.73d);
        double r103 = ((((Math.cos(r310 + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * ((double) r101.getNc())) * ((double) r101.getNcb());
        double r104 = Math.sin(r310);
        double r110 = Math.cos(r310);
        int r111 = 0;
    L4:
        if (r111 >= 5) goto L47;
        int r412 = r111;
        double r112 = r100 / 100.0d;
        if (r410 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        boolean r113 = true;
    L9:
        if (r113 == false) goto L11;
    L17:
        double r114 = 0.0d;
    L18:
        double r210 = r102;
        double r105 = Math.pow(r114 * r102, 1.1111111111111112d);
        double r211 = r104;
        double r106 = (((double) r101.getAw()) * Math.pow(r112, (1.0d / ((double) r101.getC())) / ((double) r101.getZ()))) / ((double) r101.getNbb());
        double r212 = r103;
        double r107 = (((0.305d + r106) * 23.0d) * r105) / (((23.0d * r103) + ((((double) 11) * r105) * r110)) + ((r105 * 108.0d) * r211));
        double r108 = r107 * r110;
        double r109 = r107 * r211;
        double r115 = r106 * 460.0d;
        double r116 = (((451.0d * r108) + r115) + (288.0d * r109)) / 1403.0d;
        double r213 = (r115 - (891.0d * r108)) - (261.0d * r109);
        double r214 = r110;
        double r117 = ((r115 - (r108 * 220.0d)) - (r109 * 6300.0d)) / 1403.0d;
        double r118 = inverseChromaticAdaptation(r116);
        double r119 = inverseChromaticAdaptation(r213 / 1403.0d);
        double r120 = inverseChromaticAdaptation(r117);
        double[][] r121 = LINRGB_FROM_SCALED_DISCOUNT;
        double[] r122 = r121[0];
        double r311 = ((r122[0] * r118) + (r122[1] * r119)) + (r122[2] * r120);
        double[] r123 = r121[1];
        double r312 = ((r123[0] * r118) + (r123[1] * r119)) + (r123[2] * r120);
        double[] r124 = r121[2];
        double r313 = ((r118 * r124[0]) + (r119 * r124[1])) + (r120 * r124[2]);
        if (r311 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L45;
        if (r312 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L58;
        if (r313 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L59;
        double[] r125 = Y_FROM_LINRGB;
        double r126 = ((r125[0] * r311) + (r125[1] * r312)) + (r125[2] * r313);
        if (r126 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L27;
        if (r412 == 4) goto L35;
        double r127 = r126 - r411;
        if (Math.abs(r127) < 0.002d) goto L35;
        r100 = r100 - ((r127 * r100) / (((double) 2) * r126));
        r111 = r412 + 1;
        r102 = r210;
        r104 = r211;
        r103 = r212;
        r110 = r214;
    L35:
        if (r311 <= 100.01d) goto L37;
        return 0;
    L37:
        if (r312 <= 100.01d) goto L39;
        return 0;
    L39:
        if (r313 <= 100.01d) goto L42;
        return 0;
    L42:
        return CamUtils.INSTANCE.argbFromLinrgbComponents(r311, r312, r313);
    L27:
        return 0;
    L59:
        return 0;
    L58:
        return 0;
    L45:
        return 0;
    L11:
        if (r100 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        boolean r128 = true;
    L14:
        if (r128 == true) goto L17;
        r114 = r410 / Math.sqrt(r112);
        goto L18
    L13:
        r128 = false;
        goto L14
    L8:
        r113 = false;
        goto L9
    L47:
        return 0;
    }

    private final double[] lerpPoint(double[] r100, double r101, double[] r110) {
        double r102 = r100[0];
        double r103 = r100[1];
        double r104 = r100[2];
        return new double[]{r102 + ((r110[0] - r102) * r101), r103 + ((r110[1] - r103) * r101), r104 + ((r110[2] - r104) * r101)};
    }

    public final int solveToInt(double r100, double r110, double r111) {
        if (r110 < 1.0E-4d) goto L15;
        if (r111 < 1.0E-4d) goto L15;
        if (r111 > 99.9999d) goto L15;
        double r101 = Math.toRadians(sanitizeDegreesDouble(r100));
        double r112 = CamUtils.INSTANCE.yFromLstar(r111);
        int r113 = findResultByJ(r101, r110, r112);
        if (r113 == 0) goto L13;
        return r113;
    L13:
        return bisectToLimit(r112, r101);
    L15:
        return CamUtils.INSTANCE.argbFromLstar(r111);
    }

    private final double[] setCoordinate(double[] r100, double r101, double[] r110, int r111) {
        return lerpPoint(r100, intercept(r100[r111], r101, r110[r111]), r110);
    }
}
