package e0;

import Z8.AbstractC1160h;
import Z8.C1168p;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import d0.e;
import h0.C4118a;
import io.ktor.http.ContentDisposition;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C4851b;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010*\n\u0002\b\u0012\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B?\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u001f\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¢\u0006\u0004\b \u0010!JA\u0010&\u001a\u00020%2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¢\u0006\u0004\b&\u0010'JA\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010)\u001a\u00020\nH\u0002¢\u0006\u0004\b*\u0010+J?\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010,\u001a\u00020\n2\u000e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070-H\u0002¢\u0006\u0004\b/\u00100JG\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u00101\u001a\u00020\n2\u0014\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0006H\u0002¢\u0006\u0004\b3\u00104JO\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u00101\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0014\u00105\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060-H\u0002¢\u0006\u0004\b6\u00107J1\u00109\u001a\u00020%2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u00108\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00028\u0000H\u0002¢\u0006\u0004\b9\u0010:JI\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010)\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J]\u0010D\u001a\u00020%2\f\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000?2\u0006\u00108\u001a\u00020\n2\u0006\u0010A\u001a\u00020\n2\u0016\u00102\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u00062\u0006\u0010B\u001a\u00020\n2\u000e\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¢\u0006\u0004\bD\u0010EJW\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010F\u001a\u00020\n2\u0006\u0010A\u001a\u00020\n2\u0016\u00102\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u00062\u0006\u0010B\u001a\u00020\n2\u000e\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¢\u0006\u0004\bG\u0010HJm\u0010K\u001a\u00020%2\f\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000?2\u0006\u00108\u001a\u00020\n2\u000e\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010J\u001a\u00020\n2\u0016\u00102\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u00062\u0006\u0010B\u001a\u00020\n2\u000e\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¢\u0006\u0004\bK\u0010LJ\u001f\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u00108\u001a\u00020\nH\u0002¢\u0006\u0004\bM\u0010NJ;\u0010O\u001a\u0004\u0018\u00010\u00072\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u00101\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u00108\u001a\u00020\nH\u0002¢\u0006\u0004\bO\u0010PJ?\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010)\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u0010Q\u001a\u00020;H\u0002¢\u0006\u0004\bR\u0010SJ1\u0010T\u001a\u00020%2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u00101\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0002¢\u0006\u0004\bT\u0010UJA\u0010V\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010)\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u0010Q\u001a\u00020;H\u0002¢\u0006\u0004\bV\u0010SJ#\u0010Y\u001a\u00020\u00152\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150WH\u0002¢\u0006\u0004\bY\u0010ZJ1\u0010[\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b[\u0010\u001cJ7\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u00108\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0002¢\u0006\u0004\b\\\u0010]J3\u0010`\u001a\u00020\n2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150W2\u0006\u0010^\u001a\u00020\n2\u0006\u0010_\u001a\u00020;H\u0002¢\u0006\u0004\b`\u0010aJC\u0010c\u001a\u00020\n2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150W2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010b\u001a\u00020\n2\u0006\u0010_\u001a\u00020;H\u0002¢\u0006\u0004\bc\u0010dJw\u0010h\u001a\u00020\n2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150W2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010b\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\u0006\u0010_\u001a\u00020;2\u0014\u0010g\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060f2\u0014\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060fH\u0002¢\u0006\u0004\bh\u0010iJG\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010)\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u0010j\u001a\u00028\u00002\u0006\u0010k\u001a\u00020;H\u0002¢\u0006\u0004\bl\u0010>J%\u0010n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060m2\u0006\u00108\u001a\u00020\nH\u0002¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020\nH\u0000¢\u0006\u0004\bp\u0010\u000fJ\u0015\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\bq\u0010rJ\u0017\u0010s\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0004\bs\u0010tJ\u001d\u0010u\u001a\u00020\u00152\f\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000?H\u0016¢\u0006\u0004\bu\u0010vJ\u001f\u0010s\u001a\u00020%2\u0006\u00108\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0004\bs\u0010wJ%\u0010u\u001a\u00020\u00152\u0006\u00108\u001a\u00020\n2\f\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000?H\u0016¢\u0006\u0004\bu\u0010xJ\u0018\u0010y\u001a\u00028\u00002\u0006\u00108\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\by\u0010zJ\u0017\u0010{\u001a\u00028\u00002\u0006\u00108\u001a\u00020\nH\u0016¢\u0006\u0004\b{\u0010zJ\u001d\u0010|\u001a\u00020\u00152\f\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000?H\u0016¢\u0006\u0004\b|\u0010vJ!\u0010}\u001a\u00020\u00152\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150W¢\u0006\u0004\b}\u0010ZJ \u0010~\u001a\u00028\u00002\u0006\u00108\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b~\u0010\u007fJ\u001a\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0080\u0001H\u0096\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0019\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0083\u0001H\u0016¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J \u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0083\u00012\u0006\u00108\u001a\u00020\nH\u0016¢\u0006\u0005\b\u0084\u0001\u0010oR\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\"\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b{\u0010\u0089\u0001R'\u0010\u000b\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0005\b\u008c\u0001\u0010\u000f\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0019\u0010\u0091\u0001\u001a\u00030\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bj\u0010\u0090\u0001R;\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0011\u0010\u0092\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0000@BX\u0080\u000e¢\u0006\u000e\n\u0005\bM\u0010\u0089\u0001\u001a\u0005\b\u0093\u0001\u0010!R8\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000f\u0010\u0092\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0000@BX\u0080\u000e¢\u0006\u000f\n\u0006\b\u0094\u0001\u0010\u0089\u0001\u001a\u0005\b\u0095\u0001\u0010!R(\u0010\u0010\u001a\u00020\n2\u0007\u0010\u0092\u0001\u001a\u00020\n8\u0016@RX\u0096\u000e¢\u0006\u000f\n\u0006\b\u0096\u0001\u0010\u008b\u0001\u001a\u0005\b\u0088\u0001\u0010\u000f¨\u0006\u0097\u0001"}, d2 = {"Le0/h;", ExifInterface.LONGITUDE_EAST, "LZ8/h;", "Ld0/e$a;", "Ld0/e;", "vector", "", "", "vectorRoot", "vectorTail", "", "rootShift", "<init>", "(Ld0/e;[Ljava/lang/Object;[Ljava/lang/Object;I)V", "Y", "()I", ContentDisposition.Parameters.Size, "d0", "(I)I", "c0", "buffer", "", "v", "([Ljava/lang/Object;)Z", "y", "([Ljava/lang/Object;)[Ljava/lang/Object;", "distance", "z", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "element", "D", "(Ljava/lang/Object;)[Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()[Ljava/lang/Object;", Parameters.ROOT, "filledTail", "newTail", "LY8/t;", "N", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "tail", "shift", "O", "([Ljava/lang/Object;[Ljava/lang/Object;I)[Ljava/lang/Object;", "bufferIndex", "", "sourceIterator", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "([Ljava/lang/Object;ILjava/util/Iterator;)[Ljava/lang/Object;", "rootSize", "buffers", "L", "([Ljava/lang/Object;I[[Ljava/lang/Object;)[Ljava/lang/Object;", "buffersIterator", "K", "([Ljava/lang/Object;IILjava/util/Iterator;)[Ljava/lang/Object;", "index", "u", "([Ljava/lang/Object;ILjava/lang/Object;)V", "Le0/e;", "elementCarry", "t", "([Ljava/lang/Object;IILjava/lang/Object;Le0/e;)[Ljava/lang/Object;", "", "elements", "rightShift", "nullBuffers", "nextBuffer", "n", "(Ljava/util/Collection;II[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "startLeafIndex", "a0", "(II[[Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "startBuffer", "startBufferSize", "b0", "(Ljava/util/Collection;I[Ljava/lang/Object;I[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "f", "(I)[Ljava/lang/Object;", ExifInterface.LONGITUDE_WEST, "([Ljava/lang/Object;III)Ljava/lang/Object;", "tailCarry", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "([Ljava/lang/Object;IILe0/e;)[Ljava/lang/Object;", "J", "([Ljava/lang/Object;II)V", "H", "Lkotlin/Function1;", "predicate", "R", "(Lp9/l;)Z", "X", "G", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "tailSize", "bufferRef", ExifInterface.GPS_DIRECTION_TRUE, "(Lp9/l;ILe0/e;)I", "bufferSize", "Q", "(Lp9/l;[Ljava/lang/Object;ILe0/e;)I", "toBufferSize", "", "recyclableBuffers", "P", "(Lp9/l;[Ljava/lang/Object;IILe0/e;Ljava/util/List;Ljava/util/List;)I", "e", "oldElementCarry", "Z", "", "x", "(I)Ljava/util/ListIterator;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Ld0/e;", "add", "(Ljava/lang/Object;)Z", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/lang/Object;)V", "(ILjava/util/Collection;)Z", "get", "(I)Ljava/lang/Object;", "c", "removeAll", "U", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", Const.INTENT_KEY_APIKEY, "Ld0/e;", Const.INTENT_KEY_PKGNAME, "[Ljava/lang/Object;", Const.INTENT_KEY_UMID, "I", "l", "setRootShift$runtime", "(I)V", "Lh0/e;", "Lh0/e;", "ownership", UxipConstants.f30680s, "k", Const.INTENT_KEY_BACKGROUND_COMMAND, "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h<E> extends AbstractC1160h<E> implements e.a<E> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public d0.e<? extends E> vector;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Object[] vectorRoot;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Object[] vectorTail;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int rootShift;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public h0.e ownership = new h0.e();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Object[] root;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public Object[] tail;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int size;

    public h(d0.e<? extends E> eVar, Object[] objArr, Object[] objArr2, int i10) {
        this.vector = eVar;
        this.vectorRoot = objArr;
        this.vectorTail = objArr2;
        this.rootShift = i10;
        this.root = this.vectorRoot;
        this.tail = this.vectorTail;
        this.size = this.vector.size();
    }

    private final Object[] H(Object[] root, int shift, int rootSize, e tailCarry) {
        Object[] objArrH;
        int iA = n.a(rootSize - 1, shift);
        if (shift == 5) {
            tailCarry.b(root[iA]);
            objArrH = null;
        } else {
            Object obj = root[iA];
            p.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrH = H((Object[]) obj, shift - 5, rootSize, tailCarry);
        }
        if (objArrH == null && iA == 0) {
            return null;
        }
        Object[] objArrY = y(root);
        objArrY[iA] = objArrH;
        return objArrY;
    }

    public static final boolean S(Collection collection, Object obj) {
        return collection.contains(obj);
    }

    private final Object[] V(Object[] root, int shift, int index, e tailCarry) {
        int iA = n.a(index, shift);
        if (shift == 0) {
            Object obj = root[iA];
            Object[] objArrI = C1168p.i(root, y(root), iA, iA + 1, 32);
            objArrI[31] = tailCarry.getValue();
            tailCarry.b(obj);
            return objArrI;
        }
        int iA2 = root[31] == null ? n.a(Y() - 1, shift) : 31;
        Object[] objArrY = y(root);
        int i10 = shift - 5;
        int i11 = iA + 1;
        if (i11 <= iA2) {
            while (true) {
                Object obj2 = objArrY[iA2];
                p.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrY[iA2] = V((Object[]) obj2, i10, 0, tailCarry);
                if (iA2 == i11) {
                    break;
                }
                iA2--;
            }
        }
        Object obj3 = objArrY[iA];
        p.g(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrY[iA] = V((Object[]) obj3, i10, index, tailCarry);
        return objArrY;
    }

    private final int Y() {
        if (size() <= 32) {
            return 0;
        }
        return n.d(size());
    }

    private final Object[] f(int index) {
        if (Y() <= index) {
            return this.tail;
        }
        Object[] objArr = this.root;
        p.f(objArr);
        for (int i10 = this.rootShift; i10 > 0; i10 -= 5) {
            Object[] objArr2 = objArr[n.a(index, i10)];
            p.g(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    private final Object[] t(Object[] root, int shift, int index, Object element, e elementCarry) {
        Object obj;
        int iA = n.a(index, shift);
        if (shift == 0) {
            elementCarry.b(root[31]);
            Object[] objArrI = C1168p.i(root, y(root), iA + 1, iA, 31);
            objArrI[iA] = element;
            return objArrI;
        }
        Object[] objArrY = y(root);
        int i10 = shift - 5;
        Object obj2 = objArrY[iA];
        p.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrY[iA] = t((Object[]) obj2, i10, index, element, elementCarry);
        while (true) {
            iA++;
            if (iA >= 32 || (obj = objArrY[iA]) == null) {
                break;
            }
            p.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrY[iA] = t((Object[]) obj, i10, 0, elementCarry.getValue(), elementCarry);
        }
        return objArrY;
    }

    public final Object[] A() {
        Object[] objArr = new Object[33];
        objArr[32] = this.ownership;
        return objArr;
    }

    public final Object[] D(Object element) {
        Object[] objArr = new Object[33];
        objArr[0] = element;
        objArr[32] = this.ownership;
        return objArr;
    }

    public final Object[] G(Object[] root, int index, int shift) {
        if (!(shift >= 0)) {
            androidx.compose.runtime.f.a("shift should be positive");
        }
        if (shift == 0) {
            return root;
        }
        int iA = n.a(index, shift);
        Object obj = root[iA];
        p.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object objG = G((Object[]) obj, index, shift - 5);
        if (iA < 31) {
            int i10 = iA + 1;
            if (root[i10] != null) {
                if (v(root)) {
                    C1168p.v(root, null, i10, 32);
                }
                root = C1168p.i(root, A(), 0, 0, i10);
            }
        }
        if (objG == root[iA]) {
            return root;
        }
        Object[] objArrY = y(root);
        objArrY[iA] = objG;
        return objArrY;
    }

    public final void J(Object[] root, int rootSize, int shift) {
        if (shift == 0) {
            this.root = null;
            if (root == null) {
                root = new Object[0];
            }
            this.tail = root;
            this.size = rootSize;
            this.rootShift = shift;
            return;
        }
        e eVar = new e(null);
        p.f(root);
        Object[] objArrH = H(root, shift, rootSize, eVar);
        p.f(objArrH);
        Object value = eVar.getValue();
        p.g(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.tail = (Object[]) value;
        this.size = rootSize;
        if (objArrH[1] == null) {
            this.root = (Object[]) objArrH[0];
            this.rootShift = shift - 5;
        } else {
            this.root = objArrH;
            this.rootShift = shift;
        }
    }

    public final Object[] K(Object[] root, int rootSize, int shift, Iterator<Object[]> buffersIterator) {
        if (!buffersIterator.hasNext()) {
            androidx.compose.runtime.f.a("invalid buffersIterator");
        }
        if (!(shift >= 0)) {
            androidx.compose.runtime.f.a("negative shift");
        }
        if (shift == 0) {
            return buffersIterator.next();
        }
        Object[] objArrY = y(root);
        int iA = n.a(rootSize, shift);
        int i10 = shift - 5;
        objArrY[iA] = K((Object[]) objArrY[iA], rootSize, i10, buffersIterator);
        while (true) {
            iA++;
            if (iA >= 32 || !buffersIterator.hasNext()) {
                break;
            }
            objArrY[iA] = K((Object[]) objArrY[iA], 0, i10, buffersIterator);
        }
        return objArrY;
    }

    public final Object[] L(Object[] root, int rootSize, Object[][] buffers) {
        Iterator<Object[]> itA = C4851b.a(buffers);
        int i10 = rootSize >> 5;
        int i11 = this.rootShift;
        Object[] objArrK = i10 < (1 << i11) ? K(root, rootSize, i11, itA) : y(root);
        while (itA.hasNext()) {
            this.rootShift += 5;
            objArrK = D(objArrK);
            int i12 = this.rootShift;
            K(objArrK, 1 << i12, i12, itA);
        }
        return objArrK;
    }

    public final void N(Object[] root, Object[] filledTail, Object[] newTail) {
        int size = size() >> 5;
        int i10 = this.rootShift;
        if (size > (1 << i10)) {
            this.root = O(D(root), filledTail, this.rootShift + 5);
            this.tail = newTail;
            this.rootShift += 5;
            this.size = size() + 1;
            return;
        }
        if (root == null) {
            this.root = filledTail;
            this.tail = newTail;
            this.size = size() + 1;
        } else {
            this.root = O(root, filledTail, i10);
            this.tail = newTail;
            this.size = size() + 1;
        }
    }

    public final Object[] O(Object[] root, Object[] tail, int shift) {
        int iA = n.a(size() - 1, shift);
        Object[] objArrY = y(root);
        if (shift == 5) {
            objArrY[iA] = tail;
            return objArrY;
        }
        objArrY[iA] = O((Object[]) objArrY[iA], tail, shift - 5);
        return objArrY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int P(InterfaceC5074l<? super E, Boolean> predicate, Object[] buffer, int bufferSize, int toBufferSize, e bufferRef, List<Object[]> recyclableBuffers, List<Object[]> buffers) {
        if (v(buffer)) {
            recyclableBuffers.add(buffer);
        }
        Object value = bufferRef.getValue();
        p.g(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) value;
        Object[] objArrRemove = objArr;
        for (int i10 = 0; i10 < bufferSize; i10++) {
            Object obj = buffer[i10];
            if (!predicate.invoke(obj).booleanValue()) {
                if (toBufferSize == 32) {
                    objArrRemove = !recyclableBuffers.isEmpty() ? recyclableBuffers.remove(recyclableBuffers.size() - 1) : A();
                    toBufferSize = 0;
                }
                objArrRemove[toBufferSize] = obj;
                toBufferSize++;
            }
        }
        bufferRef.b(objArrRemove);
        if (objArr != bufferRef.getValue()) {
            buffers.add(objArr);
        }
        return toBufferSize;
    }

    public final int Q(InterfaceC5074l<? super E, Boolean> predicate, Object[] buffer, int bufferSize, e bufferRef) {
        Object[] objArrY = buffer;
        int i10 = bufferSize;
        boolean z10 = false;
        for (int i11 = 0; i11 < bufferSize; i11++) {
            Object obj = buffer[i11];
            if (predicate.invoke(obj).booleanValue()) {
                if (!z10) {
                    objArrY = y(buffer);
                    z10 = true;
                    i10 = i11;
                }
            } else if (z10) {
                objArrY[i10] = obj;
                i10++;
            }
        }
        bufferRef.b(objArrY);
        return i10;
    }

    public final boolean R(InterfaceC5074l<? super E, Boolean> predicate) {
        Object[] objArrK;
        int iC0 = c0();
        e eVar = new e(null);
        if (this.root == null) {
            return T(predicate, iC0, eVar) != iC0;
        }
        ListIterator<Object[]> listIteratorX = x(0);
        int iQ = 32;
        while (iQ == 32 && listIteratorX.hasNext()) {
            iQ = Q(predicate, listIteratorX.next(), 32, eVar);
        }
        if (iQ == 32) {
            C4118a.a(!listIteratorX.hasNext());
            int iT = T(predicate, iC0, eVar);
            if (iT == 0) {
                J(this.root, size(), this.rootShift);
            }
            return iT != iC0;
        }
        int iPreviousIndex = listIteratorX.previousIndex() << 5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iP = iQ;
        while (listIteratorX.hasNext()) {
            iP = P(predicate, listIteratorX.next(), 32, iP, eVar, arrayList2, arrayList);
        }
        int iP2 = P(predicate, this.tail, iC0, iP, eVar, arrayList2, arrayList);
        Object value = eVar.getValue();
        p.g(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) value;
        C1168p.v(objArr, null, iP2, 32);
        if (arrayList.isEmpty()) {
            objArrK = this.root;
            p.f(objArrK);
        } else {
            objArrK = K(this.root, iPreviousIndex, this.rootShift, arrayList.iterator());
        }
        int size = iPreviousIndex + (arrayList.size() << 5);
        this.root = X(objArrK, size);
        this.tail = objArr;
        this.size = size + iP2;
        return true;
    }

    public final int T(InterfaceC5074l<? super E, Boolean> predicate, int tailSize, e bufferRef) {
        int iQ = Q(predicate, this.tail, tailSize, bufferRef);
        if (iQ == tailSize) {
            C4118a.a(bufferRef.getValue() == this.tail);
            return tailSize;
        }
        Object value = bufferRef.getValue();
        p.g(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) value;
        C1168p.v(objArr, null, iQ, tailSize);
        this.tail = objArr;
        this.size = size() - (tailSize - iQ);
        return iQ;
    }

    public final boolean U(InterfaceC5074l<? super E, Boolean> predicate) {
        boolean zR = R(predicate);
        if (zR) {
            ((AbstractList) this).modCount++;
        }
        return zR;
    }

    public final Object W(Object[] root, int rootSize, int shift, int index) {
        int size = size() - rootSize;
        C4118a.a(index < size);
        if (size == 1) {
            Object obj = this.tail[0];
            J(root, rootSize, shift);
            return obj;
        }
        Object[] objArr = this.tail;
        Object obj2 = objArr[index];
        Object[] objArrI = C1168p.i(objArr, y(objArr), index, index + 1, size);
        objArrI[size - 1] = null;
        this.root = root;
        this.tail = objArrI;
        this.size = (rootSize + size) - 1;
        this.rootShift = shift;
        return obj2;
    }

    public final Object[] X(Object[] root, int size) {
        if (!((size & 31) == 0)) {
            androidx.compose.runtime.f.a("invalid size");
        }
        if (size == 0) {
            this.rootShift = 0;
            return null;
        }
        int i10 = size - 1;
        while (true) {
            int i11 = this.rootShift;
            if ((i10 >> i11) != 0) {
                return G(root, i10, i11);
            }
            this.rootShift = i11 - 5;
            Object[] objArr = root[0];
            p.g(objArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            root = objArr;
        }
    }

    public final Object[] Z(Object[] root, int shift, int index, E e10, e oldElementCarry) {
        int iA = n.a(index, shift);
        Object[] objArrY = y(root);
        if (shift != 0) {
            Object obj = objArrY[iA];
            p.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrY[iA] = Z((Object[]) obj, shift - 5, index, e10, oldElementCarry);
            return objArrY;
        }
        if (objArrY != root) {
            ((AbstractList) this).modCount++;
        }
        oldElementCarry.b(objArrY[iA]);
        objArrY[iA] = e10;
        return objArrY;
    }

    public final Object[] a0(int startLeafIndex, int rightShift, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        if (this.root == null) {
            throw new IllegalStateException("root is null");
        }
        ListIterator<Object[]> listIteratorX = x(Y() >> 5);
        while (listIteratorX.previousIndex() != startLeafIndex) {
            Object[] objArrPrevious = listIteratorX.previous();
            C1168p.i(objArrPrevious, nextBuffer, 0, 32 - rightShift, 32);
            nextBuffer = z(objArrPrevious, rightShift);
            nullBuffers--;
            buffers[nullBuffers] = nextBuffer;
        }
        return listIteratorX.previous();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        ((AbstractList) this).modCount++;
        int iC0 = c0();
        if (iC0 < 32) {
            Object[] objArrY = y(this.tail);
            objArrY[iC0] = element;
            this.tail = objArrY;
            this.size = size() + 1;
        } else {
            N(this.root, this.tail, D(element));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int iC0 = c0();
        Iterator<? extends E> it = elements.iterator();
        if (32 - iC0 >= elements.size()) {
            this.tail = i(y(this.tail), iC0, it);
            this.size = size() + elements.size();
        } else {
            int size = ((elements.size() + iC0) - 1) / 32;
            Object[][] objArr = new Object[size][];
            objArr[0] = i(y(this.tail), iC0, it);
            for (int i10 = 1; i10 < size; i10++) {
                objArr[i10] = i(A(), 0, it);
            }
            this.root = L(this.root, Y(), objArr);
            this.tail = i(A(), 0, it);
            this.size = size() + elements.size();
        }
        return true;
    }

    @Override // Z8.AbstractC1160h
    /* renamed from: b, reason: from getter */
    public int getSize() {
        return this.size;
    }

    public final void b0(Collection<? extends E> elements, int index, Object[] startBuffer, int startBufferSize, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        Object[] objArrA;
        if (!(nullBuffers >= 1)) {
            androidx.compose.runtime.f.a("requires at least one nullBuffer");
        }
        Object[] objArrY = y(startBuffer);
        buffers[0] = objArrY;
        int i10 = index & 31;
        int size = ((index + elements.size()) - 1) & 31;
        int i11 = (startBufferSize - i10) + size;
        if (i11 < 32) {
            C1168p.i(objArrY, nextBuffer, size + 1, i10, startBufferSize);
        } else {
            int i12 = i11 - 31;
            if (nullBuffers == 1) {
                objArrA = objArrY;
            } else {
                objArrA = A();
                nullBuffers--;
                buffers[nullBuffers] = objArrA;
            }
            int i13 = startBufferSize - i12;
            C1168p.i(objArrY, nextBuffer, 0, i13, startBufferSize);
            C1168p.i(objArrY, objArrA, size + 1, i10, i13);
            nextBuffer = objArrA;
        }
        Iterator<? extends E> it = elements.iterator();
        i(objArrY, i10, it);
        for (int i14 = 1; i14 < nullBuffers; i14++) {
            buffers[i14] = i(A(), 0, it);
        }
        i(nextBuffer, 0, it);
    }

    @Override // d0.e.a
    public d0.e<E> build() {
        f fVar;
        if (this.root == this.vectorRoot && this.tail == this.vectorTail) {
            fVar = this.vector;
        } else {
            this.ownership = new h0.e();
            Object[] objArr = this.root;
            this.vectorRoot = objArr;
            Object[] objArr2 = this.tail;
            this.vectorTail = objArr2;
            if (objArr != null) {
                Object[] objArr3 = this.root;
                p.f(objArr3);
                fVar = new f(objArr3, this.tail, size(), this.rootShift);
            } else if (objArr2.length == 0) {
                fVar = n.b();
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(this.tail, size());
                p.h(objArrCopyOf, "copyOf(...)");
                fVar = new l(objArrCopyOf);
            }
        }
        this.vector = fVar;
        return (d0.e<E>) fVar;
    }

    @Override // Z8.AbstractC1160h
    public E c(int index) {
        h0.d.a(index, size());
        ((AbstractList) this).modCount++;
        int iY = Y();
        if (index >= iY) {
            return (E) W(this.root, iY, this.rootShift, index - iY);
        }
        e eVar = new e(this.tail[0]);
        Object[] objArr = this.root;
        p.f(objArr);
        W(V(objArr, this.rootShift, index, eVar), iY, this.rootShift, 0);
        return (E) eVar.getValue();
    }

    public final int c0() {
        return d0(size());
    }

    public final int d0(int size) {
        return size <= 32 ? size : size - n.d(size);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        h0.d.a(index, size());
        return (E) f(index)[index & 31];
    }

    public final Object[] i(Object[] buffer, int bufferIndex, Iterator<? extends Object> sourceIterator) {
        while (bufferIndex < 32 && sourceIterator.hasNext()) {
            buffer[bufferIndex] = sourceIterator.next();
            bufferIndex++;
        }
        return buffer;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator();
    }

    public final int j() {
        return ((AbstractList) this).modCount;
    }

    /* renamed from: k, reason: from getter */
    public final Object[] getRoot() {
        return this.root;
    }

    /* renamed from: l, reason: from getter */
    public final int getRootShift() {
        return this.rootShift;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    /* renamed from: m, reason: from getter */
    public final Object[] getTail() {
        return this.tail;
    }

    public final void n(Collection<? extends E> elements, int index, int rightShift, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        Object[] objArr;
        if (this.root == null) {
            throw new IllegalStateException("root is null");
        }
        int i10 = index >> 5;
        Object[] objArrA0 = a0(i10, rightShift, buffers, nullBuffers, nextBuffer);
        int iY = nullBuffers - (((Y() >> 5) - 1) - i10);
        if (iY < nullBuffers) {
            Object[] objArr2 = buffers[iY];
            p.f(objArr2);
            objArr = objArr2;
        } else {
            objArr = nextBuffer;
        }
        b0(elements, index, objArrA0, 32, buffers, iY, objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(final Collection<?> elements) {
        return U(new InterfaceC5074l() { // from class: e0.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(h.S(elements, obj));
            }
        });
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        h0.d.a(index, size());
        if (Y() > index) {
            e eVar = new e(null);
            Object[] objArr = this.root;
            p.f(objArr);
            this.root = Z(objArr, this.rootShift, index, element, eVar);
            return (E) eVar.getValue();
        }
        Object[] objArrY = y(this.tail);
        if (objArrY != this.tail) {
            ((AbstractList) this).modCount++;
        }
        int i10 = index & 31;
        E e10 = (E) objArrY[i10];
        objArrY[i10] = element;
        this.tail = objArrY;
        return e10;
    }

    public final void u(Object[] root, int index, E element) {
        int iC0 = c0();
        Object[] objArrY = y(this.tail);
        if (iC0 < 32) {
            C1168p.i(this.tail, objArrY, index + 1, index, iC0);
            objArrY[index] = element;
            this.root = root;
            this.tail = objArrY;
            this.size = size() + 1;
            return;
        }
        Object[] objArr = this.tail;
        Object obj = objArr[31];
        C1168p.i(objArr, objArrY, index + 1, index, 31);
        objArrY[index] = element;
        N(root, objArrY, D(obj));
    }

    public final boolean v(Object[] buffer) {
        return buffer.length == 33 && buffer[32] == this.ownership;
    }

    public final ListIterator<Object[]> x(int index) {
        Object[] objArr = this.root;
        if (objArr == null) {
            throw new IllegalStateException("Invalid root");
        }
        int iY = Y() >> 5;
        h0.d.b(index, iY);
        int i10 = this.rootShift;
        return i10 == 0 ? new k(objArr, index) : new m(objArr, index, iY, i10 / 5);
    }

    public final Object[] y(Object[] buffer) {
        return buffer == null ? A() : v(buffer) ? buffer : C1168p.n(buffer, A(), 0, 0, C5685n.j(buffer.length, 32), 6, null);
    }

    public final Object[] z(Object[] buffer, int distance) {
        return v(buffer) ? C1168p.i(buffer, buffer, distance, 0, 32 - distance) : C1168p.i(buffer, A(), distance, 0, 32 - distance);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        h0.d.b(index, size());
        return new j(this, index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        h0.d.b(index, size());
        if (index == size()) {
            add(element);
            return;
        }
        ((AbstractList) this).modCount++;
        int iY = Y();
        if (index >= iY) {
            u(this.root, index - iY, element);
            return;
        }
        e eVar = new e(null);
        Object[] objArr = this.root;
        p.f(objArr);
        u(t(objArr, this.rootShift, index, element, eVar), 0, eVar.getValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        h<E> hVar;
        Collection<? extends E> collection;
        Object[] objArrI;
        Object[][] objArr;
        h0.d.b(index, size());
        if (index == size()) {
            return addAll(elements);
        }
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i10 = (index >> 5) << 5;
        int size = (((size() - i10) + elements.size()) - 1) / 32;
        if (size == 0) {
            C4118a.a(index >= Y());
            int i11 = index & 31;
            int size2 = ((index + elements.size()) - 1) & 31;
            Object[] objArr2 = this.tail;
            Object[] objArrI2 = C1168p.i(objArr2, y(objArr2), size2 + 1, i11, c0());
            i(objArrI2, i11, elements.iterator());
            this.tail = objArrI2;
            this.size = size() + elements.size();
            return true;
        }
        Object[][] objArr3 = new Object[size][];
        int iC0 = c0();
        int iD0 = d0(size() + elements.size());
        if (index >= Y()) {
            objArrI = A();
            objArr = objArr3;
            hVar = this;
            collection = elements;
            hVar.b0(collection, index, this.tail, iC0, objArr, size, objArrI);
        } else {
            hVar = this;
            collection = elements;
            if (iD0 > iC0) {
                int i12 = iD0 - iC0;
                Object[] objArrZ = hVar.z(hVar.tail, i12);
                hVar.n(collection, index, i12, objArr3, size, objArrZ);
                objArr = objArr3;
                objArrI = objArrZ;
            } else {
                int i13 = iC0 - iD0;
                objArrI = C1168p.i(hVar.tail, hVar.A(), 0, i13, iC0);
                int i14 = 32 - i13;
                Object[] objArrZ2 = hVar.z(hVar.tail, i14);
                int i15 = size - 1;
                objArr3[i15] = objArrZ2;
                hVar.n(collection, index, i14, objArr3, i15, objArrZ2);
                collection = collection;
                objArr = objArr3;
                hVar = hVar;
            }
        }
        hVar.root = hVar.L(hVar.root, i10, objArr);
        hVar.tail = objArrI;
        hVar.size = hVar.size() + collection.size();
        return true;
    }
}
