package Mb;

import La.C0953c;
import Z8.C1168p;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import okio.ByteString;
import okio.SegmentedByteString;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u000f¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0018\u0010'\u001a\u00020#2\u0006\u0010&\u001a\u00020\u000fH\u0087\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000fH\u0016¢\u0006\u0004\b/\u0010\"J\u000f\u00100\u001a\u00020)H\u0016¢\u0006\u0004\b0\u0010+J\u000f\u00101\u001a\u00020,H\u0016¢\u0006\u0004\b1\u0010.J\u000f\u00102\u001a\u00020\u000fH\u0016¢\u0006\u0004\b2\u0010\"J\u000f\u00103\u001a\u00020\u000fH\u0016¢\u0006\u0004\b3\u0010\"J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u0002042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020,2\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020C2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001a\u00020C2\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\u001f\u0010L\u001a\u00020C2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020CH\u0016¢\u0006\u0004\bN\u0010EJ\u0017\u0010P\u001a\u00020C2\u0006\u0010O\u001a\u00020\u000fH\u0016¢\u0006\u0004\bP\u0010GJ\u000f\u0010Q\u001a\u00020,H\u0016¢\u0006\u0004\bQ\u0010.J\u000f\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ\u0017\u0010U\u001a\u00020R2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\bU\u0010VJ\u0017\u0010W\u001a\u00020\u00112\u0006\u0010=\u001a\u00020RH\u0016¢\u0006\u0004\bW\u0010XJ'\u0010Y\u001a\u00020,2\u0006\u0010=\u001a\u00020R2\u0006\u0010\u001c\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020,H\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010Y\u001a\u00020,2\u0006\u0010=\u001a\u00020[H\u0016¢\u0006\u0004\bY\u0010\\J\r\u0010]\u001a\u00020\u0011¢\u0006\u0004\b]\u0010\u0006J\u0017\u0010^\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b^\u0010\u0013J\u0017\u0010`\u001a\u00020\u00002\u0006\u0010_\u001a\u000204H\u0016¢\u0006\u0004\b`\u0010aJ\u0017\u0010c\u001a\u00020\u00002\u0006\u0010b\u001a\u00020CH\u0016¢\u0006\u0004\bc\u0010dJ'\u0010g\u001a\u00020\u00002\u0006\u0010b\u001a\u00020C2\u0006\u0010e\u001a\u00020,2\u0006\u0010f\u001a\u00020,H\u0016¢\u0006\u0004\bg\u0010hJ\u0017\u0010j\u001a\u00020\u00002\u0006\u0010i\u001a\u00020,H\u0016¢\u0006\u0004\bj\u0010kJ/\u0010l\u001a\u00020\u00002\u0006\u0010b\u001a\u00020C2\u0006\u0010e\u001a\u00020,2\u0006\u0010f\u001a\u00020,2\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bl\u0010mJ\u0017\u0010o\u001a\u00020\u00002\u0006\u0010n\u001a\u00020RH\u0016¢\u0006\u0004\bo\u0010pJ'\u0010q\u001a\u00020\u00002\u0006\u0010n\u001a\u00020R2\u0006\u0010\u001c\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020,H\u0016¢\u0006\u0004\bq\u0010rJ\u0017\u0010s\u001a\u00020,2\u0006\u0010n\u001a\u00020[H\u0016¢\u0006\u0004\bs\u0010\\J\u0017\u0010u\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020tH\u0016¢\u0006\u0004\bu\u0010vJ\u0017\u0010x\u001a\u00020\u00002\u0006\u0010w\u001a\u00020,H\u0016¢\u0006\u0004\bx\u0010kJ\u0017\u0010z\u001a\u00020\u00002\u0006\u0010y\u001a\u00020,H\u0016¢\u0006\u0004\bz\u0010kJ\u0017\u0010|\u001a\u00020\u00002\u0006\u0010{\u001a\u00020,H\u0016¢\u0006\u0004\b|\u0010kJ\u0017\u0010~\u001a\u00020\u00002\u0006\u0010}\u001a\u00020\u000fH\u0016¢\u0006\u0004\b~\u0010\u007fJ\u0019\u0010\u0080\u0001\u001a\u00020\u00002\u0006\u0010}\u001a\u00020\u000fH\u0016¢\u0006\u0005\b\u0080\u0001\u0010\u007fJ\u001c\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0081\u0001\u001a\u00020,H\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J!\u0010\u0085\u0001\u001a\u00020\u00112\u0006\u0010n\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0005\b\u0085\u0001\u0010?J\"\u0010\u0086\u0001\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J,\u0010\u008a\u0001\u001a\u00020\u000f2\u0006\u0010w\u001a\u00020#2\u0007\u0010\u0088\u0001\u001a\u00020\u000f2\u0007\u0010\u0089\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u001b\u0010\u008d\u0001\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u000204H\u0016¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J$\u0010\u008f\u0001\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u0002042\u0007\u0010\u0088\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J-\u0010\u0091\u0001\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u0002042\u0007\u0010\u0088\u0001\u001a\u00020\u000f2\u0007\u0010\u0089\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u000f2\u0007\u0010\u0093\u0001\u001a\u000204H\u0016¢\u0006\u0006\b\u0094\u0001\u0010\u008e\u0001J$\u0010\u0095\u0001\u001a\u00020\u000f2\u0007\u0010\u0093\u0001\u001a\u0002042\u0007\u0010\u0088\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0006\b\u0095\u0001\u0010\u0090\u0001J#\u0010\u0096\u0001\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u000204H\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J4\u0010\u0099\u0001\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u0002042\u0007\u0010\u0098\u0001\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020,H\u0016¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0011\u0010\u009b\u0001\u001a\u00020\u0011H\u0016¢\u0006\u0005\b\u009b\u0001\u0010\u0006J\u0011\u0010\u009c\u0001\u001a\u00020\fH\u0016¢\u0006\u0005\b\u009c\u0001\u0010\u000eJ\u0011\u0010\u009d\u0001\u001a\u00020\u0011H\u0016¢\u0006\u0005\b\u009d\u0001\u0010\u0006J\u0013\u0010\u009f\u0001\u001a\u00030\u009e\u0001H\u0016¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u001f\u0010£\u0001\u001a\u00020\f2\n\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u0001H\u0096\u0002¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u0011\u0010¥\u0001\u001a\u00020,H\u0016¢\u0006\u0005\b¥\u0001\u0010.J\u0011\u0010¦\u0001\u001a\u00020CH\u0016¢\u0006\u0005\b¦\u0001\u0010EJ\u000f\u0010§\u0001\u001a\u00020\u0000¢\u0006\u0005\b§\u0001\u0010\bJ\u000f\u0010{\u001a\u00020\u0000H\u0016¢\u0006\u0004\b{\u0010\bJ\u000f\u0010¨\u0001\u001a\u000204¢\u0006\u0005\b¨\u0001\u00106J\u0018\u0010©\u0001\u001a\u0002042\u0006\u0010\u0010\u001a\u00020,¢\u0006\u0006\b©\u0001\u0010ª\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R/\u0010°\u0001\u001a\u00020\u000f2\u0007\u0010®\u0001\u001a\u00020\u000f8\u0007@@X\u0086\u000e¢\u0006\u0015\n\u0005\bw\u0010¯\u0001\u001a\u0005\b°\u0001\u0010\"\"\u0005\b±\u0001\u0010\u0013R\u0016\u0010²\u0001\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b«\u0001\u0010\b¨\u0006³\u0001"}, d2 = {"LMb/d;", "LMb/f;", "LMb/e;", "", "Ljava/nio/channels/ByteChannel;", "<init>", "()V", "u", "()LMb/d;", "Ljava/io/OutputStream;", "o1", "()Ljava/io/OutputStream;", "", "k", "()Z", "", "byteCount", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)V", "request", "(J)Z", "peek", "()LMb/f;", "Ljava/io/InputStream;", "r1", "()Ljava/io/InputStream;", "out", "offset", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(LMb/d;JJ)LMb/d;", "y1", "(Ljava/io/OutputStream;J)LMb/d;", "n", "()J", "", "readByte", "()B", "pos", "Y", "(J)B", "", "readShort", "()S", "", "readInt", "()I", "readLong", "l0", "e1", "o0", "p1", "Lokio/ByteString;", "N0", "()Lokio/ByteString;", "z0", "(J)Lokio/ByteString;", "LMb/x;", "options", "p0", "(LMb/x;)I", "sink", "O0", "(LMb/d;J)V", "LMb/G;", "c1", "(LMb/G;)J", "", "Y0", "()Ljava/lang/String;", "x0", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "S0", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "T0", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "h0", "limit", "I", "U0", "", "D0", "()[B", "I0", "(J)[B", "R0", "([B)V", "read", "([BII)I", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", Const.INTENT_KEY_BACKGROUND_COMMAND, "skip", "byteString", "k1", "(Lokio/ByteString;)LMb/d;", "string", "A1", "(Ljava/lang/String;)LMb/d;", "beginIndex", "endIndex", "B1", "(Ljava/lang/String;II)LMb/d;", "codePoint", "C1", "(I)LMb/d;", "x1", "(Ljava/lang/String;IILjava/nio/charset/Charset;)LMb/d;", "source", "l1", "([B)LMb/d;", "m1", "([BII)LMb/d;", "write", "LMb/I;", "V0", "(LMb/I;)J", Const.INTENT_KEY_PKGNAME, "s1", "s", "w1", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "v1", "v", "t1", "(J)LMb/d;", "u1", "minimumCapacity", "LMb/E;", "h1", "(I)LMb/E;", "K", "u0", "(LMb/d;J)J", "fromIndex", "toIndex", ExifInterface.LONGITUDE_EAST, "(BJJ)J", SingleFileBundle.KEY_BYTES, "C", "(Lokio/ByteString;)J", "e0", "(Lokio/ByteString;J)J", "g0", "(Lokio/ByteString;JJ)J", "targetBytes", "F", "k0", "P", "(JLokio/ByteString;)Z", "bytesOffset", "v0", "(JLokio/ByteString;II)Z", "flush", "isOpen", "close", "LMb/J;", "c", "()LMb/J;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "U", "b1", "f1", "(I)Lokio/ByteString;", Const.INTENT_KEY_APIKEY, "LMb/E;", "head", UxipConstants.f30680s, "J", ContentDisposition.Parameters.Size, SdCardDbCreator.FIELD_LASTLOC_ID, "buffer", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0966d implements InterfaceC0968f, InterfaceC0967e, Cloneable, ByteChannel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public E head;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public long size;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Mb/d$b", "Ljava/io/OutputStream;", "", Const.INTENT_KEY_PKGNAME, "LY8/t;", "write", "(I)V", "", "data", "offset", "byteCount", "([BII)V", "flush", "()V", "close", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Mb.d$b */
    public static final class b extends OutputStream {
        public b() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return C0966d.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int b10) {
            C0966d.this.writeByte(b10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int offset, int byteCount) {
            kotlin.jvm.internal.p.i(data, "data");
            C0966d.this.write(data, offset, byteCount);
        }
    }

    public static /* synthetic */ C0966d z1(C0966d c0966d, OutputStream outputStream, long j10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            j10 = c0966d.size;
        }
        return c0966d.y1(outputStream, j10);
    }

    @Override // Mb.InterfaceC0967e
    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public C0966d L(String string) {
        kotlin.jvm.internal.p.i(string, "string");
        return R(string, 0, string.length());
    }

    @Override // Mb.InterfaceC0967e
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public C0966d R(String string, int beginIndex, int endIndex) {
        char cCharAt;
        kotlin.jvm.internal.p.i(string, "string");
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (endIndex < beginIndex) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (endIndex > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        while (beginIndex < endIndex) {
            char cCharAt2 = string.charAt(beginIndex);
            if (cCharAt2 < 128) {
                E eH1 = h1(1);
                byte[] bArr = eH1.data;
                int i10 = eH1.limit - beginIndex;
                int iMin = Math.min(endIndex, 8192 - i10);
                int i11 = beginIndex + 1;
                bArr[beginIndex + i10] = (byte) cCharAt2;
                while (true) {
                    beginIndex = i11;
                    if (beginIndex >= iMin || (cCharAt = string.charAt(beginIndex)) >= 128) {
                        break;
                    }
                    i11 = beginIndex + 1;
                    bArr[beginIndex + i10] = (byte) cCharAt;
                }
                int i12 = eH1.limit;
                int i13 = (i10 + beginIndex) - i12;
                eH1.limit = i12 + i13;
                a1(getSize() + i13);
            } else {
                if (cCharAt2 < 2048) {
                    E eH12 = h1(2);
                    byte[] bArr2 = eH12.data;
                    int i14 = eH12.limit;
                    bArr2[i14] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i14 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    eH12.limit = i14 + 2;
                    a1(getSize() + 2);
                } else if (55296 <= cCharAt2 && cCharAt2 < 56320) {
                    int i15 = beginIndex + 1;
                    char cCharAt3 = i15 < endIndex ? string.charAt(i15) : (char) 0;
                    if (56320 > cCharAt3 || cCharAt3 >= 57344) {
                        writeByte(63);
                        beginIndex = i15;
                    } else {
                        int iA = Nb.u.a(cCharAt2, cCharAt3);
                        E eH13 = h1(4);
                        byte[] bArr3 = eH13.data;
                        int i16 = eH13.limit;
                        bArr3[i16] = (byte) ((iA >> 18) | 240);
                        bArr3[i16 + 1] = (byte) (((iA >> 12) & 63) | 128);
                        bArr3[i16 + 2] = (byte) (((iA >> 6) & 63) | 128);
                        bArr3[i16 + 3] = (byte) ((iA & 63) | 128);
                        eH13.limit = i16 + 4;
                        a1(getSize() + 4);
                        beginIndex += 2;
                    }
                } else if (56320 > cCharAt2 || cCharAt2 >= 57344) {
                    E eH14 = h1(3);
                    byte[] bArr4 = eH14.data;
                    int i17 = eH14.limit;
                    bArr4[i17] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr4[i17 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr4[i17 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    eH14.limit = i17 + 3;
                    a1(getSize() + 3);
                } else {
                    writeByte(63);
                }
                beginIndex++;
            }
        }
        return this;
    }

    @Override // Mb.InterfaceC0968f
    public long C(ByteString bytes) throws IOException {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        return e0(bytes, 0L);
    }

    @Override // Mb.InterfaceC0967e
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public C0966d z(int codePoint) {
        if (codePoint < 128) {
            writeByte(codePoint);
            return this;
        }
        if (codePoint < 2048) {
            E eH1 = h1(2);
            byte[] bArr = eH1.data;
            int i10 = eH1.limit;
            bArr[i10] = (byte) ((codePoint >> 6) | 192);
            bArr[i10 + 1] = (byte) ((codePoint & 63) | 128);
            eH1.limit = i10 + 2;
            a1(getSize() + 2);
            return this;
        }
        if (55296 <= codePoint && codePoint < 57344) {
            writeByte(63);
            return this;
        }
        if (codePoint < 65536) {
            E eH12 = h1(3);
            byte[] bArr2 = eH12.data;
            int i11 = eH12.limit;
            bArr2[i11] = (byte) ((codePoint >> 12) | 224);
            bArr2[i11 + 1] = (byte) (((codePoint >> 6) & 63) | 128);
            bArr2[i11 + 2] = (byte) ((codePoint & 63) | 128);
            eH12.limit = i11 + 3;
            a1(getSize() + 3);
            return this;
        }
        if (codePoint > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + C0963a.g(codePoint));
        }
        E eH13 = h1(4);
        byte[] bArr3 = eH13.data;
        int i12 = eH13.limit;
        bArr3[i12] = (byte) ((codePoint >> 18) | 240);
        bArr3[i12 + 1] = (byte) (((codePoint >> 12) & 63) | 128);
        bArr3[i12 + 2] = (byte) (((codePoint >> 6) & 63) | 128);
        bArr3[i12 + 3] = (byte) ((codePoint & 63) | 128);
        eH13.limit = i12 + 4;
        a1(getSize() + 4);
        return this;
    }

    public byte[] D0() {
        return I0(getSize());
    }

    @Override // Mb.InterfaceC0968f
    public long E(byte b10, long fromIndex, long toIndex) {
        E e10;
        int i10;
        long size = 0;
        if (0 > fromIndex || fromIndex > toIndex) {
            throw new IllegalArgumentException(("size=" + getSize() + " fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        if (toIndex > getSize()) {
            toIndex = getSize();
        }
        if (fromIndex == toIndex || (e10 = this.head) == null) {
            return -1L;
        }
        if (getSize() - fromIndex < fromIndex) {
            size = getSize();
            while (size > fromIndex) {
                e10 = e10.prev;
                kotlin.jvm.internal.p.f(e10);
                size -= e10.limit - e10.pos;
            }
            while (size < toIndex) {
                byte[] bArr = e10.data;
                int iMin = (int) Math.min(e10.limit, (e10.pos + toIndex) - size);
                i10 = (int) ((e10.pos + fromIndex) - size);
                while (i10 < iMin) {
                    if (bArr[i10] != b10) {
                        i10++;
                    }
                }
                size += e10.limit - e10.pos;
                e10 = e10.next;
                kotlin.jvm.internal.p.f(e10);
                fromIndex = size;
            }
            return -1L;
        }
        while (true) {
            long j10 = (e10.limit - e10.pos) + size;
            if (j10 > fromIndex) {
                break;
            }
            e10 = e10.next;
            kotlin.jvm.internal.p.f(e10);
            size = j10;
        }
        while (size < toIndex) {
            byte[] bArr2 = e10.data;
            int iMin2 = (int) Math.min(e10.limit, (e10.pos + toIndex) - size);
            i10 = (int) ((e10.pos + fromIndex) - size);
            while (i10 < iMin2) {
                if (bArr2[i10] != b10) {
                    i10++;
                }
            }
            size += e10.limit - e10.pos;
            e10 = e10.next;
            kotlin.jvm.internal.p.f(e10);
            fromIndex = size;
        }
        return -1L;
        return (i10 - e10.pos) + size;
    }

    @Override // Mb.InterfaceC0968f
    public long F(ByteString targetBytes) {
        kotlin.jvm.internal.p.i(targetBytes, "targetBytes");
        return k0(targetBytes, 0L);
    }

    @Override // Mb.InterfaceC0968f
    public String I(long limit) throws EOFException {
        if (limit < 0) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j10 = limit != Long.MAX_VALUE ? limit + 1 : Long.MAX_VALUE;
        long jE = E((byte) 10, 0L, j10);
        if (jE != -1) {
            return Nb.a.g(this, jE);
        }
        if (j10 < getSize() && Y(j10 - 1) == 13 && Y(j10) == 10) {
            return Nb.a.g(this, j10);
        }
        C0966d c0966d = new C0966d();
        V(c0966d, 0L, Math.min(32, getSize()));
        throw new EOFException("\\n not found: limit=" + Math.min(getSize(), limit) + " content=" + c0966d.N0().t() + (char) 8230);
    }

    public byte[] I0(long byteCount) throws EOFException {
        if (byteCount < 0 || byteCount > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (getSize() < byteCount) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) byteCount];
        R0(bArr);
        return bArr;
    }

    @Override // Mb.G
    public void K(C0966d source, long byteCount) {
        E e10;
        kotlin.jvm.internal.p.i(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        C0963a.b(source.getSize(), 0L, byteCount);
        while (byteCount > 0) {
            E e11 = source.head;
            kotlin.jvm.internal.p.f(e11);
            int i10 = e11.limit;
            kotlin.jvm.internal.p.f(source.head);
            if (byteCount < i10 - r1.pos) {
                E e12 = this.head;
                if (e12 != null) {
                    kotlin.jvm.internal.p.f(e12);
                    e10 = e12.prev;
                } else {
                    e10 = null;
                }
                if (e10 != null && e10.owner) {
                    if ((e10.limit + byteCount) - (e10.shared ? 0 : e10.pos) <= 8192) {
                        E e13 = source.head;
                        kotlin.jvm.internal.p.f(e13);
                        e13.f(e10, (int) byteCount);
                        source.a1(source.getSize() - byteCount);
                        a1(getSize() + byteCount);
                        return;
                    }
                }
                E e14 = source.head;
                kotlin.jvm.internal.p.f(e14);
                source.head = e14.e((int) byteCount);
            }
            E e15 = source.head;
            kotlin.jvm.internal.p.f(e15);
            long j10 = e15.limit - e15.pos;
            source.head = e15.b();
            E e16 = this.head;
            if (e16 == null) {
                this.head = e15;
                e15.prev = e15;
                e15.next = e15;
            } else {
                kotlin.jvm.internal.p.f(e16);
                E e17 = e16.prev;
                kotlin.jvm.internal.p.f(e17);
                e17.c(e15).a();
            }
            source.a1(source.getSize() - j10);
            a1(getSize() + j10);
            byteCount -= j10;
        }
    }

    public ByteString N0() {
        return z0(getSize());
    }

    @Override // Mb.InterfaceC0968f
    public void O0(C0966d sink, long byteCount) throws EOFException {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (getSize() >= byteCount) {
            sink.K(this, byteCount);
        } else {
            sink.K(this, getSize());
            throw new EOFException();
        }
    }

    @Override // Mb.InterfaceC0968f
    public boolean P(long offset, ByteString bytes) {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        return v0(offset, bytes, 0, bytes.K());
    }

    public void R0(byte[] sink) throws EOFException {
        kotlin.jvm.internal.p.i(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int i11 = read(sink, i10, sink.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    @Override // Mb.InterfaceC0968f
    public String S0(Charset charset) {
        kotlin.jvm.internal.p.i(charset, "charset");
        return T0(this.size, charset);
    }

    public String T0(long byteCount, Charset charset) throws EOFException {
        kotlin.jvm.internal.p.i(charset, "charset");
        if (byteCount < 0 || byteCount > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (this.size < byteCount) {
            throw new EOFException();
        }
        if (byteCount == 0) {
            return "";
        }
        E e10 = this.head;
        kotlin.jvm.internal.p.f(e10);
        int i10 = e10.pos;
        if (i10 + byteCount > e10.limit) {
            return new String(I0(byteCount), charset);
        }
        int i11 = (int) byteCount;
        String str = new String(e10.data, i10, i11, charset);
        int i12 = e10.pos + i11;
        e10.pos = i12;
        this.size -= byteCount;
        if (i12 == e10.limit) {
            this.head = e10.b();
            F.b(e10);
        }
        return str;
    }

    public final C0966d U() {
        C0966d c0966d = new C0966d();
        if (getSize() == 0) {
            return c0966d;
        }
        E e10 = this.head;
        kotlin.jvm.internal.p.f(e10);
        E eD = e10.d();
        c0966d.head = eD;
        eD.prev = eD;
        eD.next = eD;
        for (E e11 = e10.next; e11 != e10; e11 = e11.next) {
            E e12 = eD.prev;
            kotlin.jvm.internal.p.f(e12);
            kotlin.jvm.internal.p.f(e11);
            e12.c(e11.d());
        }
        c0966d.a1(getSize());
        return c0966d;
    }

    @Override // Mb.InterfaceC0968f
    public int U0() throws EOFException {
        int i10;
        int i11;
        int i12;
        if (getSize() == 0) {
            throw new EOFException();
        }
        byte bY = Y(0L);
        if ((bY & 128) == 0) {
            i10 = bY & 127;
            i12 = 0;
            i11 = 1;
        } else if ((bY & 224) == 192) {
            i10 = bY & 31;
            i11 = 2;
            i12 = 128;
        } else if ((bY & 240) == 224) {
            i10 = bY & 15;
            i11 = 3;
            i12 = 2048;
        } else {
            if ((bY & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i10 = bY & 7;
            i11 = 4;
            i12 = 65536;
        }
        long j10 = i11;
        if (getSize() < j10) {
            throw new EOFException("size < " + i11 + ": " + getSize() + " (to read code point prefixed 0x" + C0963a.f(bY) + ')');
        }
        for (int i13 = 1; i13 < i11; i13++) {
            long j11 = i13;
            byte bY2 = Y(j11);
            if ((bY2 & 192) != 128) {
                skip(j11);
                return 65533;
            }
            i10 = (i10 << 6) | (bY2 & 63);
        }
        skip(j10);
        if (i10 > 1114111) {
            return 65533;
        }
        if ((55296 > i10 || i10 >= 57344) && i10 >= i12) {
            return i10;
        }
        return 65533;
    }

    public final C0966d V(C0966d out, long offset, long byteCount) {
        kotlin.jvm.internal.p.i(out, "out");
        long j10 = offset;
        C0963a.b(getSize(), j10, byteCount);
        if (byteCount != 0) {
            out.a1(out.getSize() + byteCount);
            E e10 = this.head;
            while (true) {
                kotlin.jvm.internal.p.f(e10);
                int i10 = e10.limit;
                int i11 = e10.pos;
                if (j10 < i10 - i11) {
                    break;
                }
                j10 -= i10 - i11;
                e10 = e10.next;
            }
            E e11 = e10;
            long j11 = byteCount;
            while (j11 > 0) {
                kotlin.jvm.internal.p.f(e11);
                E eD = e11.d();
                int i12 = eD.pos + ((int) j10);
                eD.pos = i12;
                eD.limit = Math.min(i12 + ((int) j11), eD.limit);
                E e12 = out.head;
                if (e12 == null) {
                    eD.prev = eD;
                    eD.next = eD;
                    out.head = eD;
                } else {
                    kotlin.jvm.internal.p.f(e12);
                    E e13 = e12.prev;
                    kotlin.jvm.internal.p.f(e13);
                    e13.c(eD);
                }
                j11 -= eD.limit - eD.pos;
                e11 = e11.next;
                j10 = 0;
            }
        }
        return this;
    }

    @Override // Mb.InterfaceC0967e
    public long V0(I source) throws IOException {
        kotlin.jvm.internal.p.i(source, "source");
        long j10 = 0;
        while (true) {
            long jU0 = source.u0(this, 8192L);
            if (jU0 == -1) {
                return j10;
            }
            j10 += jU0;
        }
    }

    public final byte Y(long pos) {
        C0963a.b(getSize(), pos, 1L);
        E e10 = this.head;
        if (e10 == null) {
            kotlin.jvm.internal.p.f(null);
            throw null;
        }
        if (getSize() - pos < pos) {
            long size = getSize();
            while (size > pos) {
                e10 = e10.prev;
                kotlin.jvm.internal.p.f(e10);
                size -= e10.limit - e10.pos;
            }
            kotlin.jvm.internal.p.f(e10);
            return e10.data[(int) ((e10.pos + pos) - size)];
        }
        long j10 = 0;
        while (true) {
            long j11 = (e10.limit - e10.pos) + j10;
            if (j11 > pos) {
                kotlin.jvm.internal.p.f(e10);
                return e10.data[(int) ((e10.pos + pos) - j10)];
            }
            e10 = e10.next;
            kotlin.jvm.internal.p.f(e10);
            j10 = j11;
        }
    }

    public String Y0() {
        return T0(this.size, C0953c.UTF_8);
    }

    @Override // Mb.InterfaceC0968f
    public C0966d a() {
        return this;
    }

    public final void a1(long j10) {
        this.size = j10;
    }

    public final ByteString b1() {
        if (getSize() <= 2147483647L) {
            return f1((int) getSize());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + getSize()).toString());
    }

    @Override // Mb.I
    public J c() {
        return J.f4694f;
    }

    @Override // Mb.InterfaceC0968f
    public long c1(G sink) throws IOException {
        kotlin.jvm.internal.p.i(sink, "sink");
        long size = getSize();
        if (size > 0) {
            sink.K(this, size);
        }
        return size;
    }

    @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public long e0(ByteString bytes, long fromIndex) throws IOException {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        return g0(bytes, fromIndex, Long.MAX_VALUE);
    }

    @Override // Mb.InterfaceC0968f
    public int e1() throws EOFException {
        return C0963a.c(readInt());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof C0966d)) {
            return false;
        }
        C0966d c0966d = (C0966d) other;
        if (getSize() != c0966d.getSize()) {
            return false;
        }
        if (getSize() == 0) {
            return true;
        }
        E e10 = this.head;
        kotlin.jvm.internal.p.f(e10);
        E e11 = c0966d.head;
        kotlin.jvm.internal.p.f(e11);
        int i10 = e10.pos;
        int i11 = e11.pos;
        long j10 = 0;
        while (j10 < getSize()) {
            long jMin = Math.min(e10.limit - i10, e11.limit - i11);
            long j11 = 0;
            while (j11 < jMin) {
                int i12 = i10 + 1;
                int i13 = i11 + 1;
                if (e10.data[i10] != e11.data[i11]) {
                    return false;
                }
                j11++;
                i10 = i12;
                i11 = i13;
            }
            if (i10 == e10.limit) {
                e10 = e10.next;
                kotlin.jvm.internal.p.f(e10);
                i10 = e10.pos;
            }
            if (i11 == e11.limit) {
                e11 = e11.next;
                kotlin.jvm.internal.p.f(e11);
                i11 = e11.pos;
            }
            j10 += jMin;
        }
        return true;
    }

    public final ByteString f1(int byteCount) {
        if (byteCount == 0) {
            return ByteString.f37756e;
        }
        C0963a.b(getSize(), 0L, byteCount);
        E e10 = this.head;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < byteCount) {
            kotlin.jvm.internal.p.f(e10);
            int i13 = e10.limit;
            int i14 = e10.pos;
            if (i13 == i14) {
                throw new AssertionError("s.limit == s.pos");
            }
            i11 += i13 - i14;
            i12++;
            e10 = e10.next;
        }
        byte[][] bArr = new byte[i12][];
        int[] iArr = new int[i12 * 2];
        E e11 = this.head;
        int i15 = 0;
        while (i10 < byteCount) {
            kotlin.jvm.internal.p.f(e11);
            bArr[i15] = e11.data;
            i10 += e11.limit - e11.pos;
            iArr[i15] = Math.min(i10, byteCount);
            iArr[i15 + i12] = e11.pos;
            e11.shared = true;
            i15++;
            e11 = e11.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // Mb.InterfaceC0967e, Mb.G, java.io.Flushable
    public void flush() {
    }

    public final void g() throws EOFException {
        skip(getSize());
    }

    public long g0(ByteString bytes, long fromIndex, long toIndex) throws IOException {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        return Nb.a.c(this, bytes, fromIndex, toIndex, 0, 0, 24, null);
    }

    @Override // Mb.InterfaceC0968f
    public String h0() throws EOFException {
        return I(Long.MAX_VALUE);
    }

    public final E h1(int minimumCapacity) {
        if (minimumCapacity < 1 || minimumCapacity > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        E e10 = this.head;
        if (e10 != null) {
            kotlin.jvm.internal.p.f(e10);
            E e11 = e10.prev;
            kotlin.jvm.internal.p.f(e11);
            return (e11.limit + minimumCapacity > 8192 || !e11.owner) ? e11.c(F.c()) : e11;
        }
        E eC = F.c();
        this.head = eC;
        eC.prev = eC;
        eC.next = eC;
        return eC;
    }

    public int hashCode() {
        E e10 = this.head;
        if (e10 == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = e10.limit;
            for (int i12 = e10.pos; i12 < i11; i12++) {
                i10 = (i10 * 31) + e10.data[i12];
            }
            e10 = e10.next;
            kotlin.jvm.internal.p.f(e10);
        } while (e10 != this.head);
        return i10;
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0966d clone() {
        return U();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // Mb.InterfaceC0968f
    public void j(long byteCount) throws EOFException {
        if (this.size < byteCount) {
            throw new EOFException();
        }
    }

    @Override // Mb.InterfaceC0968f
    public boolean k() {
        return this.size == 0;
    }

    public long k0(ByteString targetBytes, long fromIndex) {
        int i10;
        int i11;
        kotlin.jvm.internal.p.i(targetBytes, "targetBytes");
        long size = 0;
        if (fromIndex < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + fromIndex).toString());
        }
        E e10 = this.head;
        if (e10 == null) {
            return -1L;
        }
        if (getSize() - fromIndex < fromIndex) {
            size = getSize();
            while (size > fromIndex) {
                e10 = e10.prev;
                kotlin.jvm.internal.p.f(e10);
                size -= e10.limit - e10.pos;
            }
            if (targetBytes.K() == 2) {
                byte bL = targetBytes.l(0);
                byte bL2 = targetBytes.l(1);
                while (size < getSize()) {
                    byte[] bArr = e10.data;
                    i10 = (int) ((e10.pos + fromIndex) - size);
                    int i12 = e10.limit;
                    while (i10 < i12) {
                        byte b10 = bArr[i10];
                        if (b10 == bL || b10 == bL2) {
                            i11 = e10.pos;
                        } else {
                            i10++;
                        }
                    }
                    size += e10.limit - e10.pos;
                    e10 = e10.next;
                    kotlin.jvm.internal.p.f(e10);
                    fromIndex = size;
                }
            } else {
                byte[] bArrX = targetBytes.x();
                while (size < getSize()) {
                    byte[] bArr2 = e10.data;
                    i10 = (int) ((e10.pos + fromIndex) - size);
                    int i13 = e10.limit;
                    while (i10 < i13) {
                        byte b11 = bArr2[i10];
                        for (byte b12 : bArrX) {
                            if (b11 == b12) {
                                i11 = e10.pos;
                            }
                        }
                        i10++;
                    }
                    size += e10.limit - e10.pos;
                    e10 = e10.next;
                    kotlin.jvm.internal.p.f(e10);
                    fromIndex = size;
                }
            }
            return -1L;
        }
        while (true) {
            long j10 = (e10.limit - e10.pos) + size;
            if (j10 > fromIndex) {
                break;
            }
            e10 = e10.next;
            kotlin.jvm.internal.p.f(e10);
            size = j10;
        }
        if (targetBytes.K() == 2) {
            byte bL3 = targetBytes.l(0);
            byte bL4 = targetBytes.l(1);
            while (size < getSize()) {
                byte[] bArr3 = e10.data;
                i10 = (int) ((e10.pos + fromIndex) - size);
                int i14 = e10.limit;
                while (i10 < i14) {
                    byte b13 = bArr3[i10];
                    if (b13 == bL3 || b13 == bL4) {
                        i11 = e10.pos;
                    } else {
                        i10++;
                    }
                }
                size += e10.limit - e10.pos;
                e10 = e10.next;
                kotlin.jvm.internal.p.f(e10);
                fromIndex = size;
            }
        } else {
            byte[] bArrX2 = targetBytes.x();
            while (size < getSize()) {
                byte[] bArr4 = e10.data;
                i10 = (int) ((e10.pos + fromIndex) - size);
                int i15 = e10.limit;
                while (i10 < i15) {
                    byte b14 = bArr4[i10];
                    for (byte b15 : bArrX2) {
                        if (b14 == b15) {
                            i11 = e10.pos;
                        }
                    }
                    i10++;
                }
                size += e10.limit - e10.pos;
                e10 = e10.next;
                kotlin.jvm.internal.p.f(e10);
                fromIndex = size;
            }
        }
        return -1L;
        return (i10 - i11) + size;
    }

    @Override // Mb.InterfaceC0967e
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public C0966d j1(ByteString byteString) {
        kotlin.jvm.internal.p.i(byteString, "byteString");
        byteString.R(this, 0, byteString.K());
        return this;
    }

    @Override // Mb.InterfaceC0968f
    public short l0() throws EOFException {
        return C0963a.e(readShort());
    }

    @Override // Mb.InterfaceC0967e
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public C0966d write(byte[] source) {
        kotlin.jvm.internal.p.i(source, "source");
        return write(source, 0, source.length);
    }

    @Override // Mb.InterfaceC0967e
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public C0966d write(byte[] source, int offset, int byteCount) {
        kotlin.jvm.internal.p.i(source, "source");
        long j10 = byteCount;
        C0963a.b(source.length, offset, j10);
        int i10 = byteCount + offset;
        while (offset < i10) {
            E eH1 = h1(1);
            int iMin = Math.min(i10 - offset, 8192 - eH1.limit);
            int i11 = offset + iMin;
            C1168p.e(source, eH1.data, eH1.limit, offset, i11);
            eH1.limit += iMin;
            offset = i11;
        }
        a1(getSize() + j10);
        return this;
    }

    public final long n() {
        long size = getSize();
        if (size == 0) {
            return 0L;
        }
        E e10 = this.head;
        kotlin.jvm.internal.p.f(e10);
        E e11 = e10.prev;
        kotlin.jvm.internal.p.f(e11);
        return (e11.limit >= 8192 || !e11.owner) ? size : size - (r2 - e11.pos);
    }

    @Override // Mb.InterfaceC0968f
    public long o0() throws EOFException {
        return C0963a.d(readLong());
    }

    @Override // Mb.InterfaceC0967e
    public OutputStream o1() {
        return new b();
    }

    @Override // Mb.InterfaceC0968f
    public int p0(x options) throws EOFException {
        kotlin.jvm.internal.p.i(options, "options");
        int i10 = Nb.a.i(this, options, false, 2, null);
        if (i10 == -1) {
            return -1;
        }
        skip(options.getByteStrings()[i10].K());
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7 A[EDGE_INSN: B:43:0x00a7->B:37:0x00a7 BREAK  A[LOOP:0: B:5:0x000d->B:45:?], SYNTHETIC] */
    @Override // Mb.InterfaceC0968f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long p1() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.getSize()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb1
            r0 = 0
            r1 = r0
            r4 = r2
        Ld:
            Mb.E r6 = r14.head
            kotlin.jvm.internal.p.f(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L18:
            if (r8 >= r9) goto L93
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L27
            r11 = 57
            if (r10 > r11) goto L27
            int r11 = r10 + (-48)
            goto L3c
        L27:
            r11 = 97
            if (r10 < r11) goto L32
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L32
            int r11 = r10 + (-87)
            goto L3c
        L32:
            r11 = 65
            if (r10 < r11) goto L74
            r11 = 70
            if (r10 > r11) goto L74
            int r11 = r10 + (-55)
        L3c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4c
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L4c:
            Mb.d r14 = new Mb.d
            r14.<init>()
            Mb.d r14 = r14.W0(r4)
            Mb.d r14 = r14.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r14 = r14.Y0()
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            r0.<init>(r14)
            throw r0
        L74:
            if (r0 == 0) goto L78
            r1 = 1
            goto L93
        L78:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = Mb.C0963a.f(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L93:
            if (r8 != r9) goto L9f
            Mb.E r7 = r6.b()
            r14.head = r7
            Mb.F.b(r6)
            goto La1
        L9f:
            r6.pos = r8
        La1:
            if (r1 != 0) goto La7
            Mb.E r6 = r14.head
            if (r6 != 0) goto Ld
        La7:
            long r1 = r14.getSize()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.a1(r1)
            return r4
        Lb1:
            java.io.EOFException r14 = new java.io.EOFException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: Mb.C0966d.p1():long");
    }

    @Override // Mb.InterfaceC0968f
    public InterfaceC0968f peek() {
        return u.c(new A(this));
    }

    @Override // Mb.InterfaceC0968f
    public InputStream r1() {
        return new a();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) throws IOException {
        kotlin.jvm.internal.p.i(sink, "sink");
        E e10 = this.head;
        if (e10 == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), e10.limit - e10.pos);
        sink.put(e10.data, e10.pos, iMin);
        int i10 = e10.pos + iMin;
        e10.pos = i10;
        this.size -= iMin;
        if (i10 == e10.limit) {
            this.head = e10.b();
            F.b(e10);
        }
        return iMin;
    }

    @Override // Mb.InterfaceC0968f
    public byte readByte() throws EOFException {
        if (getSize() == 0) {
            throw new EOFException();
        }
        E e10 = this.head;
        kotlin.jvm.internal.p.f(e10);
        int i10 = e10.pos;
        int i11 = e10.limit;
        int i12 = i10 + 1;
        byte b10 = e10.data[i10];
        a1(getSize() - 1);
        if (i12 != i11) {
            e10.pos = i12;
            return b10;
        }
        this.head = e10.b();
        F.b(e10);
        return b10;
    }

    @Override // Mb.InterfaceC0968f
    public int readInt() throws EOFException {
        if (getSize() < 4) {
            throw new EOFException();
        }
        E e10 = this.head;
        kotlin.jvm.internal.p.f(e10);
        int i10 = e10.pos;
        int i11 = e10.limit;
        if (i11 - i10 < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = e10.data;
        int i12 = i10 + 3;
        int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
        int i14 = i10 + 4;
        int i15 = (bArr[i12] & 255) | i13;
        a1(getSize() - 4);
        if (i14 != i11) {
            e10.pos = i14;
            return i15;
        }
        this.head = e10.b();
        F.b(e10);
        return i15;
    }

    public long readLong() throws EOFException {
        if (getSize() < 8) {
            throw new EOFException();
        }
        E e10 = this.head;
        kotlin.jvm.internal.p.f(e10);
        int i10 = e10.pos;
        int i11 = e10.limit;
        if (i11 - i10 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = e10.data;
        int i12 = i10 + 7;
        long j10 = ((bArr[i10] & 255) << 56) | ((bArr[i10 + 1] & 255) << 48) | ((bArr[i10 + 2] & 255) << 40) | ((bArr[i10 + 3] & 255) << 32) | ((bArr[i10 + 4] & 255) << 24) | ((bArr[i10 + 5] & 255) << 16) | ((bArr[i10 + 6] & 255) << 8);
        int i13 = i10 + 8;
        long j11 = j10 | (bArr[i12] & 255);
        a1(getSize() - 8);
        if (i13 != i11) {
            e10.pos = i13;
            return j11;
        }
        this.head = e10.b();
        F.b(e10);
        return j11;
    }

    @Override // Mb.InterfaceC0968f
    public short readShort() throws EOFException {
        if (getSize() < 2) {
            throw new EOFException();
        }
        E e10 = this.head;
        kotlin.jvm.internal.p.f(e10);
        int i10 = e10.pos;
        int i11 = e10.limit;
        if (i11 - i10 < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = e10.data;
        int i12 = i10 + 1;
        int i13 = (bArr[i10] & 255) << 8;
        int i14 = i10 + 2;
        int i15 = (bArr[i12] & 255) | i13;
        a1(getSize() - 2);
        if (i14 == i11) {
            this.head = e10.b();
            F.b(e10);
        } else {
            e10.pos = i14;
        }
        return (short) i15;
    }

    @Override // Mb.InterfaceC0968f
    public boolean request(long byteCount) {
        return this.size >= byteCount;
    }

    @Override // Mb.InterfaceC0967e
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public C0966d writeByte(int b10) {
        E eH1 = h1(1);
        byte[] bArr = eH1.data;
        int i10 = eH1.limit;
        eH1.limit = i10 + 1;
        bArr[i10] = (byte) b10;
        a1(getSize() + 1);
        return this;
    }

    /* renamed from: size, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    @Override // Mb.InterfaceC0968f
    public void skip(long byteCount) throws EOFException {
        while (byteCount > 0) {
            E e10 = this.head;
            if (e10 == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(byteCount, e10.limit - e10.pos);
            long j10 = iMin;
            a1(getSize() - j10);
            byteCount -= j10;
            int i10 = e10.pos + iMin;
            e10.pos = i10;
            if (i10 == e10.limit) {
                this.head = e10.b();
                F.b(e10);
            }
        }
    }

    @Override // Mb.InterfaceC0967e
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public C0966d s0(long v10) {
        boolean z10;
        if (v10 == 0) {
            return writeByte(48);
        }
        if (v10 < 0) {
            v10 = -v10;
            if (v10 < 0) {
                return L("-9223372036854775808");
            }
            z10 = true;
        } else {
            z10 = false;
        }
        int iD = Nb.a.d(v10);
        if (z10) {
            iD++;
        }
        E eH1 = h1(iD);
        byte[] bArr = eH1.data;
        int i10 = eH1.limit + iD;
        while (v10 != 0) {
            long j10 = 10;
            i10--;
            bArr[i10] = Nb.a.e()[(int) (v10 % j10)];
            v10 /= j10;
        }
        if (z10) {
            bArr[i10 - 1] = 45;
        }
        eH1.limit += iD;
        a1(getSize() + iD);
        return this;
    }

    public String toString() {
        return b1().toString();
    }

    @Override // Mb.InterfaceC0968f
    public C0966d u() {
        return this;
    }

    @Override // Mb.I
    public long u0(C0966d sink, long byteCount) {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (getSize() == 0) {
            return -1L;
        }
        if (byteCount > getSize()) {
            byteCount = getSize();
        }
        sink.K(this, byteCount);
        return byteCount;
    }

    @Override // Mb.InterfaceC0967e
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public C0966d W0(long v10) {
        if (v10 == 0) {
            return writeByte(48);
        }
        long j10 = (v10 >>> 1) | v10;
        long j11 = j10 | (j10 >>> 2);
        long j12 = j11 | (j11 >>> 4);
        long j13 = j12 | (j12 >>> 8);
        long j14 = j13 | (j13 >>> 16);
        long j15 = j14 | (j14 >>> 32);
        long j16 = j15 - ((j15 >>> 1) & 6148914691236517205L);
        long j17 = ((j16 >>> 2) & 3689348814741910323L) + (j16 & 3689348814741910323L);
        long j18 = ((j17 >>> 4) + j17) & 1085102592571150095L;
        long j19 = j18 + (j18 >>> 8);
        long j20 = j19 + (j19 >>> 16);
        int i10 = (int) ((((j20 & 63) + ((j20 >>> 32) & 63)) + 3) / 4);
        E eH1 = h1(i10);
        byte[] bArr = eH1.data;
        int i11 = eH1.limit;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = Nb.a.e()[(int) (15 & v10)];
            v10 >>>= 4;
        }
        eH1.limit += i10;
        a1(getSize() + i10);
        return this;
    }

    public boolean v0(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        return byteCount >= 0 && offset >= 0 && ((long) byteCount) + offset <= getSize() && bytesOffset >= 0 && bytesOffset + byteCount <= bytes.K() && (byteCount == 0 || Nb.a.b(this, bytes, offset, offset + 1, bytesOffset, byteCount) != -1);
    }

    @Override // Mb.InterfaceC0967e
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public C0966d writeInt(int i10) {
        E eH1 = h1(4);
        byte[] bArr = eH1.data;
        int i11 = eH1.limit;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        eH1.limit = i11 + 4;
        a1(getSize() + 4);
        return this;
    }

    @Override // Mb.InterfaceC0967e
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public C0966d writeShort(int s10) {
        E eH1 = h1(2);
        byte[] bArr = eH1.data;
        int i10 = eH1.limit;
        bArr[i10] = (byte) ((s10 >>> 8) & 255);
        bArr[i10 + 1] = (byte) (s10 & 255);
        eH1.limit = i10 + 2;
        a1(getSize() + 2);
        return this;
    }

    @Override // Mb.InterfaceC0968f
    public String x0(long byteCount) throws EOFException {
        return T0(byteCount, C0953c.UTF_8);
    }

    public C0966d x1(String string, int beginIndex, int endIndex, Charset charset) {
        kotlin.jvm.internal.p.i(string, "string");
        kotlin.jvm.internal.p.i(charset, "charset");
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (endIndex < beginIndex) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (endIndex > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        if (kotlin.jvm.internal.p.d(charset, C0953c.UTF_8)) {
            return R(string, beginIndex, endIndex);
        }
        String strSubstring = string.substring(beginIndex, endIndex);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        byte[] bytes = strSubstring.getBytes(charset);
        kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
        return write(bytes, 0, bytes.length);
    }

    public final C0966d y1(OutputStream out, long byteCount) throws IOException {
        kotlin.jvm.internal.p.i(out, "out");
        C0963a.b(this.size, 0L, byteCount);
        E e10 = this.head;
        long j10 = byteCount;
        while (j10 > 0) {
            kotlin.jvm.internal.p.f(e10);
            int iMin = (int) Math.min(j10, e10.limit - e10.pos);
            out.write(e10.data, e10.pos, iMin);
            int i10 = e10.pos + iMin;
            e10.pos = i10;
            long j11 = iMin;
            this.size -= j11;
            j10 -= j11;
            if (i10 == e10.limit) {
                E eB = e10.b();
                this.head = eB;
                F.b(e10);
                e10 = eB;
            }
        }
        return this;
    }

    @Override // Mb.InterfaceC0968f
    public ByteString z0(long byteCount) throws EOFException {
        if (byteCount < 0 || byteCount > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (getSize() < byteCount) {
            throw new EOFException();
        }
        if (byteCount < 4096) {
            return new ByteString(I0(byteCount));
        }
        ByteString byteStringF1 = f1((int) byteCount);
        skip(byteCount);
        return byteStringF1;
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Mb/d$a", "Ljava/io/InputStream;", "", "read", "()I", "", "sink", "offset", "byteCount", "([BII)I", "available", "LY8/t;", "close", "()V", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Mb.d$a */
    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(C0966d.this.getSize(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (C0966d.this.getSize() > 0) {
                return C0966d.this.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return C0966d.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] sink, int offset, int byteCount) {
            kotlin.jvm.internal.p.i(sink, "sink");
            return C0966d.this.read(sink, offset, byteCount);
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) throws IOException {
        kotlin.jvm.internal.p.i(source, "source");
        int iRemaining = source.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            E eH1 = h1(1);
            int iMin = Math.min(i10, 8192 - eH1.limit);
            source.get(eH1.data, eH1.limit, iMin);
            i10 -= iMin;
            eH1.limit += iMin;
        }
        this.size += iRemaining;
        return iRemaining;
    }

    public int read(byte[] sink, int offset, int byteCount) {
        kotlin.jvm.internal.p.i(sink, "sink");
        C0963a.b(sink.length, offset, byteCount);
        E e10 = this.head;
        if (e10 == null) {
            return -1;
        }
        int iMin = Math.min(byteCount, e10.limit - e10.pos);
        byte[] bArr = e10.data;
        int i10 = e10.pos;
        C1168p.e(bArr, sink, offset, i10, i10 + iMin);
        e10.pos += iMin;
        a1(getSize() - iMin);
        if (e10.pos == e10.limit) {
            this.head = e10.b();
            F.b(e10);
        }
        return iMin;
    }
}
