package Qa;

import Ta.DeltaCounter;
import Z8.M;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import v9.C5678g;
import v9.C5685n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \\*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0003\u000f\u0082\u0001B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB)\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\u0004\b\u000b\u0010\rJ\u001b\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J3\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ;\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010 J+\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00028\u0001H\u0002¢\u0006\u0004\b!\u0010\"J?\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00028\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0002¢\u0006\u0004\b%\u0010&JK\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0002\u0010)J-\u0010*\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010+J5\u0010,\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b,\u0010-JQ\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00072\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u00028\u00012\u0006\u00101\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b2\u00103JK\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u00028\u00012\u0006\u00101\u001a\u00020\u0004H\u0002¢\u0006\u0004\b4\u00105JS\u00106\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u00028\u00012\u0006\u00101\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b6\u00107J]\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00028\u00002\u0006\u0010:\u001a\u00028\u00012\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00028\u00012\u0006\u00101\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b>\u0010?J-\u0010@\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b@\u0010+JA\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0002¢\u0006\u0004\b\u0001\u0010AJ%\u0010C\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010B\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u0010DJ9\u0010E\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010B\u001a\u00020\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0002¢\u0006\u0004\bE\u0010FJ\u0019\u0010G\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0004\bI\u0010JJ\u0019\u0010K\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0004\bK\u0010LJ-\u0010B\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H\u0002¢\u0006\u0004\bB\u0010MJ?\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0002¢\u0006\u0004\bN\u0010OJ%\u0010P\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0004\bP\u0010QJ9\u0010R\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00028\u00002\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0002¢\u0006\u0004\bR\u0010SJA\u0010T\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0002¢\u0006\u0004\bT\u0010OJ?\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010W\u001a\u00020V2\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\bX\u0010YJ[\u0010Z\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u0010W\u001a\u00020V2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0002¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\\\u0010]J#\u0010^\u001a\u00020\u00132\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b^\u0010_JW\u0010a\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\ba\u0010bJK\u0010c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\u0004H\u0000¢\u0006\u0004\be\u0010]J\u0017\u0010f\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0004\bf\u0010\u0015J\u0017\u0010g\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0004\bi\u0010hJ#\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010'\u001a\u00020\u0004H\u0000¢\u0006\u0004\bj\u0010DJ%\u0010l\u001a\u00020\u00132\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0004¢\u0006\u0004\bl\u0010mJ'\u0010n\u001a\u0004\u0018\u00018\u00012\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0004¢\u0006\u0004\bn\u0010oJQ\u0010p\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00101\u001a\u00020\u00042\u0006\u0010W\u001a\u00020V2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#¢\u0006\u0004\bp\u0010qJ;\u0010r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e2\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0006\u00101\u001a\u00020\u0004¢\u0006\u0004\br\u0010sJM\u0010t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0006\u00101\u001a\u00020\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#¢\u0006\u0004\bt\u0010uJ3\u0010v\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0004¢\u0006\u0004\bv\u0010wJG\u0010x\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#¢\u0006\u0004\bx\u0010yJO\u0010z\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010k\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00012\u0006\u00101\u001a\u00020\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#¢\u0006\u0004\bz\u0010uJL\u0010\u0080\u0001\u001a\u00020\u0013\"\u0004\b\u0002\u0010{\"\u0004\b\u0003\u0010|2\u0012\u0010}\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0018\u0010\u007f\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\u00130~H\u0000¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010xR\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010xR\u0017\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0011\u0010\u0083\u0001R7\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00072\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00078\u0000@BX\u0080\u000e¢\u0006\u000f\n\u0005\b2\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u0087\u0001"}, d2 = {"LQa/t;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "dataMap", "nodeMap", "", "buffer", "LTa/e;", "ownedBy", "<init>", "(II[Ljava/lang/Object;LTa/e;)V", "(II[Ljava/lang/Object;)V", "LQa/t$b;", Const.INTENT_KEY_PKGNAME, "()LQa/t$b;", "c", "positionMask", "", "t", "(I)Z", "keyIndex", "v", "(I)Ljava/lang/Object;", "Y", "key", UxipConstants.f30680s, "u", "(ILjava/lang/Object;Ljava/lang/Object;)LQa/t;", "owner", "D", "(ILjava/lang/Object;Ljava/lang/Object;LTa/e;)LQa/t;", "X", "(ILjava/lang/Object;)LQa/t;", "LQa/f;", "mutator", "N", "(ILjava/lang/Object;LQa/f;)LQa/t;", "nodeIndex", "newNode", "(IILQa/t;LTa/e;)LQa/t;", ExifInterface.GPS_DIRECTION_TRUE, "(II)LQa/t;", "L", "(IILTa/e;)LQa/t;", "newKeyHash", "newKey", "newValue", "shift", Const.INTENT_KEY_UMID, "(IIILjava/lang/Object;Ljava/lang/Object;ILTa/e;)[Ljava/lang/Object;", "x", "(IIILjava/lang/Object;Ljava/lang/Object;I)LQa/t;", ExifInterface.LONGITUDE_EAST, "(IIILjava/lang/Object;Ljava/lang/Object;ILTa/e;)LQa/t;", "keyHash1", "key1", "value1", "keyHash2", "key2", "value2", "w", "(ILjava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;ILTa/e;)LQa/t;", ExifInterface.LATITUDE_SOUTH, "(IILQa/f;)LQa/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "k", "(I)LQa/t;", "C", "(ILQa/f;)LQa/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Object;)I", "f", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;)LQa/t$b;", "y", "(Ljava/lang/Object;Ljava/lang/Object;LQa/f;)LQa/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Object;)LQa/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Object;LQa/f;)LQa/t;", "B", "otherNode", "LTa/b;", "intersectionCounter", "z", "(LQa/t;LTa/b;LTa/e;)LQa/t;", "H", "(LQa/t;IILTa/b;LQa/f;)LQa/t;", "e", "()I", "m", "(LQa/t;)Z", "targetNode", "U", "(LQa/t;LQa/t;II)LQa/t;", "M", "(LQa/t;IILTa/e;)LQa/t;", "n", "s", "o", "(I)I", "P", "O", "keyHash", "l", "(ILjava/lang/Object;I)Z", "q", "(ILjava/lang/Object;I)Ljava/lang/Object;", "G", "(LQa/t;ILTa/b;LQa/f;)LQa/t;", "Q", "(ILjava/lang/Object;Ljava/lang/Object;I)LQa/t$b;", "F", "(ILjava/lang/Object;Ljava/lang/Object;ILQa/f;)LQa/t;", "R", "(ILjava/lang/Object;I)LQa/t;", "I", "(ILjava/lang/Object;ILQa/f;)LQa/t;", "J", "K1", "V1", "that", "Lkotlin/Function2;", "equalityComparator", "p", "(LQa/t;Lp9/p;)Z", Const.INTENT_KEY_APIKEY, "LTa/e;", "[Ljava/lang/Object;", "r", "()[Ljava/lang/Object;", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class t<K, V> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final t f5505f = new t(0, 0, new Object[0]);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int dataMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int nodeMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Ta.e ownedBy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Object[] buffer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"LQa/t$a;", "", "<init>", "()V", "LQa/t;", "", "EMPTY", "LQa/t;", Const.INTENT_KEY_APIKEY, "()LQa/t;", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Qa.t$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final t a() {
            return t.f5505f;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR.\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"LQa/t$b;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "LQa/t;", "node", "", "sizeDelta", "<init>", "(LQa/t;I)V", Const.INTENT_KEY_APIKEY, "LQa/t;", "()LQa/t;", "c", "(LQa/t;)V", Const.INTENT_KEY_PKGNAME, "I", "()I", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b<K, V> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public t<K, V> node;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int sizeDelta;

        public b(t<K, V> node, int i10) {
            kotlin.jvm.internal.p.i(node, "node");
            this.node = node;
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
            kotlin.jvm.internal.p.i(tVar, "<set-?>");
            this.node = tVar;
        }
    }

    public t(int i10, int i11, Object[] buffer, Ta.e eVar) {
        kotlin.jvm.internal.p.i(buffer, "buffer");
        this.dataMap = i10;
        this.nodeMap = i11;
        this.ownedBy = eVar;
        this.buffer = buffer;
    }

    public static /* synthetic */ t W(t tVar, int i10, int i11, t tVar2, Ta.e eVar, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            eVar = null;
        }
        return tVar.V(i10, i11, tVar2, eVar);
    }

    public final t<K, V> A(K key, f<K, V> mutator) {
        int iH = h(key);
        return iH != -1 ? C(iH, mutator) : this;
    }

    public final t<K, V> B(K key, V value, f<K, V> mutator) {
        int iH = h(key);
        return (iH == -1 || !kotlin.jvm.internal.p.d(value, Y(iH))) ? this : C(iH, mutator);
    }

    public final t<K, V> C(int i10, f<K, V> mutator) {
        mutator.r(mutator.size() - 1);
        mutator.q(Y(i10));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy != mutator.getOwnership()) {
            return new t<>(0, 0, x.h(this.buffer, i10), mutator.getOwnership());
        }
        this.buffer = x.h(this.buffer, i10);
        return this;
    }

    public final t<K, V> D(int positionMask, K key, V value, Ta.e owner) {
        int iO = o(positionMask);
        if (this.ownedBy != owner) {
            return new t<>(positionMask | this.dataMap, this.nodeMap, x.g(this.buffer, iO, key, value), owner);
        }
        this.buffer = x.g(this.buffer, iO, key, value);
        this.dataMap = positionMask | this.dataMap;
        return this;
    }

    public final t<K, V> E(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift, Ta.e owner) {
        if (this.ownedBy != owner) {
            return new t<>(this.dataMap ^ positionMask, this.nodeMap | positionMask, d(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, owner), owner);
        }
        this.buffer = d(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, owner);
        this.dataMap ^= positionMask;
        this.nodeMap |= positionMask;
        return this;
    }

    public final t<K, V> F(int keyHash, K key, V value, int shift, f<K, V> mutator) {
        kotlin.jvm.internal.p.i(mutator, "mutator");
        int iF = 1 << x.f(keyHash, shift);
        if (s(iF)) {
            int iO = o(iF);
            if (kotlin.jvm.internal.p.d(key, v(iO))) {
                mutator.q(Y(iO));
                return Y(iO) == value ? this : N(iO, value, mutator);
            }
            mutator.r(mutator.size() + 1);
            return E(iO, iF, keyHash, key, value, shift, mutator.getOwnership());
        }
        if (!t(iF)) {
            mutator.r(mutator.size() + 1);
            return D(iF, key, value, mutator.getOwnership());
        }
        int iP = P(iF);
        t<K, V> tVarO = O(iP);
        t<K, V> tVarY = shift == 30 ? tVarO.y(key, value, mutator) : tVarO.F(keyHash, key, value, shift + 5, mutator);
        return tVarO == tVarY ? this : V(iP, iF, tVarY, mutator.getOwnership());
    }

    public final t<K, V> G(t<K, V> otherNode, int shift, DeltaCounter intersectionCounter, f<K, V> mutator) {
        kotlin.jvm.internal.p.i(otherNode, "otherNode");
        kotlin.jvm.internal.p.i(intersectionCounter, "intersectionCounter");
        f<K, V> mutator2 = mutator;
        kotlin.jvm.internal.p.i(mutator2, "mutator");
        if (this == otherNode) {
            intersectionCounter.b(e());
            return this;
        }
        int i10 = shift;
        if (i10 > 30) {
            return z(otherNode, intersectionCounter, mutator2.getOwnership());
        }
        int i11 = this.nodeMap | otherNode.nodeMap;
        int i12 = this.dataMap;
        int i13 = otherNode.dataMap;
        int i14 = (i12 ^ i13) & (~i11);
        int i15 = i12 & i13;
        while (i15 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i15);
            if (kotlin.jvm.internal.p.d(v(o(iLowestOneBit)), otherNode.v(otherNode.o(iLowestOneBit)))) {
                i14 |= iLowestOneBit;
            } else {
                i11 |= iLowestOneBit;
            }
            i15 ^= iLowestOneBit;
        }
        if ((i11 & i14) != 0) {
            throw new IllegalStateException("Check failed.");
        }
        t<K, V> tVar = (kotlin.jvm.internal.p.d(this.ownedBy, mutator2.getOwnership()) && this.dataMap == i14 && this.nodeMap == i11) ? this : new t<>(i14, i11, new Object[(Integer.bitCount(i14) * 2) + Integer.bitCount(i11)]);
        int i16 = 0;
        int i17 = i11;
        int i18 = 0;
        while (i17 != 0) {
            int iLowestOneBit2 = Integer.lowestOneBit(i17);
            tVar.buffer[(r11.length - 1) - i18] = H(otherNode, iLowestOneBit2, i10, intersectionCounter, mutator2);
            i18++;
            i17 ^= iLowestOneBit2;
            i10 = shift;
            mutator2 = mutator;
        }
        while (i14 != 0) {
            int iLowestOneBit3 = Integer.lowestOneBit(i14);
            int i19 = i16 * 2;
            if (otherNode.s(iLowestOneBit3)) {
                int iO = otherNode.o(iLowestOneBit3);
                tVar.buffer[i19] = otherNode.v(iO);
                tVar.buffer[i19 + 1] = otherNode.Y(iO);
                if (s(iLowestOneBit3)) {
                    intersectionCounter.c(intersectionCounter.getCount() + 1);
                }
            } else {
                int iO2 = o(iLowestOneBit3);
                tVar.buffer[i19] = v(iO2);
                tVar.buffer[i19 + 1] = Y(iO2);
            }
            i16++;
            i14 ^= iLowestOneBit3;
        }
        return m(tVar) ? this : otherNode.m(tVar) ? otherNode : tVar;
    }

    public final t<K, V> H(t<K, V> otherNode, int positionMask, int shift, DeltaCounter intersectionCounter, f<K, V> mutator) {
        if (t(positionMask)) {
            t<K, V> tVarO = O(P(positionMask));
            if (otherNode.t(positionMask)) {
                return tVarO.G(otherNode.O(otherNode.P(positionMask)), shift + 5, intersectionCounter, mutator);
            }
            if (!otherNode.s(positionMask)) {
                return tVarO;
            }
            int iO = otherNode.o(positionMask);
            K kV = otherNode.v(iO);
            V vY = otherNode.Y(iO);
            int size = mutator.size();
            t<K, V> tVarF = tVarO.F(kV != null ? kV.hashCode() : 0, kV, vY, shift + 5, mutator);
            if (mutator.size() == size) {
                intersectionCounter.c(intersectionCounter.getCount() + 1);
            }
            return tVarF;
        }
        if (!otherNode.t(positionMask)) {
            int iO2 = o(positionMask);
            K kV2 = v(iO2);
            V vY2 = Y(iO2);
            int iO3 = otherNode.o(positionMask);
            K kV3 = otherNode.v(iO3);
            return w(kV2 != null ? kV2.hashCode() : 0, kV2, vY2, kV3 != null ? kV3.hashCode() : 0, kV3, otherNode.Y(iO3), shift + 5, mutator.getOwnership());
        }
        t<K, V> tVarO2 = otherNode.O(otherNode.P(positionMask));
        if (!s(positionMask)) {
            return tVarO2;
        }
        int iO4 = o(positionMask);
        K kV4 = v(iO4);
        int i10 = shift + 5;
        if (!tVarO2.l(kV4 != null ? kV4.hashCode() : 0, kV4, i10)) {
            return tVarO2.F(kV4 != null ? kV4.hashCode() : 0, kV4, Y(iO4), i10, mutator);
        }
        intersectionCounter.c(intersectionCounter.getCount() + 1);
        return tVarO2;
    }

    public final t<K, V> I(int keyHash, K key, int shift, f<K, V> mutator) {
        kotlin.jvm.internal.p.i(mutator, "mutator");
        int iF = 1 << x.f(keyHash, shift);
        if (s(iF)) {
            int iO = o(iF);
            return kotlin.jvm.internal.p.d(key, v(iO)) ? K(iO, iF, mutator) : this;
        }
        if (!t(iF)) {
            return this;
        }
        int iP = P(iF);
        t<K, V> tVarO = O(iP);
        return M(shift == 30 ? tVarO.A(key, mutator) : tVarO.I(keyHash, key, shift + 5, mutator), iP, iF, mutator.getOwnership());
    }

    public final t<K, V> J(int keyHash, K key, V value, int shift, f<K, V> mutator) {
        f<K, V> fVar;
        t<K, V> tVarJ;
        kotlin.jvm.internal.p.i(mutator, "mutator");
        int iF = 1 << x.f(keyHash, shift);
        if (s(iF)) {
            int iO = o(iF);
            return (kotlin.jvm.internal.p.d(key, v(iO)) && kotlin.jvm.internal.p.d(value, Y(iO))) ? K(iO, iF, mutator) : this;
        }
        if (!t(iF)) {
            return this;
        }
        int iP = P(iF);
        t<K, V> tVarO = O(iP);
        if (shift == 30) {
            tVarJ = tVarO.B(key, value, mutator);
            fVar = mutator;
        } else {
            fVar = mutator;
            tVarJ = tVarO.J(keyHash, key, value, shift + 5, fVar);
        }
        return M(tVarJ, iP, iF, fVar.getOwnership());
    }

    public final t<K, V> K(int keyIndex, int positionMask, f<K, V> mutator) {
        mutator.r(mutator.size() - 1);
        mutator.q(Y(keyIndex));
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

    public final t<K, V> L(int nodeIndex, int positionMask, Ta.e owner) {
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

    public final t<K, V> M(t<K, V> newNode, int nodeIndex, int positionMask, Ta.e owner) {
        return newNode == null ? L(nodeIndex, positionMask, owner) : V(nodeIndex, positionMask, newNode, owner);
    }

    public final t<K, V> N(int keyIndex, V value, f<K, V> mutator) {
        if (this.ownedBy == mutator.getOwnership()) {
            this.buffer[keyIndex + 1] = value;
            return this;
        }
        mutator.o(mutator.getModCount() + 1);
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[keyIndex + 1] = value;
        return new t<>(this.dataMap, this.nodeMap, objArrCopyOf, mutator.getOwnership());
    }

    public final t<K, V> O(int nodeIndex) {
        Object obj = this.buffer[nodeIndex];
        kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (t) obj;
    }

    public final int P(int positionMask) {
        return (this.buffer.length - 1) - Integer.bitCount(this.nodeMap & (positionMask - 1));
    }

    public final b<K, V> Q(int keyHash, K key, V value, int shift) {
        b<K, V> bVarQ;
        int iF = 1 << x.f(keyHash, shift);
        if (s(iF)) {
            int iO = o(iF);
            if (!kotlin.jvm.internal.p.d(key, v(iO))) {
                return x(iO, iF, keyHash, key, value, shift).b();
            }
            if (Y(iO) == value) {
                return null;
            }
            return X(iO, value).c();
        }
        if (!t(iF)) {
            return u(iF, key, value).b();
        }
        int iP = P(iF);
        t<K, V> tVarO = O(iP);
        if (shift == 30) {
            bVarQ = tVarO.i(key, value);
            if (bVarQ == null) {
                return null;
            }
        } else {
            bVarQ = tVarO.Q(keyHash, key, value, shift + 5);
            if (bVarQ == null) {
                return null;
            }
        }
        bVarQ.c(W(this, iP, iF, bVarQ.a(), null, 8, null));
        return bVarQ;
    }

    public final t<K, V> R(int keyHash, K key, int shift) {
        int iF = 1 << x.f(keyHash, shift);
        if (s(iF)) {
            int iO = o(iF);
            return kotlin.jvm.internal.p.d(key, v(iO)) ? S(iO, iF) : this;
        }
        if (!t(iF)) {
            return this;
        }
        int iP = P(iF);
        t<K, V> tVarO = O(iP);
        return U(tVarO, shift == 30 ? tVarO.j(key) : tVarO.R(keyHash, key, shift + 5), iP, iF);
    }

    public final t<K, V> S(int keyIndex, int positionMask) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new t<>(positionMask ^ this.dataMap, this.nodeMap, x.h(objArr, keyIndex));
    }

    public final t<K, V> T(int nodeIndex, int positionMask) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        return new t<>(this.dataMap, this.nodeMap ^ positionMask, x.i(objArr, nodeIndex));
    }

    public final t<K, V> U(t<K, V> targetNode, t<K, V> newNode, int nodeIndex, int positionMask) {
        return newNode == null ? T(nodeIndex, positionMask) : targetNode != newNode ? W(this, nodeIndex, positionMask, newNode, null, 8, null) : this;
    }

    public final t<K, V> V(int nodeIndex, int positionMask, t<K, V> newNode, Ta.e owner) {
        Object[] objArr = newNode.buffer;
        if (objArr.length == 2 && newNode.nodeMap == 0) {
            if (this.buffer.length == 1) {
                newNode.dataMap = this.nodeMap;
                return newNode;
            }
            return new t<>(this.dataMap ^ positionMask, this.nodeMap ^ positionMask, x.k(this.buffer, nodeIndex, o(positionMask), objArr[0], objArr[1]), owner);
        }
        if (owner != null && this.ownedBy == owner) {
            this.buffer[nodeIndex] = newNode;
            return this;
        }
        Object[] objArr2 = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[nodeIndex] = newNode;
        return new t<>(this.dataMap, this.nodeMap, objArrCopyOf, owner);
    }

    public final t<K, V> X(int keyIndex, V value) {
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[keyIndex + 1] = value;
        return new t<>(this.dataMap, this.nodeMap, objArrCopyOf);
    }

    public final V Y(int keyIndex) {
        return (V) this.buffer[keyIndex + 1];
    }

    public final b<K, V> b() {
        return new b<>(this, 1);
    }

    public final b<K, V> c() {
        return new b<>(this, 0);
    }

    public final Object[] d(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift, Ta.e owner) {
        K kV = v(keyIndex);
        return x.j(this.buffer, keyIndex, P(positionMask) + 1, w(kV != null ? kV.hashCode() : 0, kV, Y(keyIndex), newKeyHash, newKey, newValue, shift + 5, owner));
    }

    public final int e() {
        if (this.nodeMap == 0) {
            return this.buffer.length / 2;
        }
        int iBitCount = Integer.bitCount(this.dataMap);
        int length = this.buffer.length;
        for (int i10 = iBitCount * 2; i10 < length; i10++) {
            iBitCount += O(i10).e();
        }
        return iBitCount;
    }

    public final boolean f(K key) {
        return h(key) != -1;
    }

    public final V g(K key) {
        int iH = h(key);
        if (iH != -1) {
            return Y(iH);
        }
        return null;
    }

    public final int h(Object key) {
        C5678g c5678gR = C5685n.r(C5685n.s(0, this.buffer.length), 2);
        int iB = c5678gR.getFirst();
        int iC = c5678gR.getLast();
        int iE = c5678gR.getStep();
        if ((iE <= 0 || iB > iC) && (iE >= 0 || iC > iB)) {
            return -1;
        }
        while (!kotlin.jvm.internal.p.d(key, v(iB))) {
            if (iB == iC) {
                return -1;
            }
            iB += iE;
        }
        return iB;
    }

    public final b<K, V> i(K key, V value) {
        int iH = h(key);
        if (iH == -1) {
            return new t(0, 0, x.g(this.buffer, 0, key, value)).b();
        }
        if (value == Y(iH)) {
            return null;
        }
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[iH + 1] = value;
        return new t(0, 0, objArrCopyOf).c();
    }

    public final t<K, V> j(K key) {
        int iH = h(key);
        return iH != -1 ? k(iH) : this;
    }

    public final t<K, V> k(int i10) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new t<>(0, 0, x.h(objArr, i10));
    }

    public final boolean l(int keyHash, K key, int shift) {
        int iF = 1 << x.f(keyHash, shift);
        if (s(iF)) {
            return kotlin.jvm.internal.p.d(key, v(o(iF)));
        }
        if (!t(iF)) {
            return false;
        }
        t<K, V> tVarO = O(P(iF));
        return shift == 30 ? tVarO.f(key) : tVarO.l(keyHash, key, shift + 5);
    }

    public final boolean m(t<K, V> otherNode) {
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

    public final int n() {
        return Integer.bitCount(this.dataMap);
    }

    public final int o(int positionMask) {
        return Integer.bitCount(this.dataMap & (positionMask - 1)) * 2;
    }

    public final <K1, V1> boolean p(t<K1, V1> that, p9.p<? super V, ? super V1, Boolean> equalityComparator) {
        int i10;
        kotlin.jvm.internal.p.i(that, "that");
        kotlin.jvm.internal.p.i(equalityComparator, "equalityComparator");
        if (this == that) {
            return true;
        }
        int i11 = this.dataMap;
        if (i11 != that.dataMap || (i10 = this.nodeMap) != that.nodeMap) {
            return false;
        }
        if (i11 == 0 && i10 == 0) {
            Object[] objArr = this.buffer;
            if (objArr.length != that.buffer.length) {
                return false;
            }
            Iterable iterableR = C5685n.r(C5685n.s(0, objArr.length), 2);
            if ((iterableR instanceof Collection) && ((Collection) iterableR).isEmpty()) {
                return true;
            }
            Iterator it = iterableR.iterator();
            while (it.hasNext()) {
                int iNextInt = ((M) it).nextInt();
                K1 k1V = that.v(iNextInt);
                V1 v1Y = that.Y(iNextInt);
                int iH = h(k1V);
                if (!(iH != -1 ? equalityComparator.invoke(Y(iH), v1Y).booleanValue() : false)) {
                    return false;
                }
            }
            return true;
        }
        int iBitCount = Integer.bitCount(i11) * 2;
        C5678g c5678gR = C5685n.r(C5685n.s(0, iBitCount), 2);
        int iB = c5678gR.getFirst();
        int iC = c5678gR.getLast();
        int iE = c5678gR.getStep();
        if ((iE > 0 && iB <= iC) || (iE < 0 && iC <= iB)) {
            while (kotlin.jvm.internal.p.d(v(iB), that.v(iB)) && equalityComparator.invoke(Y(iB), that.Y(iB)).booleanValue()) {
                if (iB != iC) {
                    iB += iE;
                }
            }
            return false;
        }
        int length = this.buffer.length;
        while (iBitCount < length) {
            if (!O(iBitCount).p(that.O(iBitCount), equalityComparator)) {
                return false;
            }
            iBitCount++;
        }
        return true;
    }

    public final V q(int keyHash, K key, int shift) {
        int iF = 1 << x.f(keyHash, shift);
        if (s(iF)) {
            int iO = o(iF);
            if (kotlin.jvm.internal.p.d(key, v(iO))) {
                return Y(iO);
            }
            return null;
        }
        if (!t(iF)) {
            return null;
        }
        t<K, V> tVarO = O(P(iF));
        return shift == 30 ? tVarO.g(key) : tVarO.q(keyHash, key, shift + 5);
    }

    /* renamed from: r, reason: from getter */
    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final boolean s(int positionMask) {
        return (this.dataMap & positionMask) != 0;
    }

    public final boolean t(int positionMask) {
        return (this.nodeMap & positionMask) != 0;
    }

    public final t<K, V> u(int positionMask, K key, V value) {
        return new t<>(positionMask | this.dataMap, this.nodeMap, x.g(this.buffer, o(positionMask), key, value));
    }

    public final K v(int keyIndex) {
        return (K) this.buffer[keyIndex];
    }

    public final t<K, V> w(int keyHash1, K key1, V value1, int keyHash2, K key2, V value2, int shift, Ta.e owner) {
        if (shift > 30) {
            return new t<>(0, 0, new Object[]{key1, value1, key2, value2}, owner);
        }
        int iF = x.f(keyHash1, shift);
        int iF2 = x.f(keyHash2, shift);
        if (iF != iF2) {
            return new t<>((1 << iF) | (1 << iF2), 0, iF < iF2 ? new Object[]{key1, value1, key2, value2} : new Object[]{key2, value2, key1, value1}, owner);
        }
        return new t<>(0, 1 << iF, new Object[]{w(keyHash1, key1, value1, keyHash2, key2, value2, shift + 5, owner)}, owner);
    }

    public final t<K, V> x(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift) {
        return new t<>(this.dataMap ^ positionMask, this.nodeMap | positionMask, d(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, null));
    }

    public final t<K, V> y(K key, V value, f<K, V> mutator) {
        int iH = h(key);
        if (iH == -1) {
            mutator.r(mutator.size() + 1);
            return new t<>(0, 0, x.g(this.buffer, 0, key, value), mutator.getOwnership());
        }
        mutator.q(Y(iH));
        if (this.ownedBy == mutator.getOwnership()) {
            this.buffer[iH + 1] = value;
            return this;
        }
        mutator.o(mutator.getModCount() + 1);
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[iH + 1] = value;
        return new t<>(0, 0, objArrCopyOf, mutator.getOwnership());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<K, V> z(t<K, V> otherNode, DeltaCounter intersectionCounter, Ta.e owner) {
        Ta.a.a(this.nodeMap == 0);
        Ta.a.a(this.dataMap == 0);
        Ta.a.a(otherNode.nodeMap == 0);
        Ta.a.a(otherNode.dataMap == 0);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(int i10, int i11, Object[] buffer) {
        this(i10, i11, buffer, null);
        kotlin.jvm.internal.p.i(buffer, "buffer");
    }
}
