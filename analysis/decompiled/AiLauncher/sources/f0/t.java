package f0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h0.C4118a;
import h0.DeltaCounter;
import java.util.Arrays;
import kotlin.Metadata;
import v9.C5678g;
import v9.C5685n;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b)\b\u0001\u0018\u0000 ]*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0002\u000f{B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB)\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\u0004\b\u000b\u0010\rJ\u001b\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J3\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ;\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010 J+\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0002\u0010!J?\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00028\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"H\u0002¢\u0006\u0004\b$\u0010%J?\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b(\u0010)J?\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010&\u001a\u00020\u00042\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b*\u0010+J-\u0010,\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010-J5\u0010.\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b.\u0010/JQ\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00072\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u00012\u0006\u00103\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b4\u00105JK\u00106\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u00012\u0006\u00103\u001a\u00020\u0004H\u0002¢\u0006\u0004\b6\u00107JS\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u00012\u0006\u00103\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b8\u00109J]\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00028\u00002\u0006\u0010<\u001a\u00028\u00012\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010?\u001a\u00028\u00012\u0006\u00103\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b@\u0010AJ-\u0010B\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\bB\u0010-JA\u0010C\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"H\u0002¢\u0006\u0004\bC\u0010DJ%\u0010F\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010E\u001a\u00020\u0004H\u0002¢\u0006\u0004\bF\u0010GJ9\u0010H\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010E\u001a\u00020\u00042\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"H\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0004\bJ\u0010KJ\u0019\u0010L\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0004\bL\u0010MJ-\u0010N\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H\u0002¢\u0006\u0004\bN\u0010OJ?\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"H\u0002¢\u0006\u0004\bP\u0010QJ%\u0010E\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0004\bE\u0010RJ9\u0010S\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00028\u00002\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"H\u0002¢\u0006\u0004\bS\u0010TJA\u0010U\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"H\u0002¢\u0006\u0004\bU\u0010QJ?\u0010Y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010X\u001a\u00020W2\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\bY\u0010ZJ[\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u0010X\u001a\u00020W2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"H\u0002¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0004H\u0002¢\u0006\u0004\b]\u0010^J#\u0010_\u001a\u00020\u00132\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b_\u0010`JW\u0010b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\bb\u0010cJ_\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0001\u0010dJ\u000f\u0010e\u001a\u00020\u0004H\u0000¢\u0006\u0004\be\u0010^J\u0017\u0010f\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0004\bf\u0010\u0015J\u0017\u0010g\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0004\bi\u0010hJ#\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010&\u001a\u00020\u0004H\u0000¢\u0006\u0004\bj\u0010GJ%\u0010l\u001a\u00020\u00132\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00103\u001a\u00020\u0004¢\u0006\u0004\bl\u0010mJ'\u0010n\u001a\u0004\u0018\u00018\u00012\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00103\u001a\u00020\u0004¢\u0006\u0004\bn\u0010oJQ\u0010p\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00103\u001a\u00020\u00042\u0006\u0010X\u001a\u00020W2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"¢\u0006\u0004\bp\u0010qJ;\u0010r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e2\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0006\u00103\u001a\u00020\u0004¢\u0006\u0004\br\u0010sJM\u0010t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0006\u00103\u001a\u00020\u00042\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"¢\u0006\u0004\bt\u0010uJ3\u0010v\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00103\u001a\u00020\u0004¢\u0006\u0004\bv\u0010wJG\u0010x\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00103\u001a\u00020\u00042\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"¢\u0006\u0004\bx\u0010yJO\u0010z\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0006\u00103\u001a\u00020\u00042\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"¢\u0006\u0004\bz\u0010uR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010CR\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010CR\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010|R4\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00072\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00078\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b4\u0010}\u001a\u0004\b~\u0010\u007f¨\u0006\u0080\u0001"}, d2 = {"Lf0/t;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "dataMap", "nodeMap", "", "buffer", "Lh0/e;", "ownedBy", "<init>", "(II[Ljava/lang/Object;Lh0/e;)V", "(II[Ljava/lang/Object;)V", "Lf0/t$b;", Const.INTENT_KEY_PKGNAME, "()Lf0/t$b;", "c", "positionMask", "", "r", "(I)Z", "keyIndex", "t", "(I)Ljava/lang/Object;", ExifInterface.LONGITUDE_WEST, "key", UxipConstants.f30680s, "s", "(ILjava/lang/Object;Ljava/lang/Object;)Lf0/t;", "owner", "B", "(ILjava/lang/Object;Ljava/lang/Object;Lh0/e;)Lf0/t;", "(ILjava/lang/Object;)Lf0/t;", "Lf0/f;", "mutator", "M", "(ILjava/lang/Object;Lf0/f;)Lf0/t;", "nodeIndex", "newNode", "U", "(IILf0/t;)Lf0/t;", "L", "(ILf0/t;Lh0/e;)Lf0/t;", ExifInterface.LATITUDE_SOUTH, "(II)Lf0/t;", "J", "(IILh0/e;)Lf0/t;", "newKeyHash", "newKey", "newValue", "shift", Const.INTENT_KEY_UMID, "(IIILjava/lang/Object;Ljava/lang/Object;ILh0/e;)[Ljava/lang/Object;", "v", "(IIILjava/lang/Object;Ljava/lang/Object;I)Lf0/t;", "C", "(IIILjava/lang/Object;Ljava/lang/Object;ILh0/e;)Lf0/t;", "keyHash1", "key1", "value1", "keyHash2", "key2", "value2", "u", "(ILjava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;ILh0/e;)Lf0/t;", "R", "I", "(IILf0/f;)Lf0/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)Lf0/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(ILf0/f;)Lf0/t;", "f", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Object;Ljava/lang/Object;)Lf0/t$b;", "w", "(Ljava/lang/Object;Ljava/lang/Object;Lf0/f;)Lf0/t;", "(Ljava/lang/Object;)Lf0/t;", "y", "(Ljava/lang/Object;Lf0/f;)Lf0/t;", "z", "otherNode", "Lh0/b;", "intersectionCounter", "x", "(Lf0/t;Lh0/b;Lh0/e;)Lf0/t;", "F", "(Lf0/t;IILh0/b;Lf0/f;)Lf0/t;", "e", "()I", "l", "(Lf0/t;)Z", "targetNode", ExifInterface.GPS_DIRECTION_TRUE, "(Lf0/t;Lf0/t;II)Lf0/t;", "(Lf0/t;Lf0/t;IILh0/e;)Lf0/t;", "m", "q", "n", "(I)I", "O", "N", "keyHash", "k", "(ILjava/lang/Object;I)Z", "o", "(ILjava/lang/Object;I)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "(Lf0/t;ILh0/b;Lf0/f;)Lf0/t;", "P", "(ILjava/lang/Object;Ljava/lang/Object;I)Lf0/t$b;", "D", "(ILjava/lang/Object;Ljava/lang/Object;ILf0/f;)Lf0/t;", "Q", "(ILjava/lang/Object;I)Lf0/t;", "G", "(ILjava/lang/Object;ILf0/f;)Lf0/t;", "H", Const.INTENT_KEY_APIKEY, "Lh0/e;", "[Ljava/lang/Object;", "p", "()[Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class t<K, V> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final int f32487f = 8;

    /* renamed from: g, reason: collision with root package name */
    public static final t f32488g = new t(0, 0, new Object[0]);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int dataMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int nodeMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final h0.e ownedBy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Object[] buffer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lf0/t$a;", "", "<init>", "()V", "Lf0/t;", "", "EMPTY", "Lf0/t;", Const.INTENT_KEY_APIKEY, "()Lf0/t;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: f0.t$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final t a() {
            return t.f32488g;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR.\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lf0/t$b;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lf0/t;", "node", "", "sizeDelta", "<init>", "(Lf0/t;I)V", Const.INTENT_KEY_APIKEY, "Lf0/t;", "()Lf0/t;", "c", "(Lf0/t;)V", Const.INTENT_KEY_PKGNAME, "I", "()I", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b<K, V> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public t<K, V> node;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int sizeDelta;

        public b(t<K, V> tVar, int i10) {
            this.node = tVar;
            this.sizeDelta = i10;
        }

        public final t<K, V> a() {
            return this.node;
        }

        /* renamed from: b, reason: from getter */
        public final int getSizeDelta() {
            return this.sizeDelta;
        }

        public final void c(t<K, V> tVar) {
            this.node = tVar;
        }
    }

    public t(int i10, int i11, Object[] objArr, h0.e eVar) {
        this.dataMap = i10;
        this.nodeMap = i11;
        this.ownedBy = eVar;
        this.buffer = objArr;
    }

    public final t<K, V> A(int i10, f<K, V> mutator) {
        mutator.p(mutator.size() - 1);
        mutator.o(W(i10));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy != mutator.getOwnership()) {
            return new t<>(0, 0, x.h(this.buffer, i10), mutator.getOwnership());
        }
        this.buffer = x.h(this.buffer, i10);
        return this;
    }

    public final t<K, V> B(int positionMask, K key, V value, h0.e owner) {
        int iN = n(positionMask);
        if (this.ownedBy != owner) {
            return new t<>(positionMask | this.dataMap, this.nodeMap, x.g(this.buffer, iN, key, value), owner);
        }
        this.buffer = x.g(this.buffer, iN, key, value);
        this.dataMap = positionMask | this.dataMap;
        return this;
    }

    public final t<K, V> C(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift, h0.e owner) {
        if (this.ownedBy != owner) {
            return new t<>(this.dataMap ^ positionMask, this.nodeMap | positionMask, d(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, owner), owner);
        }
        this.buffer = d(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, owner);
        this.dataMap ^= positionMask;
        this.nodeMap |= positionMask;
        return this;
    }

    public final t<K, V> D(int keyHash, K key, V value, int shift, f<K, V> mutator) {
        int iF = 1 << x.f(keyHash, shift);
        if (q(iF)) {
            int iN = n(iF);
            if (kotlin.jvm.internal.p.d(key, t(iN))) {
                mutator.o(W(iN));
                return W(iN) == value ? this : M(iN, value, mutator);
            }
            mutator.p(mutator.size() + 1);
            return C(iN, iF, keyHash, key, value, shift, mutator.getOwnership());
        }
        if (!r(iF)) {
            mutator.p(mutator.size() + 1);
            return B(iF, key, value, mutator.getOwnership());
        }
        int iO = O(iF);
        t<K, V> tVarN = N(iO);
        t<K, V> tVarW = shift == 30 ? tVarN.w(key, value, mutator) : tVarN.D(keyHash, key, value, shift + 5, mutator);
        return tVarN == tVarW ? this : L(iO, tVarW, mutator.getOwnership());
    }

    public final t<K, V> E(t<K, V> otherNode, int shift, DeltaCounter intersectionCounter, f<K, V> mutator) {
        if (this == otherNode) {
            intersectionCounter.b(e());
            return this;
        }
        int i10 = shift;
        if (i10 > 30) {
            return x(otherNode, intersectionCounter, mutator.getOwnership());
        }
        int i11 = this.nodeMap | otherNode.nodeMap;
        int i12 = this.dataMap;
        int i13 = otherNode.dataMap;
        int i14 = (i12 ^ i13) & (~i11);
        int i15 = i12 & i13;
        while (i15 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i15);
            if (kotlin.jvm.internal.p.d(t(n(iLowestOneBit)), otherNode.t(otherNode.n(iLowestOneBit)))) {
                i14 |= iLowestOneBit;
            } else {
                i11 |= iLowestOneBit;
            }
            i15 ^= iLowestOneBit;
        }
        int i16 = 0;
        if (!((i11 & i14) == 0)) {
            androidx.compose.runtime.f.b("Check failed.");
        }
        t<K, V> tVar = (kotlin.jvm.internal.p.d(this.ownedBy, mutator.getOwnership()) && this.dataMap == i14 && this.nodeMap == i11) ? this : new t<>(i14, i11, new Object[(Integer.bitCount(i14) * 2) + Integer.bitCount(i11)]);
        int i17 = i11;
        int i18 = 0;
        while (i17 != 0) {
            int iLowestOneBit2 = Integer.lowestOneBit(i17);
            Object[] objArr = tVar.buffer;
            objArr[(objArr.length - 1) - i18] = F(otherNode, iLowestOneBit2, i10, intersectionCounter, mutator);
            i18++;
            i17 ^= iLowestOneBit2;
            i10 = shift;
        }
        while (i14 != 0) {
            int iLowestOneBit3 = Integer.lowestOneBit(i14);
            int i19 = i16 * 2;
            if (otherNode.q(iLowestOneBit3)) {
                int iN = otherNode.n(iLowestOneBit3);
                tVar.buffer[i19] = otherNode.t(iN);
                tVar.buffer[i19 + 1] = otherNode.W(iN);
                if (q(iLowestOneBit3)) {
                    intersectionCounter.c(intersectionCounter.getCount() + 1);
                }
            } else {
                int iN2 = n(iLowestOneBit3);
                tVar.buffer[i19] = t(iN2);
                tVar.buffer[i19 + 1] = W(iN2);
            }
            i16++;
            i14 ^= iLowestOneBit3;
        }
        return l(tVar) ? this : otherNode.l(tVar) ? otherNode : tVar;
    }

    public final t<K, V> F(t<K, V> otherNode, int positionMask, int shift, DeltaCounter intersectionCounter, f<K, V> mutator) {
        if (r(positionMask)) {
            t<K, V> tVarN = N(O(positionMask));
            if (otherNode.r(positionMask)) {
                return tVarN.E(otherNode.N(otherNode.O(positionMask)), shift + 5, intersectionCounter, mutator);
            }
            if (!otherNode.q(positionMask)) {
                return tVarN;
            }
            int iN = otherNode.n(positionMask);
            K kT = otherNode.t(iN);
            V vW = otherNode.W(iN);
            int size = mutator.size();
            t<K, V> tVarD = tVarN.D(kT != null ? kT.hashCode() : 0, kT, vW, shift + 5, mutator);
            if (mutator.size() == size) {
                intersectionCounter.c(intersectionCounter.getCount() + 1);
            }
            return tVarD;
        }
        if (!otherNode.r(positionMask)) {
            int iN2 = n(positionMask);
            K kT2 = t(iN2);
            V vW2 = W(iN2);
            int iN3 = otherNode.n(positionMask);
            K kT3 = otherNode.t(iN3);
            return u(kT2 != null ? kT2.hashCode() : 0, kT2, vW2, kT3 != null ? kT3.hashCode() : 0, kT3, otherNode.W(iN3), shift + 5, mutator.getOwnership());
        }
        t<K, V> tVarN2 = otherNode.N(otherNode.O(positionMask));
        if (!q(positionMask)) {
            return tVarN2;
        }
        int iN4 = n(positionMask);
        K kT4 = t(iN4);
        int i10 = shift + 5;
        if (!tVarN2.k(kT4 != null ? kT4.hashCode() : 0, kT4, i10)) {
            return tVarN2.D(kT4 != null ? kT4.hashCode() : 0, kT4, W(iN4), i10, mutator);
        }
        intersectionCounter.c(intersectionCounter.getCount() + 1);
        return tVarN2;
    }

    public final t<K, V> G(int keyHash, K key, int shift, f<K, V> mutator) {
        int iF = 1 << x.f(keyHash, shift);
        if (q(iF)) {
            int iN = n(iF);
            if (kotlin.jvm.internal.p.d(key, t(iN))) {
                return I(iN, iF, mutator);
            }
        } else if (r(iF)) {
            int iO = O(iF);
            t<K, V> tVarN = N(iO);
            return K(tVarN, shift == 30 ? tVarN.y(key, mutator) : tVarN.G(keyHash, key, shift + 5, mutator), iO, iF, mutator.getOwnership());
        }
        return this;
    }

    public final t<K, V> H(int keyHash, K key, V value, int shift, f<K, V> mutator) {
        f<K, V> fVar;
        t<K, V> tVarH;
        int iF = 1 << x.f(keyHash, shift);
        if (q(iF)) {
            int iN = n(iF);
            return (kotlin.jvm.internal.p.d(key, t(iN)) && kotlin.jvm.internal.p.d(value, W(iN))) ? I(iN, iF, mutator) : this;
        }
        if (!r(iF)) {
            return this;
        }
        int iO = O(iF);
        t<K, V> tVarN = N(iO);
        if (shift == 30) {
            tVarH = tVarN.z(key, value, mutator);
            fVar = mutator;
        } else {
            fVar = mutator;
            tVarH = tVarN.H(keyHash, key, value, shift + 5, fVar);
        }
        return K(tVarN, tVarH, iO, iF, fVar.getOwnership());
    }

    public final t<K, V> I(int keyIndex, int positionMask, f<K, V> mutator) {
        mutator.p(mutator.size() - 1);
        mutator.o(W(keyIndex));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy != mutator.getOwnership()) {
            return new t<>(positionMask ^ this.dataMap, this.nodeMap, x.h(this.buffer, keyIndex), mutator.getOwnership());
        }
        this.buffer = x.h(this.buffer, keyIndex);
        this.dataMap ^= positionMask;
        return this;
    }

    public final t<K, V> J(int nodeIndex, int positionMask, h0.e owner) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        if (this.ownedBy != owner) {
            return new t<>(this.dataMap, this.nodeMap ^ positionMask, x.i(objArr, nodeIndex), owner);
        }
        this.buffer = x.i(objArr, nodeIndex);
        this.nodeMap ^= positionMask;
        return this;
    }

    public final t<K, V> K(t<K, V> targetNode, t<K, V> newNode, int nodeIndex, int positionMask, h0.e owner) {
        return newNode == null ? J(nodeIndex, positionMask, owner) : (this.ownedBy == owner || targetNode != newNode) ? L(nodeIndex, newNode, owner) : this;
    }

    public final t<K, V> L(int nodeIndex, t<K, V> newNode, h0.e owner) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1 && newNode.buffer.length == 2 && newNode.nodeMap == 0) {
            newNode.dataMap = this.nodeMap;
            return newNode;
        }
        if (this.ownedBy == owner) {
            objArr[nodeIndex] = newNode;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[nodeIndex] = newNode;
        return new t<>(this.dataMap, this.nodeMap, objArrCopyOf, owner);
    }

    public final t<K, V> M(int keyIndex, V value, f<K, V> mutator) {
        if (this.ownedBy == mutator.getOwnership()) {
            this.buffer[keyIndex + 1] = value;
            return this;
        }
        mutator.n(mutator.getModCount() + 1);
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[keyIndex + 1] = value;
        return new t<>(this.dataMap, this.nodeMap, objArrCopyOf, mutator.getOwnership());
    }

    public final t<K, V> N(int nodeIndex) {
        Object obj = this.buffer[nodeIndex];
        kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (t) obj;
    }

    public final int O(int positionMask) {
        return (this.buffer.length - 1) - Integer.bitCount(this.nodeMap & (positionMask - 1));
    }

    public final b<K, V> P(int keyHash, K key, V value, int shift) {
        b<K, V> bVarP;
        int iF = 1 << x.f(keyHash, shift);
        if (q(iF)) {
            int iN = n(iF);
            if (!kotlin.jvm.internal.p.d(key, t(iN))) {
                return v(iN, iF, keyHash, key, value, shift).b();
            }
            if (W(iN) == value) {
                return null;
            }
            return V(iN, value).c();
        }
        if (!r(iF)) {
            return s(iF, key, value).b();
        }
        int iO = O(iF);
        t<K, V> tVarN = N(iO);
        if (shift == 30) {
            bVarP = tVarN.h(key, value);
            if (bVarP == null) {
                return null;
            }
        } else {
            bVarP = tVarN.P(keyHash, key, value, shift + 5);
            if (bVarP == null) {
                return null;
            }
        }
        bVarP.c(U(iO, iF, bVarP.a()));
        return bVarP;
    }

    public final t<K, V> Q(int keyHash, K key, int shift) {
        int iF = 1 << x.f(keyHash, shift);
        if (q(iF)) {
            int iN = n(iF);
            return kotlin.jvm.internal.p.d(key, t(iN)) ? R(iN, iF) : this;
        }
        if (!r(iF)) {
            return this;
        }
        int iO = O(iF);
        t<K, V> tVarN = N(iO);
        return T(tVarN, shift == 30 ? tVarN.i(key) : tVarN.Q(keyHash, key, shift + 5), iO, iF);
    }

    public final t<K, V> R(int keyIndex, int positionMask) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new t<>(positionMask ^ this.dataMap, this.nodeMap, x.h(objArr, keyIndex));
    }

    public final t<K, V> S(int nodeIndex, int positionMask) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        return new t<>(this.dataMap, this.nodeMap ^ positionMask, x.i(objArr, nodeIndex));
    }

    public final t<K, V> T(t<K, V> targetNode, t<K, V> newNode, int nodeIndex, int positionMask) {
        return newNode == null ? S(nodeIndex, positionMask) : targetNode != newNode ? U(nodeIndex, positionMask, newNode) : this;
    }

    public final t<K, V> U(int nodeIndex, int positionMask, t<K, V> newNode) {
        Object[] objArr = newNode.buffer;
        if (objArr.length != 2 || newNode.nodeMap != 0) {
            Object[] objArr2 = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[nodeIndex] = newNode;
            return new t<>(this.dataMap, this.nodeMap, objArrCopyOf);
        }
        if (this.buffer.length == 1) {
            newNode.dataMap = this.nodeMap;
            return newNode;
        }
        return new t<>(this.dataMap ^ positionMask, this.nodeMap ^ positionMask, x.k(this.buffer, nodeIndex, n(positionMask), objArr[0], objArr[1]));
    }

    public final t<K, V> V(int keyIndex, V value) {
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[keyIndex + 1] = value;
        return new t<>(this.dataMap, this.nodeMap, objArrCopyOf);
    }

    public final V W(int keyIndex) {
        return (V) this.buffer[keyIndex + 1];
    }

    public final b<K, V> b() {
        return new b<>(this, 1);
    }

    public final b<K, V> c() {
        return new b<>(this, 0);
    }

    public final Object[] d(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift, h0.e owner) {
        K kT = t(keyIndex);
        return x.j(this.buffer, keyIndex, O(positionMask) + 1, u(kT != null ? kT.hashCode() : 0, kT, W(keyIndex), newKeyHash, newKey, newValue, shift + 5, owner));
    }

    public final int e() {
        if (this.nodeMap == 0) {
            return this.buffer.length / 2;
        }
        int iBitCount = Integer.bitCount(this.dataMap);
        int length = this.buffer.length;
        for (int i10 = iBitCount * 2; i10 < length; i10++) {
            iBitCount += N(i10).e();
        }
        return iBitCount;
    }

    public final boolean f(K key) {
        C5678g c5678gR = C5685n.r(C5685n.s(0, this.buffer.length), 2);
        int iB = c5678gR.getFirst();
        int iC = c5678gR.getLast();
        int iE = c5678gR.getStep();
        if ((iE > 0 && iB <= iC) || (iE < 0 && iC <= iB)) {
            while (!kotlin.jvm.internal.p.d(key, this.buffer[iB])) {
                if (iB != iC) {
                    iB += iE;
                }
            }
            return true;
        }
        return false;
    }

    public final V g(K key) {
        C5678g c5678gR = C5685n.r(C5685n.s(0, this.buffer.length), 2);
        int iB = c5678gR.getFirst();
        int iC = c5678gR.getLast();
        int iE = c5678gR.getStep();
        if ((iE <= 0 || iB > iC) && (iE >= 0 || iC > iB)) {
            return null;
        }
        while (!kotlin.jvm.internal.p.d(key, t(iB))) {
            if (iB == iC) {
                return null;
            }
            iB += iE;
        }
        return W(iB);
    }

    public final b<K, V> h(K key, V value) {
        C5678g c5678gR = C5685n.r(C5685n.s(0, this.buffer.length), 2);
        int iB = c5678gR.getFirst();
        int iC = c5678gR.getLast();
        int iE = c5678gR.getStep();
        if ((iE > 0 && iB <= iC) || (iE < 0 && iC <= iB)) {
            while (!kotlin.jvm.internal.p.d(key, t(iB))) {
                if (iB != iC) {
                    iB += iE;
                }
            }
            if (value == W(iB)) {
                return null;
            }
            Object[] objArr = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[iB + 1] = value;
            return new t(0, 0, objArrCopyOf).c();
        }
        return new t(0, 0, x.g(this.buffer, 0, key, value)).b();
    }

    public final t<K, V> i(K key) {
        C5678g c5678gR = C5685n.r(C5685n.s(0, this.buffer.length), 2);
        int iB = c5678gR.getFirst();
        int iC = c5678gR.getLast();
        int iE = c5678gR.getStep();
        if ((iE > 0 && iB <= iC) || (iE < 0 && iC <= iB)) {
            while (!kotlin.jvm.internal.p.d(key, t(iB))) {
                if (iB != iC) {
                    iB += iE;
                }
            }
            return j(iB);
        }
        return this;
    }

    public final t<K, V> j(int i10) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new t<>(0, 0, x.h(objArr, i10));
    }

    public final boolean k(int keyHash, K key, int shift) {
        int iF = 1 << x.f(keyHash, shift);
        if (q(iF)) {
            return kotlin.jvm.internal.p.d(key, t(n(iF)));
        }
        if (!r(iF)) {
            return false;
        }
        t<K, V> tVarN = N(O(iF));
        return shift == 30 ? tVarN.f(key) : tVarN.k(keyHash, key, shift + 5);
    }

    public final boolean l(t<K, V> otherNode) {
        if (this == otherNode) {
            return true;
        }
        if (this.nodeMap != otherNode.nodeMap || this.dataMap != otherNode.dataMap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (this.buffer[i10] != otherNode.buffer[i10]) {
                return false;
            }
        }
        return true;
    }

    public final int m() {
        return Integer.bitCount(this.dataMap);
    }

    public final int n(int positionMask) {
        return Integer.bitCount(this.dataMap & (positionMask - 1)) * 2;
    }

    public final V o(int keyHash, K key, int shift) {
        int iF = 1 << x.f(keyHash, shift);
        if (q(iF)) {
            int iN = n(iF);
            if (kotlin.jvm.internal.p.d(key, t(iN))) {
                return W(iN);
            }
            return null;
        }
        if (!r(iF)) {
            return null;
        }
        t<K, V> tVarN = N(O(iF));
        return shift == 30 ? tVarN.g(key) : tVarN.o(keyHash, key, shift + 5);
    }

    /* renamed from: p, reason: from getter */
    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final boolean q(int positionMask) {
        return (this.dataMap & positionMask) != 0;
    }

    public final boolean r(int positionMask) {
        return (this.nodeMap & positionMask) != 0;
    }

    public final t<K, V> s(int positionMask, K key, V value) {
        return new t<>(positionMask | this.dataMap, this.nodeMap, x.g(this.buffer, n(positionMask), key, value));
    }

    public final K t(int keyIndex) {
        return (K) this.buffer[keyIndex];
    }

    public final t<K, V> u(int keyHash1, K key1, V value1, int keyHash2, K key2, V value2, int shift, h0.e owner) {
        if (shift > 30) {
            return new t<>(0, 0, new Object[]{key1, value1, key2, value2}, owner);
        }
        int iF = x.f(keyHash1, shift);
        int iF2 = x.f(keyHash2, shift);
        if (iF != iF2) {
            return new t<>((1 << iF) | (1 << iF2), 0, iF < iF2 ? new Object[]{key1, value1, key2, value2} : new Object[]{key2, value2, key1, value1}, owner);
        }
        return new t<>(0, 1 << iF, new Object[]{u(keyHash1, key1, value1, keyHash2, key2, value2, shift + 5, owner)}, owner);
    }

    public final t<K, V> v(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift) {
        return new t<>(this.dataMap ^ positionMask, this.nodeMap | positionMask, d(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, null));
    }

    public final t<K, V> w(K key, V value, f<K, V> mutator) {
        C5678g c5678gR = C5685n.r(C5685n.s(0, this.buffer.length), 2);
        int iB = c5678gR.getFirst();
        int iC = c5678gR.getLast();
        int iE = c5678gR.getStep();
        if ((iE > 0 && iB <= iC) || (iE < 0 && iC <= iB)) {
            while (!kotlin.jvm.internal.p.d(key, t(iB))) {
                if (iB != iC) {
                    iB += iE;
                }
            }
            mutator.o(W(iB));
            if (this.ownedBy == mutator.getOwnership()) {
                this.buffer[iB + 1] = value;
                return this;
            }
            mutator.n(mutator.getModCount() + 1);
            Object[] objArr = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[iB + 1] = value;
            return new t<>(0, 0, objArrCopyOf, mutator.getOwnership());
        }
        mutator.p(mutator.size() + 1);
        return new t<>(0, 0, x.g(this.buffer, 0, key, value), mutator.getOwnership());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<K, V> x(t<K, V> otherNode, DeltaCounter intersectionCounter, h0.e owner) {
        C4118a.a(this.nodeMap == 0);
        C4118a.a(this.dataMap == 0);
        C4118a.a(otherNode.nodeMap == 0);
        C4118a.a(otherNode.dataMap == 0);
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + otherNode.buffer.length);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        int length = this.buffer.length;
        C5678g c5678gR = C5685n.r(C5685n.s(0, otherNode.buffer.length), 2);
        int iB = c5678gR.getFirst();
        int iC = c5678gR.getLast();
        int iE = c5678gR.getStep();
        if ((iE > 0 && iB <= iC) || (iE < 0 && iC <= iB)) {
            while (true) {
                if (f(otherNode.buffer[iB])) {
                    intersectionCounter.c(intersectionCounter.getCount() + 1);
                } else {
                    Object[] objArr2 = otherNode.buffer;
                    objArrCopyOf[length] = objArr2[iB];
                    objArrCopyOf[length + 1] = objArr2[iB + 1];
                    length += 2;
                }
                if (iB == iC) {
                    break;
                }
                iB += iE;
            }
        }
        if (length == this.buffer.length) {
            return this;
        }
        if (length == otherNode.buffer.length) {
            return otherNode;
        }
        if (length == objArrCopyOf.length) {
            return new t<>(0, 0, objArrCopyOf, owner);
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, length);
        kotlin.jvm.internal.p.h(objArrCopyOf2, "copyOf(...)");
        return new t<>(0, 0, objArrCopyOf2, owner);
    }

    public final t<K, V> y(K key, f<K, V> mutator) {
        C5678g c5678gR = C5685n.r(C5685n.s(0, this.buffer.length), 2);
        int iB = c5678gR.getFirst();
        int iC = c5678gR.getLast();
        int iE = c5678gR.getStep();
        if ((iE > 0 && iB <= iC) || (iE < 0 && iC <= iB)) {
            while (!kotlin.jvm.internal.p.d(key, t(iB))) {
                if (iB != iC) {
                    iB += iE;
                }
            }
            return A(iB, mutator);
        }
        return this;
    }

    public final t<K, V> z(K key, V value, f<K, V> mutator) {
        C5678g c5678gR = C5685n.r(C5685n.s(0, this.buffer.length), 2);
        int iB = c5678gR.getFirst();
        int iC = c5678gR.getLast();
        int iE = c5678gR.getStep();
        if ((iE > 0 && iB <= iC) || (iE < 0 && iC <= iB)) {
            while (true) {
                if (!kotlin.jvm.internal.p.d(key, t(iB)) || !kotlin.jvm.internal.p.d(value, W(iB))) {
                    if (iB == iC) {
                        break;
                    }
                    iB += iE;
                } else {
                    return A(iB, mutator);
                }
            }
        }
        return this;
    }

    public t(int i10, int i11, Object[] objArr) {
        this(i10, i11, objArr, null);
    }
}
