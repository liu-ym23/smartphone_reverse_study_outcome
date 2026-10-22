package android.view;

import Z7.d;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.constraintlayout.core.dsl.a;
import androidx.core.os.BundleCompat;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\n\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010$\n\u0002\b\f\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0001\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0019\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010 \u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u001fJ\u0015\u0010&\u001a\u00020#2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010)\u001a\u0004\u0018\u00010#2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b'\u0010(J\u0015\u0010-\u001a\u00020*2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u0004\u0018\u00010*2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b.\u0010/J\u0015\u00104\u001a\u0002012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b2\u00103J\u0017\u00107\u001a\u0004\u0018\u0001012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b5\u00106J\u0015\u0010;\u001a\u0002082\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b9\u0010:J\u0017\u0010>\u001a\u0004\u0018\u0001082\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b<\u0010=J-\u0010E\u001a\u00028\u0000\"\b\b\u0000\u0010@*\u00020?2\u0006\u0010\b\u001a\u00020\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0004\bC\u0010DJ$\u0010E\u001a\u00028\u0000\"\n\b\u0000\u0010@\u0018\u0001*\u00020?2\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\bC\u0010FJ/\u0010H\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010@*\u00020?2\u0006\u0010\b\u001a\u00020\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0004\bG\u0010DJ&\u0010H\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010@\u0018\u0001*\u00020?2\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\bG\u0010FJ-\u0010M\u001a\u00028\u0000\"\b\b\u0000\u0010@*\u00020I2\u0006\u0010\b\u001a\u00020\u00072\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0004\bK\u0010LJ$\u0010M\u001a\u00028\u0000\"\n\b\u0000\u0010@\u0018\u0001*\u00020I2\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\bK\u0010NJ/\u0010P\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010@*\u00020I2\u0006\u0010\b\u001a\u00020\u00072\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0004\bO\u0010LJ&\u0010P\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010@\u0018\u0001*\u00020I2\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\bO\u0010NJ\u0015\u0010T\u001a\u00020Q2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bR\u0010SJ\u0017\u0010V\u001a\u0004\u0018\u00010Q2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bU\u0010SJ\u0015\u0010Z\u001a\u00020W2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bX\u0010YJ\u0017\u0010\\\u001a\u0004\u0018\u00010W2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b[\u0010YJ\u001f\u0010`\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030]2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b^\u0010_J!\u0010b\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010]2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\ba\u0010_J\u0015\u0010e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bc\u0010dJ\u0017\u0010g\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bf\u0010dJ\u001b\u0010k\u001a\b\u0012\u0004\u0012\u0002010h2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bi\u0010jJ\u001d\u0010m\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010h2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bl\u0010jJ\u001b\u0010o\u001a\b\u0012\u0004\u0012\u00020\u001d0h2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bn\u0010jJ\u001d\u0010q\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010h2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bp\u0010jJ\u001f\u0010s\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030h2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\br\u0010jJ!\u0010u\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010h2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bt\u0010jJ\u001b\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00070h2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bv\u0010jJ\u001d\u0010y\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010h2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bx\u0010jJ3\u0010|\u001a\b\u0012\u0004\u0012\u00028\u00000h\"\b\b\u0000\u0010@*\u00020?2\u0006\u0010\b\u001a\u00020\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0004\bz\u0010{J*\u0010|\u001a\b\u0012\u0004\u0012\u00028\u00000h\"\n\b\u0000\u0010@\u0018\u0001*\u00020?2\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\bz\u0010jJ5\u0010~\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010h\"\b\b\u0000\u0010@*\u00020?2\u0006\u0010\b\u001a\u00020\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0004\b}\u0010{J,\u0010~\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010h\"\n\b\u0000\u0010@\u0018\u0001*\u00020?2\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b}\u0010jJ\u0018\u0010\u0082\u0001\u001a\u00020\u007f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001a\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u007f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u0083\u0001\u0010\u0081\u0001J\u0019\u0010\u0088\u0001\u001a\u00030\u0085\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001b\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0085\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u0089\u0001\u0010\u0087\u0001J\u001e\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0]2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J \u0010\u008f\u0001\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010]2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u008e\u0001\u0010\u008c\u0001J\u0019\u0010\u0093\u0001\u001a\u00030\u0090\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001b\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0090\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u0094\u0001\u0010\u0092\u0001J\u0019\u0010\u0099\u0001\u001a\u00030\u0096\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u001b\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u009a\u0001\u0010\u0098\u0001J\u0019\u0010\u009f\u0001\u001a\u00030\u009c\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u001b\u0010¡\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b \u0001\u0010\u009e\u0001J\u0019\u0010¥\u0001\u001a\u00030¢\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u001b\u0010§\u0001\u001a\u0005\u0018\u00010¢\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b¦\u0001\u0010¤\u0001J\u001e\u0010ª\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070]2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b¨\u0001\u0010©\u0001J \u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010]2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b«\u0001\u0010©\u0001J6\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000]\"\b\b\u0000\u0010@*\u00020?2\u0006\u0010\b\u001a\u00020\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J-\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000]\"\n\b\u0000\u0010@\u0018\u0001*\u00020?2\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0006\b\u00ad\u0001\u0010°\u0001J8\u0010²\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010]\"\b\b\u0000\u0010@*\u00020?2\u0006\u0010\b\u001a\u00020\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0006\b±\u0001\u0010®\u0001J/\u0010²\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010]\"\n\b\u0000\u0010@\u0018\u0001*\u00020?2\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0006\b±\u0001\u0010°\u0001J7\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000³\u0001\"\b\b\u0000\u0010@*\u00020?2\u0006\u0010\b\u001a\u00020\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0006\b´\u0001\u0010µ\u0001J.\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000³\u0001\"\n\b\u0000\u0010@\u0018\u0001*\u00020?2\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0006\b´\u0001\u0010·\u0001J9\u0010¹\u0001\u001a\u000b\u0012\u0004\u0012\u00028\u0000\u0018\u00010³\u0001\"\b\b\u0000\u0010@*\u00020?2\u0006\u0010\b\u001a\u00020\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0006\b¸\u0001\u0010µ\u0001J0\u0010¹\u0001\u001a\u000b\u0012\u0004\u0012\u00028\u0000\u0018\u00010³\u0001\"\n\b\u0000\u0010@\u0018\u0001*\u00020?2\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0006\b¸\u0001\u0010·\u0001J\u001c\u0010¼\u0001\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\bº\u0001\u0010»\u0001J \u0010¾\u0001\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b½\u0001\u0010»\u0001J\u0010\u0010Á\u0001\u001a\u000201¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u0010\u0010Ä\u0001\u001a\u00020\u000f¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u0017\u0010Æ\u0001\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0005\bÅ\u0001\u0010\u0011J\u001a\u0010È\u0001\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0005\bÇ\u0001\u0010\u0011J\u001d\u0010Ì\u0001\u001a\u00020\u000f2\u000b\u0010É\u0001\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J\u0010\u0010Î\u0001\u001a\u000201¢\u0006\u0006\bÍ\u0001\u0010À\u0001J\u0010\u0010Ñ\u0001\u001a\u00020\u0007¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J\u001f\u0010Õ\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010Ò\u0001¢\u0006\u0006\bÓ\u0001\u0010Ô\u0001J\u0013\u0010×\u0001\u001a\u00020\u0007HÖ\u0001¢\u0006\u0006\bÖ\u0001\u0010Ð\u0001J\u0013\u0010Ù\u0001\u001a\u000201HÖ\u0001¢\u0006\u0006\bØ\u0001\u0010À\u0001J\u001e\u0010Ü\u0001\u001a\u00020\u000f2\t\u0010É\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0006\bÚ\u0001\u0010Û\u0001R\u0019\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0004\u0010Ý\u0001\u0088\u0001\u0004\u0092\u0001\u00060\u0002j\u0002`\u0003¨\u0006Þ\u0001"}, d2 = {"Landroidx/savedstate/SavedStateReader;", "", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", AgentBusWakeContract.EXTRA_SOURCE, "constructor-impl", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "", "key", "Landroid/os/IBinder;", "getBinder-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/IBinder;", "getBinder", "getBinderOrNull-impl", "getBinderOrNull", "", "getBoolean-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Z", "getBoolean", "getBooleanOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Boolean;", "getBooleanOrNull", "", "getChar-impl", "(Landroid/os/Bundle;Ljava/lang/String;)C", "getChar", "getCharOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Character;", "getCharOrNull", "", "getCharSequence-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/CharSequence;", "getCharSequence", "getCharSequenceOrNull-impl", "getCharSequenceOrNull", "", "getDouble-impl", "(Landroid/os/Bundle;Ljava/lang/String;)D", "getDouble", "getDoubleOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Double;", "getDoubleOrNull", "", "getFloat-impl", "(Landroid/os/Bundle;Ljava/lang/String;)F", "getFloat", "getFloatOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Float;", "getFloatOrNull", "", "getInt-impl", "(Landroid/os/Bundle;Ljava/lang/String;)I", "getInt", "getIntOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "getIntOrNull", "", "getLong-impl", "(Landroid/os/Bundle;Ljava/lang/String;)J", "getLong", "getLongOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Long;", "getLongOrNull", "Landroid/os/Parcelable;", ExifInterface.GPS_DIRECTION_TRUE, "LZ7/d;", "parcelableClass", "getParcelable-impl", "(Landroid/os/Bundle;Ljava/lang/String;LZ7/d;)Landroid/os/Parcelable;", "getParcelable", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "getParcelableOrNull-impl", "getParcelableOrNull", "Ljava/io/Serializable;", "serializableClass", "getJavaSerializable-impl", "(Landroid/os/Bundle;Ljava/lang/String;LZ7/d;)Ljava/io/Serializable;", "getJavaSerializable", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "getJavaSerializableOrNull-impl", "getJavaSerializableOrNull", "Landroid/util/Size;", "getSize-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/Size;", "getSize", "getSizeOrNull-impl", "getSizeOrNull", "Landroid/util/SizeF;", "getSizeF-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/SizeF;", "getSizeF", "getSizeFOrNull-impl", "getSizeFOrNull", "", "getSavedStateArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Bundle;", "getSavedStateArray", "getSavedStateArrayOrNull-impl", "getSavedStateArrayOrNull", "getString-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;", "getString", "getStringOrNull-impl", "getStringOrNull", "", "getIntList-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/List;", "getIntList", "getIntListOrNull-impl", "getIntListOrNull", "getCharSequenceList-impl", "getCharSequenceList", "getCharSequenceListOrNull-impl", "getCharSequenceListOrNull", "getSavedStateList-impl", "getSavedStateList", "getSavedStateListOrNull-impl", "getSavedStateListOrNull", "getStringList-impl", "getStringList", "getStringListOrNull-impl", "getStringListOrNull", "getParcelableList-impl", "(Landroid/os/Bundle;Ljava/lang/String;LZ7/d;)Ljava/util/List;", "getParcelableList", "getParcelableListOrNull-impl", "getParcelableListOrNull", "", "getBooleanArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Z", "getBooleanArray", "getBooleanArrayOrNull-impl", "getBooleanArrayOrNull", "", "getCharArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[C", "getCharArray", "getCharArrayOrNull-impl", "getCharArrayOrNull", "getCharSequenceArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/CharSequence;", "getCharSequenceArray", "getCharSequenceArrayOrNull-impl", "getCharSequenceArrayOrNull", "", "getDoubleArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[D", "getDoubleArray", "getDoubleArrayOrNull-impl", "getDoubleArrayOrNull", "", "getFloatArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[F", "getFloatArray", "getFloatArrayOrNull-impl", "getFloatArrayOrNull", "", "getIntArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[I", "getIntArray", "getIntArrayOrNull-impl", "getIntArrayOrNull", "", "getLongArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[J", "getLongArray", "getLongArrayOrNull-impl", "getLongArrayOrNull", "getStringArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/String;", "getStringArray", "getStringArrayOrNull-impl", "getStringArrayOrNull", "getParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;LZ7/d;)[Landroid/os/Parcelable;", "getParcelableArray", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "getParcelableArrayOrNull-impl", "getParcelableArrayOrNull", "Landroid/util/SparseArray;", "getSparseParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;LZ7/d;)Landroid/util/SparseArray;", "getSparseParcelableArray", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/SparseArray;", "getSparseParcelableArrayOrNull-impl", "getSparseParcelableArrayOrNull", "getSavedState-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Bundle;", "getSavedState", "getSavedStateOrNull-impl", "getSavedStateOrNull", "size-impl", "(Landroid/os/Bundle;)I", "size", "isEmpty-impl", "(Landroid/os/Bundle;)Z", "isEmpty", "isNull-impl", "isNull", "contains-impl", "contains", "other", "contentDeepEquals-impl", "(Landroid/os/Bundle;Landroid/os/Bundle;)Z", "contentDeepEquals", "contentDeepHashCode-impl", "contentDeepHashCode", "contentDeepToString-impl", "(Landroid/os/Bundle;)Ljava/lang/String;", "contentDeepToString", "", "toMap-impl", "(Landroid/os/Bundle;)Ljava/util/Map;", "toMap", "toString-impl", "toString", "hashCode-impl", "hashCode", "equals-impl", "(Landroid/os/Bundle;Ljava/lang/Object;)Z", "equals", "Landroid/os/Bundle;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateReader {
    private final Bundle source;

    private /* synthetic */ SavedStateReader(Bundle bundle) {
        this.source = bundle;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SavedStateReader m7176boximpl(Bundle bundle) {
        return new SavedStateReader(bundle);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static Bundle m7177constructorimpl(Bundle source) {
        k.f(source, "source");
        return source;
    }

    /* renamed from: contains-impl, reason: not valid java name */
    public static final boolean m7178containsimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.containsKey(key);
    }

    /* renamed from: contentDeepEquals-impl, reason: not valid java name */
    public static final boolean m7179contentDeepEqualsimpl(Bundle bundle, Bundle other) {
        k.f(other, "other");
        return Bundle.contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(bundle, other);
    }

    /* renamed from: contentDeepHashCode-impl, reason: not valid java name */
    public static final int m7180contentDeepHashCodeimpl(Bundle bundle) {
        return Bundle.contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(bundle);
    }

    /* renamed from: contentDeepToString-impl, reason: not valid java name */
    public static final String m7181contentDeepToStringimpl(Bundle bundle) {
        int size = bundle.size();
        if (size > 429496729) {
            size = 429496729;
        }
        StringBuilder sb = new StringBuilder((size * 5) + 2);
        Bundle.contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt(bundle, sb, new ArrayList());
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7182equalsimpl(Bundle bundle, Object obj) {
        return (obj instanceof SavedStateReader) && k.b(bundle, ((SavedStateReader) obj).getSource());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7183equalsimpl0(Bundle bundle, Bundle bundle2) {
        return k.b(bundle, bundle2);
    }

    /* renamed from: getBinder-impl, reason: not valid java name */
    public static final IBinder m7184getBinderimpl(Bundle bundle, String key) {
        k.f(key, "key");
        IBinder binder = bundle.getBinder(key);
        if (binder != null) {
            return binder;
        }
        throw a.n(key);
    }

    /* renamed from: getBinderOrNull-impl, reason: not valid java name */
    public static final IBinder m7185getBinderOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getBinder(key);
    }

    /* renamed from: getBoolean-impl, reason: not valid java name */
    public static final boolean m7186getBooleanimpl(Bundle bundle, String key) {
        k.f(key, "key");
        boolean z10 = bundle.getBoolean(key, false);
        if (z10 || !bundle.getBoolean(key, true)) {
            return z10;
        }
        throw a.n(key);
    }

    /* renamed from: getBooleanArray-impl, reason: not valid java name */
    public static final boolean[] m7187getBooleanArrayimpl(Bundle bundle, String key) {
        k.f(key, "key");
        boolean[] booleanArray = bundle.getBooleanArray(key);
        if (booleanArray != null) {
            return booleanArray;
        }
        throw a.n(key);
    }

    /* renamed from: getBooleanArrayOrNull-impl, reason: not valid java name */
    public static final boolean[] m7188getBooleanArrayOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getBooleanArray(key);
    }

    /* renamed from: getBooleanOrNull-impl, reason: not valid java name */
    public static final Boolean m7189getBooleanOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        boolean z10 = bundle.getBoolean(key, false);
        if (z10 || !bundle.getBoolean(key, true)) {
            return Boolean.valueOf(z10);
        }
        return null;
    }

    /* renamed from: getChar-impl, reason: not valid java name */
    public static final char m7190getCharimpl(Bundle bundle, String key) {
        k.f(key, "key");
        char c = bundle.getChar(key, (char) 0);
        if (c == 0 && bundle.getChar(key, (char) 65535) == 65535) {
            throw a.n(key);
        }
        return c;
    }

    /* renamed from: getCharArray-impl, reason: not valid java name */
    public static final char[] m7191getCharArrayimpl(Bundle bundle, String key) {
        k.f(key, "key");
        char[] charArray = bundle.getCharArray(key);
        if (charArray != null) {
            return charArray;
        }
        throw a.n(key);
    }

    /* renamed from: getCharArrayOrNull-impl, reason: not valid java name */
    public static final char[] m7192getCharArrayOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getCharArray(key);
    }

    /* renamed from: getCharOrNull-impl, reason: not valid java name */
    public static final Character m7193getCharOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        char c = bundle.getChar(key, (char) 0);
        if (c == 0 && bundle.getChar(key, (char) 65535) == 65535) {
            return null;
        }
        return Character.valueOf(c);
    }

    /* renamed from: getCharSequence-impl, reason: not valid java name */
    public static final CharSequence m7194getCharSequenceimpl(Bundle bundle, String key) {
        k.f(key, "key");
        CharSequence charSequence = bundle.getCharSequence(key);
        if (charSequence != null) {
            return charSequence;
        }
        throw a.n(key);
    }

    /* renamed from: getCharSequenceArray-impl, reason: not valid java name */
    public static final CharSequence[] m7195getCharSequenceArrayimpl(Bundle bundle, String key) {
        k.f(key, "key");
        CharSequence[] charSequenceArray = bundle.getCharSequenceArray(key);
        if (charSequenceArray != null) {
            return charSequenceArray;
        }
        throw a.n(key);
    }

    /* renamed from: getCharSequenceArrayOrNull-impl, reason: not valid java name */
    public static final CharSequence[] m7196getCharSequenceArrayOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getCharSequenceArray(key);
    }

    /* renamed from: getCharSequenceList-impl, reason: not valid java name */
    public static final List<CharSequence> m7197getCharSequenceListimpl(Bundle bundle, String key) {
        k.f(key, "key");
        ArrayList<CharSequence> charSequenceArrayList = bundle.getCharSequenceArrayList(key);
        if (charSequenceArrayList != null) {
            return charSequenceArrayList;
        }
        throw a.n(key);
    }

    /* renamed from: getCharSequenceListOrNull-impl, reason: not valid java name */
    public static final List<CharSequence> m7198getCharSequenceListOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getCharSequenceArrayList(key);
    }

    /* renamed from: getCharSequenceOrNull-impl, reason: not valid java name */
    public static final CharSequence m7199getCharSequenceOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getCharSequence(key);
    }

    /* renamed from: getDouble-impl, reason: not valid java name */
    public static final double m7200getDoubleimpl(Bundle bundle, String key) {
        k.f(key, "key");
        double d = bundle.getDouble(key, Double.MIN_VALUE);
        if (d == Double.MIN_VALUE && bundle.getDouble(key, Double.MAX_VALUE) == Double.MAX_VALUE) {
            throw a.n(key);
        }
        return d;
    }

    /* renamed from: getDoubleArray-impl, reason: not valid java name */
    public static final double[] m7201getDoubleArrayimpl(Bundle bundle, String key) {
        k.f(key, "key");
        double[] doubleArray = bundle.getDoubleArray(key);
        if (doubleArray != null) {
            return doubleArray;
        }
        throw a.n(key);
    }

    /* renamed from: getDoubleArrayOrNull-impl, reason: not valid java name */
    public static final double[] m7202getDoubleArrayOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getDoubleArray(key);
    }

    /* renamed from: getDoubleOrNull-impl, reason: not valid java name */
    public static final Double m7203getDoubleOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        double d = bundle.getDouble(key, Double.MIN_VALUE);
        if (d == Double.MIN_VALUE && bundle.getDouble(key, Double.MAX_VALUE) == Double.MAX_VALUE) {
            return null;
        }
        return Double.valueOf(d);
    }

    /* renamed from: getFloat-impl, reason: not valid java name */
    public static final float m7204getFloatimpl(Bundle bundle, String key) {
        k.f(key, "key");
        float f = bundle.getFloat(key, Float.MIN_VALUE);
        if (f == Float.MIN_VALUE && bundle.getFloat(key, Float.MAX_VALUE) == Float.MAX_VALUE) {
            throw a.n(key);
        }
        return f;
    }

    /* renamed from: getFloatArray-impl, reason: not valid java name */
    public static final float[] m7205getFloatArrayimpl(Bundle bundle, String key) {
        k.f(key, "key");
        float[] floatArray = bundle.getFloatArray(key);
        if (floatArray != null) {
            return floatArray;
        }
        throw a.n(key);
    }

    /* renamed from: getFloatArrayOrNull-impl, reason: not valid java name */
    public static final float[] m7206getFloatArrayOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getFloatArray(key);
    }

    /* renamed from: getFloatOrNull-impl, reason: not valid java name */
    public static final Float m7207getFloatOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        float f = bundle.getFloat(key, Float.MIN_VALUE);
        if (f == Float.MIN_VALUE && bundle.getFloat(key, Float.MAX_VALUE) == Float.MAX_VALUE) {
            return null;
        }
        return Float.valueOf(f);
    }

    /* renamed from: getInt-impl, reason: not valid java name */
    public static final int m7208getIntimpl(Bundle bundle, String key) {
        k.f(key, "key");
        int i = bundle.getInt(key, Integer.MIN_VALUE);
        if (i == Integer.MIN_VALUE && bundle.getInt(key, Integer.MAX_VALUE) == Integer.MAX_VALUE) {
            throw a.n(key);
        }
        return i;
    }

    /* renamed from: getIntArray-impl, reason: not valid java name */
    public static final int[] m7209getIntArrayimpl(Bundle bundle, String key) {
        k.f(key, "key");
        int[] intArray = bundle.getIntArray(key);
        if (intArray != null) {
            return intArray;
        }
        throw a.n(key);
    }

    /* renamed from: getIntArrayOrNull-impl, reason: not valid java name */
    public static final int[] m7210getIntArrayOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getIntArray(key);
    }

    /* renamed from: getIntList-impl, reason: not valid java name */
    public static final List<Integer> m7211getIntListimpl(Bundle bundle, String key) {
        k.f(key, "key");
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(key);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        throw a.n(key);
    }

    /* renamed from: getIntListOrNull-impl, reason: not valid java name */
    public static final List<Integer> m7212getIntListOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getIntegerArrayList(key);
    }

    /* renamed from: getIntOrNull-impl, reason: not valid java name */
    public static final Integer m7213getIntOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        int i = bundle.getInt(key, Integer.MIN_VALUE);
        if (i == Integer.MIN_VALUE && bundle.getInt(key, Integer.MAX_VALUE) == Integer.MAX_VALUE) {
            return null;
        }
        return Integer.valueOf(i);
    }

    /* renamed from: getJavaSerializable-impl, reason: not valid java name */
    public static final <T extends Serializable> T m7214getJavaSerializableimpl(Bundle bundle, String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    /* renamed from: getJavaSerializableOrNull-impl, reason: not valid java name */
    public static final <T extends Serializable> T m7216getJavaSerializableOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    /* renamed from: getLong-impl, reason: not valid java name */
    public static final long m7218getLongimpl(Bundle bundle, String key) {
        k.f(key, "key");
        long j5 = bundle.getLong(key, Long.MIN_VALUE);
        if (j5 == Long.MIN_VALUE && bundle.getLong(key, Long.MAX_VALUE) == Long.MAX_VALUE) {
            throw a.n(key);
        }
        return j5;
    }

    /* renamed from: getLongArray-impl, reason: not valid java name */
    public static final long[] m7219getLongArrayimpl(Bundle bundle, String key) {
        k.f(key, "key");
        long[] longArray = bundle.getLongArray(key);
        if (longArray != null) {
            return longArray;
        }
        throw a.n(key);
    }

    /* renamed from: getLongArrayOrNull-impl, reason: not valid java name */
    public static final long[] m7220getLongArrayOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getLongArray(key);
    }

    /* renamed from: getLongOrNull-impl, reason: not valid java name */
    public static final Long m7221getLongOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        long j5 = bundle.getLong(key, Long.MIN_VALUE);
        if (j5 == Long.MIN_VALUE && bundle.getLong(key, Long.MAX_VALUE) == Long.MAX_VALUE) {
            return null;
        }
        return Long.valueOf(j5);
    }

    /* renamed from: getParcelable-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m7222getParcelableimpl(Bundle bundle, String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    /* renamed from: getParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m7224getParcelableArrayimpl(Bundle bundle, String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    /* renamed from: getParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m7226getParcelableArrayOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    /* renamed from: getParcelableList-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m7228getParcelableListimpl(Bundle bundle, String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    /* renamed from: getParcelableListOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m7230getParcelableListOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    /* renamed from: getParcelableOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m7232getParcelableOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    /* renamed from: getSavedState-impl, reason: not valid java name */
    public static final Bundle m7234getSavedStateimpl(Bundle bundle, String key) {
        k.f(key, "key");
        Bundle bundle2 = bundle.getBundle(key);
        if (bundle2 != null) {
            return bundle2;
        }
        throw a.n(key);
    }

    /* renamed from: getSavedStateArray-impl, reason: not valid java name */
    public static final Bundle[] m7235getSavedStateArrayimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return (Bundle[]) m7225getParcelableArrayimpl(bundle, key, m.f4928a.b(Bundle.class));
    }

    /* renamed from: getSavedStateArrayOrNull-impl, reason: not valid java name */
    public static final Bundle[] m7236getSavedStateArrayOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return (Bundle[]) m7227getParcelableArrayOrNullimpl(bundle, key, m.f4928a.b(Bundle.class));
    }

    /* renamed from: getSavedStateList-impl, reason: not valid java name */
    public static final List<Bundle> m7237getSavedStateListimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return m7229getParcelableListimpl(bundle, key, m.f4928a.b(Bundle.class));
    }

    /* renamed from: getSavedStateListOrNull-impl, reason: not valid java name */
    public static final List<Bundle> m7238getSavedStateListOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return m7231getParcelableListOrNullimpl(bundle, key, m.f4928a.b(Bundle.class));
    }

    /* renamed from: getSavedStateOrNull-impl, reason: not valid java name */
    public static final Bundle m7239getSavedStateOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getBundle(key);
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static final Size m7240getSizeimpl(Bundle bundle, String key) {
        k.f(key, "key");
        Size size = bundle.getSize(key);
        if (size != null) {
            return size;
        }
        throw a.n(key);
    }

    /* renamed from: getSizeF-impl, reason: not valid java name */
    public static final SizeF m7241getSizeFimpl(Bundle bundle, String key) {
        k.f(key, "key");
        SizeF sizeF = bundle.getSizeF(key);
        if (sizeF != null) {
            return sizeF;
        }
        throw a.n(key);
    }

    /* renamed from: getSizeFOrNull-impl, reason: not valid java name */
    public static final SizeF m7242getSizeFOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getSizeF(key);
    }

    /* renamed from: getSizeOrNull-impl, reason: not valid java name */
    public static final Size m7243getSizeOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getSize(key);
    }

    /* renamed from: getSparseParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m7244getSparseParcelableArrayimpl(Bundle bundle, String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    /* renamed from: getSparseParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m7246getSparseParcelableArrayOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    /* renamed from: getString-impl, reason: not valid java name */
    public static final String m7248getStringimpl(Bundle bundle, String key) {
        k.f(key, "key");
        String string = bundle.getString(key);
        if (string != null) {
            return string;
        }
        throw a.n(key);
    }

    /* renamed from: getStringArray-impl, reason: not valid java name */
    public static final String[] m7249getStringArrayimpl(Bundle bundle, String key) {
        k.f(key, "key");
        String[] stringArray = bundle.getStringArray(key);
        if (stringArray != null) {
            return stringArray;
        }
        throw a.n(key);
    }

    /* renamed from: getStringArrayOrNull-impl, reason: not valid java name */
    public static final String[] m7250getStringArrayOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getStringArray(key);
    }

    /* renamed from: getStringList-impl, reason: not valid java name */
    public static final List<String> m7251getStringListimpl(Bundle bundle, String key) {
        k.f(key, "key");
        ArrayList<String> stringArrayList = bundle.getStringArrayList(key);
        if (stringArrayList != null) {
            return stringArrayList;
        }
        throw a.n(key);
    }

    /* renamed from: getStringListOrNull-impl, reason: not valid java name */
    public static final List<String> m7252getStringListOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getStringArrayList(key);
    }

    /* renamed from: getStringOrNull-impl, reason: not valid java name */
    public static final String m7253getStringOrNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return bundle.getString(key);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7254hashCodeimpl(Bundle bundle) {
        return bundle.hashCode();
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m7255isEmptyimpl(Bundle bundle) {
        return bundle.isEmpty();
    }

    /* renamed from: isNull-impl, reason: not valid java name */
    public static final boolean m7256isNullimpl(Bundle bundle, String key) {
        k.f(key, "key");
        return m7178containsimpl(bundle, key) && bundle.get(key) == null;
    }

    /* renamed from: size-impl, reason: not valid java name */
    public static final int m7257sizeimpl(Bundle bundle) {
        return bundle.size();
    }

    /* renamed from: toMap-impl, reason: not valid java name */
    public static final Map<String, Object> m7258toMapimpl(Bundle bundle) {
        MapBuilder mapBuilder = new MapBuilder(bundle.size());
        for (String str : bundle.keySet()) {
            k.c(str);
            mapBuilder.put(str, bundle.get(str));
        }
        return mapBuilder.b();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7259toStringimpl(Bundle bundle) {
        return "SavedStateReader(source=" + bundle + ')';
    }

    public boolean equals(Object obj) {
        return m7182equalsimpl(this.source, obj);
    }

    public int hashCode() {
        return m7254hashCodeimpl(this.source);
    }

    public String toString() {
        return m7259toStringimpl(this.source);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Bundle getSource() {
        return this.source;
    }

    /* renamed from: getJavaSerializable-impl, reason: not valid java name */
    public static final <T extends Serializable> T m7215getJavaSerializableimpl(Bundle bundle, String key, d serializableClass) {
        k.f(key, "key");
        k.f(serializableClass, "serializableClass");
        T t9 = (T) BundleCompat.getSerializable(bundle, key, M.a.Z(serializableClass));
        if (t9 != null) {
            return t9;
        }
        throw a.n(key);
    }

    /* renamed from: getJavaSerializableOrNull-impl, reason: not valid java name */
    public static final <T extends Serializable> T m7217getJavaSerializableOrNullimpl(Bundle bundle, String key, d serializableClass) {
        k.f(key, "key");
        k.f(serializableClass, "serializableClass");
        return (T) BundleCompat.getSerializable(bundle, key, M.a.Z(serializableClass));
    }

    /* renamed from: getParcelable-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m7223getParcelableimpl(Bundle bundle, String key, d parcelableClass) {
        k.f(key, "key");
        k.f(parcelableClass, "parcelableClass");
        T t9 = (T) BundleCompat.getParcelable(bundle, key, M.a.Z(parcelableClass));
        if (t9 != null) {
            return t9;
        }
        throw a.n(key);
    }

    /* renamed from: getParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m7225getParcelableArrayimpl(Bundle bundle, String key, d parcelableClass) {
        k.f(key, "key");
        k.f(parcelableClass, "parcelableClass");
        T[] tArr = (T[]) m7227getParcelableArrayOrNullimpl(bundle, key, parcelableClass);
        if (tArr != null) {
            return tArr;
        }
        throw a.n(key);
    }

    /* renamed from: getParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m7227getParcelableArrayOrNullimpl(Bundle bundle, String key, d parcelableClass) {
        k.f(key, "key");
        k.f(parcelableClass, "parcelableClass");
        T[] tArr = (T[]) BundleCompat.getParcelableArray(bundle, key, M.a.Z(parcelableClass));
        if (tArr != null) {
            return tArr;
        }
        return null;
    }

    /* renamed from: getParcelableList-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m7229getParcelableListimpl(Bundle bundle, String key, d parcelableClass) {
        k.f(key, "key");
        k.f(parcelableClass, "parcelableClass");
        ArrayList parcelableArrayList = BundleCompat.getParcelableArrayList(bundle, key, M.a.Z(parcelableClass));
        if (parcelableArrayList != null) {
            return parcelableArrayList;
        }
        throw a.n(key);
    }

    /* renamed from: getParcelableListOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m7231getParcelableListOrNullimpl(Bundle bundle, String key, d parcelableClass) {
        k.f(key, "key");
        k.f(parcelableClass, "parcelableClass");
        return BundleCompat.getParcelableArrayList(bundle, key, M.a.Z(parcelableClass));
    }

    /* renamed from: getParcelableOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m7233getParcelableOrNullimpl(Bundle bundle, String key, d parcelableClass) {
        k.f(key, "key");
        k.f(parcelableClass, "parcelableClass");
        return (T) BundleCompat.getParcelable(bundle, key, M.a.Z(parcelableClass));
    }

    /* renamed from: getSparseParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m7245getSparseParcelableArrayimpl(Bundle bundle, String key, d parcelableClass) {
        k.f(key, "key");
        k.f(parcelableClass, "parcelableClass");
        SparseArray<T> sparseArrayM7247getSparseParcelableArrayOrNullimpl = m7247getSparseParcelableArrayOrNullimpl(bundle, key, parcelableClass);
        if (sparseArrayM7247getSparseParcelableArrayOrNullimpl != null) {
            return sparseArrayM7247getSparseParcelableArrayOrNullimpl;
        }
        throw a.n(key);
    }

    /* renamed from: getSparseParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m7247getSparseParcelableArrayOrNullimpl(Bundle bundle, String key, d parcelableClass) {
        k.f(key, "key");
        k.f(parcelableClass, "parcelableClass");
        return BundleCompat.getSparseParcelableArray(bundle, key, M.a.Z(parcelableClass));
    }
}
