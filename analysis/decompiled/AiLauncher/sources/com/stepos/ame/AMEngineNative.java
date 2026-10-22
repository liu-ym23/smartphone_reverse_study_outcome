package com.stepos.ame;

import E6.AMEConfig;
import E6.DeviceAvailability;
import La.H;
import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.r;
import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.trace.a;
import com.stepos.ame.api.FilterStrategy;
import com.stepos.ame.sdk.CollectionPersistConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import x5.d;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0006\n\u0002\bQ\n\u0002\u0010\u0012\n\u0002\b'\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 Ç\u00022\u00020\u0001:\u0004È\u0002É\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J8\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000bH\u0082 ¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015H\u0082 ¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\bH\u0082 ¢\u0006\u0004\b \u0010!J\u001e\u0010$\u001a\u00020#2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\"H\u0082 ¢\u0006\u0004\b$\u0010%J8\u0010(\u001a\u00020#2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\"2\u0018\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010&0\"H\u0082 ¢\u0006\u0004\b(\u0010)J,\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010*H\u0082 ¢\u0006\u0004\b \u0010,J\u0018\u0010.\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001fH\u0082 ¢\u0006\u0004\b.\u0010/J\u0018\u00101\u001a\u00020\u00102\u0006\u00100\u001a\u00020#H\u0082 ¢\u0006\u0004\b1\u00102J \u00104\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\bH\u0082 ¢\u0006\u0004\b4\u00105J&\u00106\u001a\u00020\u00102\u0006\u00100\u001a\u00020#2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\"H\u0082 ¢\u0006\u0004\b6\u00107J4\u00104\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010*H\u0082 ¢\u0006\u0004\b4\u00108J(\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\"2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\b<\u0010=J:\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\"2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010\u00042\u0006\u0010?\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\b<\u0010@J0\u0010<\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010\"2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u0015H\u0082 ¢\u0006\u0004\b<\u0010CJJ\u0010E\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010\"2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010\u00042\u0006\u0010?\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\bE\u0010FJ`\u0010I\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\"\u0018\u00010\"2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010\u00042\u0006\u0010?\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020\u001fH\u0082 ¢\u0006\u0004\bK\u0010LJ&\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010*2\u0006\u0010-\u001a\u00020\u001fH\u0082 ¢\u0006\u0004\bM\u0010NJ \u0010P\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\bP\u0010QJ\u0012\u0010R\u001a\u0004\u0018\u00010\u0004H\u0082 ¢\u0006\u0004\bR\u0010SJ\u0010\u0010T\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\bT\u0010UJ\u001a\u0010V\u001a\u0004\u0018\u00010\b2\u0006\u0010-\u001a\u00020\u001fH\u0082 ¢\u0006\u0004\bV\u0010WJ \u0010[\u001a\u00020\u00152\u0006\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020\u0015H\u0082 ¢\u0006\u0004\b[\u0010\\J\u0018\u0010^\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\u000bH\u0082 ¢\u0006\u0004\b`\u0010\u001cJ\u0018\u0010a\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\ba\u0010_J\u0018\u0010b\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\bb\u0010_J`\u0010m\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u00102\u0006\u0010e\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\u00102\u0006\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u00152\u0006\u0010j\u001a\u00020\u001f2\u0006\u0010k\u001a\u00020\u001f2\u0006\u0010l\u001a\u00020\u001fH\u0082 ¢\u0006\u0004\bm\u0010nJh\u0010p\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u00102\u0006\u0010e\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\u00102\u0006\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u00152\u0006\u0010o\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\u001f2\u0006\u0010k\u001a\u00020\u001f2\u0006\u0010l\u001a\u00020\u001fH\u0082 ¢\u0006\u0004\bp\u0010qJ@\u0010w\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u00152\u0006\u0010o\u001a\u00020\u00102\u0006\u0010s\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\u00152\u0006\u0010u\u001a\u00020\u00102\u0006\u0010v\u001a\u00020\u0015H\u0082 ¢\u0006\u0004\bw\u0010xJ@\u0010}\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u00042\u0006\u0010r\u001a\u00020\u00152\u0006\u0010y\u001a\u00020\u00102\u0006\u0010z\u001a\u00020\u00102\u0006\u0010{\u001a\u00020\u001f2\u0006\u0010|\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\b}\u0010~J\u0018\u0010\u007f\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\b\u007f\u0010_J5\u0010\u0082\u0001\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u00152\u0007\u0010\u0080\u0001\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u001f2\u0007\u0010\u0081\u0001\u001a\u00020\u001fH\u0082 ¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u001b\u0010\u0084\u0001\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020\u001fH\u0082 ¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001b\u0010\u0086\u0001\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0012\u0010\u0088\u0001\u001a\u00020\u000bH\u0082 ¢\u0006\u0005\b\u0088\u0001\u0010\u001cJ\u001a\u0010\u0089\u0001\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u0004H\u0082 ¢\u0006\u0005\b\u0089\u0001\u0010_J\u0012\u0010\u008a\u0001\u001a\u00020\u000bH\u0082 ¢\u0006\u0005\b\u008a\u0001\u0010\u001cJ\u001b\u0010\u008b\u0001\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\b\u008b\u0001\u0010\u0087\u0001J\u0019\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\"H\u0082 ¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J/\u0010\u0090\u0001\u001a\u00020\u001f2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0004H\u0082 ¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001JK\u0010\u0095\u0001\u001a\u0004\u0018\u00010#2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0007\u0010\u0092\u0001\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\u00102\u0011\u0010\u0094\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\"H\u0082 ¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J2\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\"2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u0010H\u0082 ¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001JD\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\"2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010\u00042\u0006\u0010?\u001a\u00020\u0010H\u0082 ¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001JX\u0010\u009c\u0001\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u009b\u0001\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010\u00042\u0006\u0010?\u001a\u00020\u0010H\u0082 ¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J%\u0010\u009f\u0001\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J-\u0010¡\u0001\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0010H\u0082 ¢\u0006\u0006\b¡\u0001\u0010¢\u0001J?\u0010¥\u0001\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00102\u0007\u0010£\u0001\u001a\u00020\u00102\u0007\u0010¤\u0001\u001a\u00020\u0010H\u0082 ¢\u0006\u0006\b¥\u0001\u0010¦\u0001J%\u0010§\u0001\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\b§\u0001\u0010 \u0001J\u001b\u0010¨\u0001\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u0004H\u0082 ¢\u0006\u0005\b¨\u0001\u0010_J\u001c\u0010©\u0001\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\b©\u0001\u0010\u0087\u0001J9\u0010\u00ad\u0001\u001a\u00020#2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\b\u0010«\u0001\u001a\u00030ª\u00012\u0006\u0010:\u001a\u00020\u00102\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0004H\u0082 ¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J7\u0010±\u0001\u001a\u00020#2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010¯\u0001\u001a\u00020#2\b\u0010°\u0001\u001a\u00030ª\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0082 ¢\u0006\u0006\b±\u0001\u0010²\u0001J%\u0010³\u0001\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010¯\u0001\u001a\u00020#H\u0082 ¢\u0006\u0006\b³\u0001\u0010´\u0001J7\u0010µ\u0001\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010¯\u0001\u001a\u00020#2\b\u0010°\u0001\u001a\u00030ª\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0082 ¢\u0006\u0006\bµ\u0001\u0010¶\u0001J%\u0010·\u0001\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\b·\u0001\u0010 \u0001J\u0012\u0010¸\u0001\u001a\u00020\u0015H\u0082 ¢\u0006\u0005\b¸\u0001\u0010\u001eJ\u001c\u0010¹\u0001\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\b¹\u0001\u0010\u0087\u0001J\u001c\u0010º\u0001\u001a\u00020\u00042\u0007\u0010\u008e\u0001\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\bº\u0001\u0010»\u0001J\u001c\u0010¼\u0001\u001a\u00020#2\u0007\u0010\u008e\u0001\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\b¼\u0001\u0010½\u0001J\"\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\"2\u0007\u0010\u008e\u0001\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\b¾\u0001\u0010¿\u0001J%\u0010Â\u0001\u001a\u00020\u00102\u0007\u0010À\u0001\u001a\u00020\u001f2\u0007\u0010Á\u0001\u001a\u00020\u0010H\u0082 ¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u0012\u0010Ä\u0001\u001a\u00020\u000bH\u0082 ¢\u0006\u0005\bÄ\u0001\u0010\u001cJ\u0012\u0010Å\u0001\u001a\u00020\u0015H\u0082 ¢\u0006\u0005\bÅ\u0001\u0010\u001eJ\u0012\u0010Æ\u0001\u001a\u00020\u001fH\u0082 ¢\u0006\u0005\bÆ\u0001\u0010LJ\u0012\u0010Ç\u0001\u001a\u00020\u001fH\u0082 ¢\u0006\u0005\bÇ\u0001\u0010LJ\u001c\u0010É\u0001\u001a\u00020\u000b2\u0007\u0010È\u0001\u001a\u00020\u0010H\u0082 ¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u001c\u0010Ì\u0001\u001a\u00020\u000b2\u0007\u0010Ë\u0001\u001a\u00020\u0010H\u0082 ¢\u0006\u0006\bÌ\u0001\u0010Ê\u0001J\u001b\u0010Í\u0001\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u0012\u0010Ï\u0001\u001a\u00020\u0004H\u0082 ¢\u0006\u0005\bÏ\u0001\u0010SJ\u0012\u0010Ð\u0001\u001a\u00020\u001fH\u0082 ¢\u0006\u0005\bÐ\u0001\u0010LJ\u0012\u0010Ñ\u0001\u001a\u00020\u001fH\u0082 ¢\u0006\u0005\bÑ\u0001\u0010LJ%\u0010Ô\u0001\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u00042\b\u0010Ó\u0001\u001a\u00030Ò\u0001H\u0082 ¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J$\u0010Ö\u0001\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u00042\u0007\u0010£\u0001\u001a\u00020\u0010H\u0082 ¢\u0006\u0006\bÖ\u0001\u0010×\u0001J\u0016\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u0001H\u0082 ¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J\u0016\u0010Û\u0001\u001a\u0005\u0018\u00010Ò\u0001H\u0082 ¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J\"\u0010Ý\u0001\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0006\bÝ\u0001\u0010 \u0001J#\u0010Þ\u0001\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u00042\u0007\u0010£\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0006\bÞ\u0001\u0010×\u0001J\u0015\u0010ß\u0001\u001a\u0005\u0018\u00010Ø\u0001H\u0002¢\u0006\u0006\bß\u0001\u0010Ú\u0001J\u0017\u0010à\u0001\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0005\bà\u0001\u0010!J\u001e\u0010á\u0001\u001a\u00020#2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0006\bá\u0001\u0010â\u0001J8\u0010á\u0001\u001a\u00020#2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0018\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010*0\u000e¢\u0006\u0006\bá\u0001\u0010ã\u0001J%\u0010ä\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010*2\u0006\u0010-\u001a\u00020\u001f¢\u0006\u0005\bä\u0001\u0010NJ\u000f\u0010å\u0001\u001a\u00020\u001f¢\u0006\u0005\bå\u0001\u0010LJ \u0010æ\u0001\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0004¢\u0006\u0006\bæ\u0001\u0010 \u0001J\u0011\u0010ç\u0001\u001a\u0004\u0018\u00010\u0004¢\u0006\u0005\bç\u0001\u0010SJ\u001f\u0010è\u0001\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0004¢\u0006\u0005\bè\u0001\u0010QJ,\u0010à\u0001\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\u0013\u0010é\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010*¢\u0006\u0005\bà\u0001\u0010,J4\u0010ê\u0001\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\b2\u0013\u0010é\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010*¢\u0006\u0005\bê\u0001\u00108JF\u0010ë\u0001\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0018\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010*0\u000e¢\u0006\u0006\bë\u0001\u0010ì\u0001J.\u0010í\u0001\u001a\b\u0012\u0004\u0012\u00020B0\u000e2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u0015¢\u0006\u0006\bí\u0001\u0010î\u0001J\u0017\u0010ï\u0001\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001f¢\u0006\u0005\bï\u0001\u0010/J\u001e\u0010ð\u0001\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e¢\u0006\u0006\bð\u0001\u0010ñ\u0001J\u001f\u0010ê\u0001\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\b¢\u0006\u0005\bê\u0001\u00105J,\u0010ë\u0001\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0006\bë\u0001\u0010ò\u0001J(\u0010í\u0001\u001a\b\u0012\u0004\u0012\u00020;0\u000e2\u0006\u00109\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\u0010¢\u0006\u0006\bí\u0001\u0010ó\u0001J:\u0010í\u0001\u001a\b\u0012\u0004\u0012\u00020;0\u000e2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010?\u001a\u00020\u0010¢\u0006\u0006\bí\u0001\u0010ô\u0001JQ\u0010ö\u0001\u001a\b\u0012\u0004\u0012\u00020B0\u000e2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00102\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010?\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020\u00152\t\b\u0002\u0010D\u001a\u00030õ\u0001¢\u0006\u0006\bö\u0001\u0010÷\u0001J5\u0010ù\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u000e0\u000e2\r\u0010ø\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\b\b\u0002\u0010:\u001a\u00020\u0010¢\u0006\u0006\bù\u0001\u0010ú\u0001J^\u0010û\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\u000e0\u000e2\r\u0010ø\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010:\u001a\u00020\u00102\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010?\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020\u00152\t\b\u0002\u0010D\u001a\u00030õ\u0001¢\u0006\u0006\bû\u0001\u0010ü\u0001J\u000f\u0010ý\u0001\u001a\u00020\u0010¢\u0006\u0005\bý\u0001\u0010UJ\u0019\u0010þ\u0001\u001a\u0004\u0018\u00010\b2\u0006\u0010-\u001a\u00020\u001f¢\u0006\u0005\bþ\u0001\u0010WJ%\u0010ÿ\u0001\u001a\u00020\u00152\b\b\u0002\u0010Y\u001a\u00020X2\b\b\u0002\u0010Z\u001a\u00020\u0015H\u0007¢\u0006\u0005\bÿ\u0001\u0010\\J\u0017\u0010\u0080\u0002\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u0004¢\u0006\u0005\b\u0080\u0002\u0010_J\u000f\u0010\u0081\u0002\u001a\u00020\u000b¢\u0006\u0005\b\u0081\u0002\u0010\u001cJ\u0017\u0010\u0082\u0002\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u0004¢\u0006\u0005\b\u0082\u0002\u0010_J\u0017\u0010\u0083\u0002\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u0004¢\u0006\u0005\b\u0083\u0002\u0010_J\u0010\u0010\u0084\u0002\u001a\u00020\u0002¢\u0006\u0006\b\u0084\u0002\u0010\u0085\u0002J\u000f\u0010\u0086\u0002\u001a\u00020\u0015¢\u0006\u0005\b\u0086\u0002\u0010\u001eJ\u001a\u0010\u0088\u0002\u001a\u00020\u000b2\b\u0010Ë\u0001\u001a\u00030\u0087\u0002¢\u0006\u0006\b\u0088\u0002\u0010\u0089\u0002J\u001a\u0010\u008b\u0002\u001a\u00020\u000b2\b\u0010È\u0001\u001a\u00030\u008a\u0002¢\u0006\u0006\b\u008b\u0002\u0010\u008c\u0002J\u000f\u0010\u008d\u0002\u001a\u00020\u000b¢\u0006\u0005\b\u008d\u0002\u0010\u001cJ\u000f\u0010\u008e\u0002\u001a\u00020\u0015¢\u0006\u0005\b\u008e\u0002\u0010\u001eJ\u000f\u0010\u008f\u0002\u001a\u00020\u0004¢\u0006\u0005\b\u008f\u0002\u0010SJ\u000f\u0010\u0090\u0002\u001a\u00020\u001f¢\u0006\u0005\b\u0090\u0002\u0010LJ\u000f\u0010\u0091\u0002\u001a\u00020\u001f¢\u0006\u0005\b\u0091\u0002\u0010LJ\"\u0010\u0092\u0002\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u00042\b\u0010Ó\u0001\u001a\u00030Ò\u0001¢\u0006\u0006\b\u0092\u0002\u0010Õ\u0001J\u0013\u0010\u0093\u0002\u001a\u0005\u0018\u00010Ò\u0001¢\u0006\u0006\b\u0093\u0002\u0010Ü\u0001J\u000f\u0010\u0094\u0002\u001a\u00020\u000b¢\u0006\u0005\b\u0094\u0002\u0010\u001cJ\u000f\u0010\u0095\u0002\u001a\u00020\u000b¢\u0006\u0005\b\u0095\u0002\u0010\u001cJz\u0010\u0098\u0002\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u00102\b\b\u0002\u0010e\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\u00102\b\b\u0002\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00042\b\b\u0002\u0010i\u001a\u00020\u00152\f\b\u0002\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0096\u00022\b\b\u0002\u0010j\u001a\u00020\u001f2\b\b\u0002\u0010k\u001a\u00020\u001f2\b\b\u0002\u0010l\u001a\u00020\u001f¢\u0006\u0006\b\u0098\u0002\u0010\u0099\u0002J\u0019\u0010\u009a\u0002\u001a\u00020\u000b2\u0007\u0010\u0003\u001a\u00030\u0096\u0002¢\u0006\u0006\b\u009a\u0002\u0010\u009b\u0002JA\u0010\u009c\u0002\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u00042\b\b\u0002\u0010r\u001a\u00020\u00152\u0006\u0010y\u001a\u00020\u00102\u0006\u0010z\u001a\u00020\u00102\u0006\u0010{\u001a\u00020\u001f2\u0006\u0010|\u001a\u00020\u0010¢\u0006\u0005\b\u009c\u0002\u0010~J\u0017\u0010\u009d\u0002\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u0004¢\u0006\u0005\b\u009d\u0002\u0010_J2\u0010\u009e\u0002\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u00152\u0007\u0010\u0080\u0001\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u001f2\u0007\u0010\u0081\u0001\u001a\u00020\u001f¢\u0006\u0006\b\u009e\u0002\u0010\u0083\u0001J\u0018\u0010\u009f\u0002\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020\u001f¢\u0006\u0006\b\u009f\u0002\u0010\u0085\u0001J\u0018\u0010 \u0002\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u0004¢\u0006\u0006\b \u0002\u0010\u0087\u0001J\u000f\u0010¡\u0002\u001a\u00020\u000b¢\u0006\u0005\b¡\u0002\u0010\u001cJ\u0017\u0010¢\u0002\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u0004¢\u0006\u0005\b¢\u0002\u0010_J\u000f\u0010£\u0002\u001a\u00020\u000b¢\u0006\u0005\b£\u0002\u0010\u001cJ\u0018\u0010¤\u0002\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u0004¢\u0006\u0006\b¤\u0002\u0010\u0087\u0001J\u0016\u0010¥\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0006\b¥\u0002\u0010¦\u0002J.\u0010§\u0002\u001a\u00020\u001f2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\b§\u0002\u0010\u0091\u0001JJ\u0010¨\u0002\u001a\u0004\u0018\u00010#2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0007\u0010\u0092\u0001\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\u00102\u0013\b\u0002\u0010\u0094\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\"¢\u0006\u0006\b¨\u0002\u0010\u0096\u0001J0\u0010ª\u0002\u001a\t\u0012\u0005\u0012\u00030©\u00020\u000e2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u0010¢\u0006\u0006\bª\u0002\u0010«\u0002JF\u0010¬\u0002\u001a\t\u0012\u0005\u0012\u00030©\u00020\u000e2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00102\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010?\u001a\u00020\u0010¢\u0006\u0006\b¬\u0002\u0010\u00ad\u0002JS\u0010®\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030©\u00020\u000e0\u000e2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\r\u0010ø\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010:\u001a\u00020\u00102\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010?\u001a\u00020\u0010¢\u0006\u0006\b®\u0002\u0010¯\u0002J\"\u0010°\u0002\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u0004¢\u0006\u0006\b°\u0002\u0010 \u0001J*\u0010°\u0002\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0010¢\u0006\u0006\b°\u0002\u0010¢\u0001J<\u0010°\u0002\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00102\u0007\u0010£\u0001\u001a\u00020\u00102\u0007\u0010¤\u0001\u001a\u00020\u0010¢\u0006\u0006\b°\u0002\u0010¦\u0001J\"\u0010±\u0002\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u0004¢\u0006\u0006\b±\u0002\u0010 \u0001J\u0018\u0010²\u0002\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u0004¢\u0006\u0005\b²\u0002\u0010_J8\u0010³\u0002\u001a\u00020#2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\b\u0010«\u0001\u001a\u00030ª\u00012\u0006\u0010:\u001a\u00020\u00102\u000b\b\u0002\u0010¬\u0001\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\b³\u0002\u0010®\u0001J4\u0010´\u0002\u001a\u00020#2\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010¯\u0001\u001a\u00020#2\b\u0010°\u0001\u001a\u00030ª\u00012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0006\b´\u0002\u0010²\u0001J\"\u0010µ\u0002\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010¯\u0001\u001a\u00020#¢\u0006\u0006\bµ\u0002\u0010´\u0001J4\u0010¶\u0002\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010¯\u0001\u001a\u00020#2\b\u0010°\u0001\u001a\u00030ª\u00012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0006\b¶\u0002\u0010¶\u0001J\"\u0010·\u0002\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u0004¢\u0006\u0006\b·\u0002\u0010 \u0001J\u0019\u0010¸\u0002\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u0004¢\u0006\u0006\b¸\u0002\u0010\u0087\u0001J\u000f\u0010¹\u0002\u001a\u00020\u0015¢\u0006\u0005\b¹\u0002\u0010\u001eJ\u0019\u0010º\u0002\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u0004¢\u0006\u0006\bº\u0002\u0010\u0087\u0001J\u0019\u0010»\u0002\u001a\u00020#2\u0007\u0010\u008e\u0001\u001a\u00020\u0004¢\u0006\u0006\b»\u0002\u0010½\u0001J\u000f\u0010¼\u0002\u001a\u00020\u001f¢\u0006\u0005\b¼\u0002\u0010LJ\u000f\u0010½\u0002\u001a\u00020\u001f¢\u0006\u0005\b½\u0002\u0010LJ\u0019\u0010¾\u0002\u001a\u00020\u00042\u0007\u0010\u008e\u0001\u001a\u00020\u0004¢\u0006\u0006\b¾\u0002\u0010»\u0001J\u001f\u0010¿\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0007\u0010\u008e\u0001\u001a\u00020\u0004¢\u0006\u0006\b¿\u0002\u0010À\u0002J\"\u0010Á\u0002\u001a\u00020\u00102\u0007\u0010À\u0001\u001a\u00020\u001f2\u0007\u0010Á\u0001\u001a\u00020\u0010¢\u0006\u0006\bÁ\u0002\u0010Ã\u0001R\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010Â\u0002R\u0019\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u000e\n\u0005\b\u0005\u0010Ã\u0002\u001a\u0005\bÄ\u0002\u0010SR\u0019\u0010Å\u0002\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0002\u0010Æ\u0002¨\u0006Ê\u0002"}, d2 = {"Lcom/stepos/ame/AMEngineNative;", "", "LE6/a;", "config", "", "vectorStoragePath", "<init>", "(LE6/a;Ljava/lang/String;)V", "", "vector", "name", "LY8/t;", "requireNonEmptyVector", "([FLjava/lang/String;)V", "", "vectors", "", "requireUniformDimension", "(Ljava/util/List;Ljava/lang/String;)I", "dimension", "maxVectors", "", "enableTurbo", "dspLibraryPath", "storagePath", "nativeInit", "(IIZLjava/lang/String;Ljava/lang/String;)Z", "nativeShutdown", "()V", "nativeIsInitialized", "()Z", "", "nativeInsert", "([F)J", "", "", "nativeInsertBatch", "([[F)[J", "Ljava/util/HashMap;", "metadataMaps", "nativeInsertBatchWithMetadata", "([[F[Ljava/util/HashMap;)[J", "", "metadata", "([FLjava/util/Map;)J", "vectorId", "nativeDelete", "(J)Z", "ids", "nativeDeleteBatch", "([J)I", "newVector", "nativeUpdate", "(J[F)Z", "nativeUpdateBatch", "([J[[F)I", "(J[FLjava/util/Map;)Z", "query", "topK", "Lcom/stepos/ame/SearchResult;", "nativeSearch", "([FI)[Lcom/stepos/ame/SearchResult;", "filterJson", "overfetchRatio", "([FILjava/lang/String;I)[Lcom/stepos/ame/SearchResult;", "withMetadata", "Lcom/stepos/ame/SearchResultWithMetadata;", "([FIZ)[Lcom/stepos/ame/SearchResultWithMetadata;", "filterStrategy", "nativeSearchFull", "([FILjava/lang/String;IZI)[Lcom/stepos/ame/SearchResultWithMetadata;", "flatQueries", "queryCount", "nativeSearchBatchFull", "([FIIILjava/lang/String;IZI)[[Lcom/stepos/ame/SearchResultWithMetadata;", "nativeGetMetadataCount", "()J", "nativeGetMetadata", "(J)Ljava/util/Map;", "type", "nativeRegisterField", "(Ljava/lang/String;Ljava/lang/String;)I", "nativeGetFieldSchemas", "()Ljava/lang/String;", "nativeGetVectorCount", "()I", "nativeGetVectorById", "(J)[F", "", "minFragmentation", "rebuildIndex", "nativeCompact", "(DZ)Z", "path", "nativeSave", "(Ljava/lang/String;)Z", "nativeFlushPersist", "nativeLoad", "nativeView", "id", "rawDim", "storageDim", "metric", "dtype", "embeddingModel", "inputNormalized", "initialBytes", "stepBytes", "maxBytes", "nativeCreateCollection", "(Ljava/lang/String;IIIILjava/lang/String;ZJJJ)Z", "checkpointAfterWrites", "nativeCreateCollectionWithPersist", "(Ljava/lang/String;IIIILjava/lang/String;ZIJJJ)Z", d.EXTRA_ENABLED, "checkpointIdleSeconds", "useWal", "walFsyncEveryN", "asyncCheckpoint", "nativeSetCollectionPersistConfig", "(ZIIZIZ)V", "upgradeThreshold", "downgradeThreshold", "cooldownMs", "checkIntervalWrites", "nativeSetCollectionAutoSwitchConfig", "(Ljava/lang/String;ZIIJI)Z", "nativeDropCollection", "maxCount", "idleMs", "nativeSetCollectionResidencyConfig", "(ZIJJ)V", "nativeSetGlobalCapacityMaxBytes", "(J)V", "nativeGetCollectionResidencyState", "(Ljava/lang/String;)I", "nativeTriggerResidencyScan", "nativeCompactCollection", "nativeTriggerCompactScan", "nativeCollectionDeletedCount", "nativeListCollections", "()[Ljava/lang/String;", "collectionId", "metadataJson", "nativeInsertToCollection", "(Ljava/lang/String;[FLjava/lang/String;)J", "count", "dim", "metadataJsonArray", "nativeInsertBatchToCollection", "(Ljava/lang/String;[FII[Ljava/lang/String;)[J", "nativeSearchInCollection", "(Ljava/lang/String;[FI)[Ljava/lang/Object;", "nativeSearchInCollectionWithFilter", "(Ljava/lang/String;[FILjava/lang/String;I)[Ljava/lang/Object;", "queriesFlat", "nativeSearchBatchInCollection", "(Ljava/lang/String;[FIIILjava/lang/String;I)[Ljava/lang/Object;", "indexId", "nativeAddShadowIndex", "(Ljava/lang/String;Ljava/lang/String;)Z", "nativeAddShadowIndexTyped", "(Ljava/lang/String;Ljava/lang/String;I)Z", "numClusters", "nprobe", "nativeAddShadowIndexWithParams", "(Ljava/lang/String;Ljava/lang/String;III)Z", "nativePromoteIndex", "nativeRollbackIndex", "nativeRemoveRetiredIndexes", "", "queryFp16", "filter", "nativeSearchInCollectionSync", "(Ljava/lang/String;[BILjava/lang/String;)[J", "vectorIds", "vectorsFp16", "nativeInsertToCollectionBatch", "(Ljava/lang/String;[J[BI)[J", "nativeDeleteFromCollection", "(Ljava/lang/String;[J)I", "nativeUpdateInCollection", "(Ljava/lang/String;[J[BI)I", "nativeTriggerIvfTrain", "nativeFlushAllCollections", "nativeCollectionVectorCount", "nativeCollectionPrimaryIndexId", "(Ljava/lang/String;)Ljava/lang/String;", "nativeGetCollectionRuntimeStats", "(Ljava/lang/String;)[J", "nativeCollectionQuarantinedFiles", "(Ljava/lang/String;)[Ljava/lang/String;", "maxAgeMs", "maxFilesPerCollection", "nativePruneQuarantine", "(JI)I", "nativeTrainIVF", "nativeRemoveDbForTest", "nativeTotalIonAllocatedBytes", "nativeGetTotalCapacityBytes", "mode", "nativeSetPowerMode", "(I)V", "status", "nativeUpdateThermal", "nativeSetDspLibraryPath", "(Ljava/lang/String;)V", "nativeRunHmxTest", "nativeGetAllocatedMemory", "nativeGetUsedMemory", "", "clusterAssignments", "nativeSaveSharded", "(Ljava/lang/String;[I)Z", "nativeViewSharded", "(Ljava/lang/String;I)Z", "Lcom/stepos/ame/ShardStats;", "nativeGetShardStats", "()Lcom/stepos/ame/ShardStats;", "nativeGetClusterAssignments", "()[I", "bindNative", "viewSharded", "getShardStats", "insert", "insertBatch", "(Ljava/util/List;)[J", "(Ljava/util/List;Ljava/util/List;)[J", "getMetadata", "getMetadataCount", "registerMetadataField", "getFieldSchemasJson", "registerMetadataFieldReturnCode", "metadataMap", a.BUTTON_UPDATE, "updateBatch", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)I", "search", "([FIZ)Ljava/util/List;", ChatTracker.CLICK_DELETE, "deleteBatch", "(Ljava/util/List;)I", "(Ljava/util/List;Ljava/util/List;)I", "([FI)Ljava/util/List;", "([FILjava/lang/String;I)Ljava/util/List;", "Lcom/stepos/ame/api/FilterStrategy;", "searchFull", "([FILjava/lang/String;IZLcom/stepos/ame/api/FilterStrategy;)Ljava/util/List;", "queries", "searchBatch", "(Ljava/util/List;I)Ljava/util/List;", "searchBatchFull", "(Ljava/util/List;ILjava/lang/String;IZLcom/stepos/ame/api/FilterStrategy;)Ljava/util/List;", "getVectorCount", "getVectorById", "compact", "save", "flushPersist", "load", "view", "getConfig", "()LE6/a;", "isInitialized", "Lcom/stepos/ame/ThermalStatus;", "updateThermalStatus", "(Lcom/stepos/ame/ThermalStatus;)V", "Lcom/stepos/ame/PowerMode;", "setPowerMode", "(Lcom/stepos/ame/PowerMode;)V", "trainIndex", "removeDbForTest", "runHmxTest", "getAllocatedMemory", "getUsedMemory", "saveSharded", "getClusterAssignments", "shutdown", "release", "Lcom/stepos/ame/sdk/CollectionPersistConfig;", "persistOverride", "createCollection", "(Ljava/lang/String;IIIILjava/lang/String;ZLcom/stepos/ame/sdk/CollectionPersistConfig;JJJ)Z", "setCollectionPersistConfig", "(Lcom/stepos/ame/sdk/CollectionPersistConfig;)V", "setCollectionAutoSwitchConfig", "dropCollection", "setCollectionResidencyConfig", "setGlobalCapacityMaxBytes", "getCollectionResidencyState", "triggerResidencyScan", "compactCollection", "triggerCompactScan", "collectionDeletedCount", "listCollections", "()Ljava/util/List;", "insertToCollection", "insertBatchToCollection", "Lcom/stepos/ame/AMEngineNative$a;", "searchInCollection", "(Ljava/lang/String;[FI)Ljava/util/List;", "searchInCollectionWithFilter", "(Ljava/lang/String;[FILjava/lang/String;I)Ljava/util/List;", "searchBatchInCollection", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;I)Ljava/util/List;", "addShadowIndex", "promoteIndex", "rollbackIndex", "searchInCollectionSync", "insertToCollectionBatch", "deleteFromCollection", "updateInCollection", "triggerIvfTrain", "removeRetiredIndexes", "flushAllCollections", "collectionVectorCount", "getCollectionRuntimeStats", "totalIonAllocatedBytes", "getTotalCapacityBytes", "collectionPrimaryIndexId", "collectionQuarantinedFiles", "(Ljava/lang/String;)Ljava/util/List;", "pruneQuarantine", "LE6/a;", "Ljava/lang/String;", "getVectorStoragePath", "initialized", "Z", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AMEngineNative {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEFAULT_DSP_LIBRARY_PATH = "/data/local/tmp";
    public static final String DEFAULT_SHARED_DATA_ROOT = "/data/user/0/com.zyql.dbbenchmark";
    public static final String DEFAULT_SHARED_SHARDED_STORAGE_BASE = "/data/user/0/com.zyql.dbbenchmark/files/ame/db/vectors";
    public static final String DEFAULT_SHARED_VECTOR_STORAGE_PATH = "/data/user/0/com.zyql.dbbenchmark/files/ame/db/vectors.ame";
    private static final int DEFAULT_TOP_K = 10;
    private static final String TAG = "AMEngineNative";
    private static volatile AMEngineNative instance;
    private final AMEConfig config;
    private boolean initialized;
    private final String vectorStoragePath;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ame/AMEngineNative$a;", "", "", "vectorId", "", "distance", "<init>", "(JF)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "()J", "F", "()F", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.ame.AMEngineNative$a, reason: from toString */
    public static final /* data */ class CollectionHit {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final long vectorId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final float distance;

        public CollectionHit(long j10, float f10) {
            this.vectorId = j10;
            this.distance = f10;
        }

        /* renamed from: a, reason: from getter */
        public final float getDistance() {
            return this.distance;
        }

        /* renamed from: b, reason: from getter */
        public final long getVectorId() {
            return this.vectorId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CollectionHit)) {
                return false;
            }
            CollectionHit collectionHit = (CollectionHit) other;
            return this.vectorId == collectionHit.vectorId && Float.compare(this.distance, collectionHit.distance) == 0;
        }

        public int hashCode() {
            return (Long.hashCode(this.vectorId) * 31) + Float.hashCode(this.distance);
        }

        public String toString() {
            return "CollectionHit(vectorId=" + this.vectorId + ", distance=" + this.distance + ")";
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0010H\u0083 ¢\u0006\u0004\b\u0016\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\u0017H\u0083 ¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ame/AMEngineNative$b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)Ljava/lang/String;", "LE6/a;", "config", "Lcom/stepos/ame/AMEngineNative;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;LE6/a;)Lcom/stepos/ame/AMEngineNative;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "", Const.INTENT_KEY_UMID, "()Z", "LE6/b;", Const.INTENT_KEY_APIKEY, "()LE6/b;", "f", "", "e", "()[I", "TAG", "Ljava/lang/String;", "", "DEFAULT_TOP_K", "I", "DEFAULT_DSP_LIBRARY_PATH", "instance", "Lcom/stepos/ame/AMEngineNative;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.ame.AMEngineNative$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ AMEngineNative c(Companion companion, Context context, AMEConfig aMEConfig, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                aMEConfig = new AMEConfig(0, 0, 0, null, false, 31, null);
            }
            return companion.b(context, aMEConfig);
        }

        public final DeviceAvailability a() {
            int[] iArrE = e();
            return new DeviceAvailability(iArrE[0] != 0, iArrE[1] != 0, iArrE[2] != 0);
        }

        public final AMEngineNative b(Context context, AMEConfig config) {
            p.i(context, "context");
            p.i(config, "config");
            synchronized (this) {
                AMEngineNative aMEngineNative = AMEngineNative.instance;
                if (aMEngineNative != null && aMEngineNative.initialized) {
                    return aMEngineNative;
                }
                if (aMEngineNative != null) {
                    aMEngineNative.shutdown();
                }
                Context applicationContext = context.getApplicationContext();
                Companion companion = AMEngineNative.INSTANCE;
                p.f(applicationContext);
                String strH = companion.h(applicationContext);
                File parentFile = new File(strH).getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                AMEngineNative aMEngineNative2 = new AMEngineNative(config, strH, null);
                AMEngineNative.instance = aMEngineNative2;
                aMEngineNative2.bindNative(AMEngineNative.DEFAULT_DSP_LIBRARY_PATH, strH);
                return aMEngineNative2;
            }
        }

        public final boolean d() {
            return f();
        }

        public final int[] e() {
            return AMEngineNative.nativeGetDeviceAvailability();
        }

        public final boolean f() {
            return AMEngineNative.nativeIsAutoIndexSwitchEnabled();
        }

        public final void g() {
            synchronized (this) {
                try {
                    AMEngineNative aMEngineNative = AMEngineNative.instance;
                    if (aMEngineNative != null) {
                        aMEngineNative.shutdown();
                    }
                    AMEngineNative.instance = null;
                    t tVar = t.f7040a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final String h(Context context) {
            p.i(context, "context");
            String absolutePath = new File(context.getApplicationContext().getFilesDir(), "ame/db/vectors.ame").getAbsolutePath();
            p.h(absolutePath, "getAbsolutePath(...)");
            return absolutePath;
        }

        public Companion() {
        }
    }

    static {
        System.loadLibrary("ame");
    }

    public /* synthetic */ AMEngineNative(AMEConfig aMEConfig, String str, i iVar) {
        this(aMEConfig, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean bindNative(String dspLibraryPath, String storagePath) {
        if (this.initialized) {
            return true;
        }
        boolean zNativeInit = nativeInit(this.config.getDimension(), this.config.getMaxVectors(), this.config.getEnableTurboMode(), dspLibraryPath, storagePath);
        this.initialized = zNativeInit;
        if (zNativeInit) {
            Log.i(TAG, "AMEngineNative initialized: dim=" + this.config.getDimension() + ", max=" + this.config.getMaxVectors() + ", turbo=" + this.config.getEnableTurboMode() + ", storagePath=" + storagePath);
        } else {
            Log.e(TAG, "AMEngineNative initialization failed");
        }
        return this.initialized;
    }

    public static /* synthetic */ boolean compact$default(AMEngineNative aMEngineNative, double d10, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = 0.1d;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return aMEngineNative.compact(d10, z10);
    }

    public static /* synthetic */ boolean createCollection$default(AMEngineNative aMEngineNative, String str, int i10, int i11, int i12, int i13, String str2, boolean z10, CollectionPersistConfig collectionPersistConfig, long j10, long j11, long j12, int i14, Object obj) {
        long j13;
        AMEngineNative aMEngineNative2;
        String str3;
        int i15;
        int i16;
        String str4;
        int i17 = (i14 & 4) != 0 ? i10 : i11;
        int i18 = (i14 & 16) != 0 ? 0 : i13;
        boolean z11 = (i14 & 64) != 0 ? false : z10;
        CollectionPersistConfig collectionPersistConfig2 = (i14 & 128) != 0 ? null : collectionPersistConfig;
        long j14 = (i14 & 256) != 0 ? -1L : j10;
        long j15 = (i14 & 512) != 0 ? -1L : j11;
        if ((i14 & 1024) != 0) {
            j13 = -1;
            i15 = i10;
            i16 = i12;
            str4 = str2;
            aMEngineNative2 = aMEngineNative;
            str3 = str;
        } else {
            j13 = j12;
            aMEngineNative2 = aMEngineNative;
            str3 = str;
            i15 = i10;
            i16 = i12;
            str4 = str2;
        }
        return aMEngineNative2.createCollection(str3, i15, i17, i16, i18, str4, z11, collectionPersistConfig2, j14, j15, j13);
    }

    private final ShardStats getShardStats() {
        if (this.initialized) {
            return nativeGetShardStats();
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public static /* synthetic */ long[] insertBatchToCollection$default(AMEngineNative aMEngineNative, String str, float[] fArr, int i10, int i11, String[] strArr, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            strArr = null;
        }
        return aMEngineNative.insertBatchToCollection(str, fArr, i10, i11, strArr);
    }

    public static /* synthetic */ long insertToCollection$default(AMEngineNative aMEngineNative, String str, float[] fArr, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        return aMEngineNative.insertToCollection(str, fArr, str2);
    }

    public static final boolean isAutoIndexSwitchEnabled() {
        return INSTANCE.d();
    }

    private final native boolean nativeAddShadowIndex(String collectionId, String indexId);

    private final native boolean nativeAddShadowIndexTyped(String collectionId, String indexId, int type);

    private final native boolean nativeAddShadowIndexWithParams(String collectionId, String indexId, int type, int numClusters, int nprobe);

    private final native int nativeCollectionDeletedCount(String id);

    private final native String nativeCollectionPrimaryIndexId(String collectionId);

    private final native String[] nativeCollectionQuarantinedFiles(String collectionId);

    private final native int nativeCollectionVectorCount(String collectionId);

    private final native boolean nativeCompact(double minFragmentation, boolean rebuildIndex);

    private final native boolean nativeCompactCollection(String id);

    private final native boolean nativeCreateCollection(String id, int rawDim, int storageDim, int metric, int dtype, String embeddingModel, boolean inputNormalized, long initialBytes, long stepBytes, long maxBytes);

    private final native boolean nativeCreateCollectionWithPersist(String id, int rawDim, int storageDim, int metric, int dtype, String embeddingModel, boolean inputNormalized, int checkpointAfterWrites, long initialBytes, long stepBytes, long maxBytes);

    private final native boolean nativeDelete(long vectorId);

    private final native int nativeDeleteBatch(long[] ids);

    private final native int nativeDeleteFromCollection(String collectionId, long[] vectorIds);

    private final native boolean nativeDropCollection(String id);

    private final native boolean nativeFlushAllCollections();

    private final native void nativeFlushPersist();

    private final native long nativeGetAllocatedMemory();

    private final native int[] nativeGetClusterAssignments();

    private final native int nativeGetCollectionResidencyState(String id);

    private final native long[] nativeGetCollectionRuntimeStats(String collectionId);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native int[] nativeGetDeviceAvailability();

    private final native String nativeGetFieldSchemas();

    private final native Map<String, Object> nativeGetMetadata(long vectorId);

    private final native long nativeGetMetadataCount();

    private final native ShardStats nativeGetShardStats();

    private final native long nativeGetTotalCapacityBytes();

    private final native long nativeGetUsedMemory();

    private final native float[] nativeGetVectorById(long vectorId);

    private final native int nativeGetVectorCount();

    private final native boolean nativeInit(int dimension, int maxVectors, boolean enableTurbo, String dspLibraryPath, String storagePath);

    private final native long nativeInsert(float[] vector);

    private final native long nativeInsert(float[] vector, Map<String, ? extends Object> metadata);

    private final native long[] nativeInsertBatch(float[][] vectors);

    private final native long[] nativeInsertBatchToCollection(String collectionId, float[] vectors, int count, int dim, String[] metadataJsonArray);

    private final native long[] nativeInsertBatchWithMetadata(float[][] vectors, HashMap<String, Object>[] metadataMaps);

    private final native long nativeInsertToCollection(String collectionId, float[] vector, String metadataJson);

    private final native long[] nativeInsertToCollectionBatch(String collectionId, long[] vectorIds, byte[] vectorsFp16, int dimension);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native boolean nativeIsAutoIndexSwitchEnabled();

    private final native boolean nativeIsInitialized();

    private final native String[] nativeListCollections();

    private final native boolean nativeLoad(String path);

    private final native boolean nativePromoteIndex(String collectionId, String indexId);

    private final native int nativePruneQuarantine(long maxAgeMs, int maxFilesPerCollection);

    private final native int nativeRegisterField(String name, String type);

    private final native boolean nativeRemoveDbForTest();

    private final native int nativeRemoveRetiredIndexes(String collectionId);

    private final native boolean nativeRollbackIndex(String collectionId);

    private final native String nativeRunHmxTest();

    private final native boolean nativeSave(String path);

    private final native boolean nativeSaveSharded(String path, int[] clusterAssignments);

    private final native SearchResult[] nativeSearch(float[] query, int topK);

    private final native SearchResult[] nativeSearch(float[] query, int topK, String filterJson, int overfetchRatio);

    private final native SearchResultWithMetadata[] nativeSearch(float[] query, int topK, boolean withMetadata);

    private final native SearchResultWithMetadata[][] nativeSearchBatchFull(float[] flatQueries, int queryCount, int dimension, int topK, String filterJson, int overfetchRatio, boolean withMetadata, int filterStrategy);

    private final native Object[] nativeSearchBatchInCollection(String collectionId, float[] queriesFlat, int queryCount, int dim, int topK, String filterJson, int overfetchRatio);

    private final native SearchResultWithMetadata[] nativeSearchFull(float[] query, int topK, String filterJson, int overfetchRatio, boolean withMetadata, int filterStrategy);

    private final native Object[] nativeSearchInCollection(String collectionId, float[] query, int topK);

    private final native long[] nativeSearchInCollectionSync(String collectionId, byte[] queryFp16, int topK, String filter);

    private final native Object[] nativeSearchInCollectionWithFilter(String collectionId, float[] query, int topK, String filterJson, int overfetchRatio);

    private final native boolean nativeSetCollectionAutoSwitchConfig(String id, boolean enabled, int upgradeThreshold, int downgradeThreshold, long cooldownMs, int checkIntervalWrites);

    private final native void nativeSetCollectionPersistConfig(boolean enabled, int checkpointAfterWrites, int checkpointIdleSeconds, boolean useWal, int walFsyncEveryN, boolean asyncCheckpoint);

    private final native void nativeSetCollectionResidencyConfig(boolean enabled, int maxCount, long maxBytes, long idleMs);

    private final native void nativeSetDspLibraryPath(String path);

    private final native void nativeSetGlobalCapacityMaxBytes(long maxBytes);

    private final native void nativeSetPowerMode(int mode);

    private final native void nativeShutdown();

    private final native long nativeTotalIonAllocatedBytes();

    private final native void nativeTrainIVF();

    private final native void nativeTriggerCompactScan();

    private final native boolean nativeTriggerIvfTrain(String collectionId, String indexId);

    private final native void nativeTriggerResidencyScan();

    private final native boolean nativeUpdate(long vectorId, float[] newVector);

    private final native boolean nativeUpdate(long vectorId, float[] newVector, Map<String, ? extends Object> metadata);

    private final native int nativeUpdateBatch(long[] ids, float[][] vectors);

    private final native int nativeUpdateInCollection(String collectionId, long[] vectorIds, byte[] vectorsFp16, int dimension);

    private final native void nativeUpdateThermal(int status);

    private final native boolean nativeView(String path);

    private final native boolean nativeViewSharded(String path, int numClusters);

    private final void requireNonEmptyVector(float[] vector, String name) {
        if (vector.length == 0) {
            throw new IllegalArgumentException((name + " must be non-empty").toString());
        }
    }

    public static /* synthetic */ void requireNonEmptyVector$default(AMEngineNative aMEngineNative, float[] fArr, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "vector";
        }
        aMEngineNative.requireNonEmptyVector(fArr, str);
    }

    private final int requireUniformDimension(List<float[]> vectors, String name) {
        if (vectors.isEmpty()) {
            throw new IllegalArgumentException((name + " must be non-empty").toString());
        }
        int length = vectors.get(0).length;
        if (length <= 0) {
            throw new IllegalArgumentException((name + "[0] must have positive length").toString());
        }
        int size = vectors.size();
        for (int i10 = 1; i10 < size; i10++) {
            if (vectors.get(i10).length != length) {
                throw new IllegalArgumentException((name + "[" + i10 + "] dimension " + vectors.get(i10).length + " != " + length).toString());
            }
        }
        return length;
    }

    public static /* synthetic */ int requireUniformDimension$default(AMEngineNative aMEngineNative, List list, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "vectors";
        }
        return aMEngineNative.requireUniformDimension(list, str);
    }

    public static /* synthetic */ List search$default(AMEngineNative aMEngineNative, float[] fArr, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 10;
        }
        return aMEngineNative.search(fArr, i10);
    }

    public static /* synthetic */ List searchBatch$default(AMEngineNative aMEngineNative, List list, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 10;
        }
        return aMEngineNative.searchBatch(list, i10);
    }

    public static /* synthetic */ List searchBatchFull$default(AMEngineNative aMEngineNative, List list, int i10, String str, int i11, boolean z10, FilterStrategy filterStrategy, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i12 & 8) != 0) {
            i11 = 2;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i12 & 32) != 0) {
            filterStrategy = FilterStrategy.POST_FILTER;
        }
        return aMEngineNative.searchBatchFull(list, i10, str2, i13, z11, filterStrategy);
    }

    public static /* synthetic */ List searchBatchInCollection$default(AMEngineNative aMEngineNative, String str, List list, int i10, String str2, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i12 & 16) != 0) {
            i11 = 2;
        }
        return aMEngineNative.searchBatchInCollection(str, list, i10, str3, i11);
    }

    public static /* synthetic */ List searchFull$default(AMEngineNative aMEngineNative, float[] fArr, int i10, String str, int i11, boolean z10, FilterStrategy filterStrategy, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i12 & 8) != 0) {
            i11 = 2;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i12 & 32) != 0) {
            filterStrategy = FilterStrategy.POST_FILTER;
        }
        return aMEngineNative.searchFull(fArr, i10, str2, i13, z11, filterStrategy);
    }

    public static /* synthetic */ long[] searchInCollectionSync$default(AMEngineNative aMEngineNative, String str, byte[] bArr, int i10, String str2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        return aMEngineNative.searchInCollectionSync(str, bArr, i10, str2);
    }

    public static /* synthetic */ List searchInCollectionWithFilter$default(AMEngineNative aMEngineNative, String str, float[] fArr, int i10, String str2, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i12 & 16) != 0) {
            i11 = 2;
        }
        return aMEngineNative.searchInCollectionWithFilter(str, fArr, i10, str3, i11);
    }

    public static /* synthetic */ boolean setCollectionAutoSwitchConfig$default(AMEngineNative aMEngineNative, String str, boolean z10, int i10, int i11, long j10, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            z10 = true;
        }
        return aMEngineNative.setCollectionAutoSwitchConfig(str, z10, i10, i11, j10, i12);
    }

    private final boolean viewSharded(String path, int numClusters) {
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (numClusters <= 0) {
            throw new IllegalArgumentException("Number of clusters must be positive");
        }
        Log.i(TAG, "Loading sharded database from: " + path);
        Log.i(TAG, "  Clusters: " + numClusters + " | Expected memory: ~768MB (vs full dataset)");
        boolean zNativeViewSharded = nativeViewSharded(path, numClusters);
        if (!zNativeViewSharded) {
            Log.e(TAG, "✗ Failed to load sharded database");
            return zNativeViewSharded;
        }
        Log.i(TAG, "✓ Sharded database loaded: " + getVectorCount() + " vectors");
        Log.i(TAG, "  Memory footprint: ~768MB (3 shards cached)");
        Log.i(TAG, "  Note: Shards will be loaded on-demand during search");
        return zNativeViewSharded;
    }

    public final boolean addShadowIndex(String collectionId, String indexId) {
        p.i(collectionId, "collectionId");
        p.i(indexId, "indexId");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        if (H.x0(indexId)) {
            throw new IllegalArgumentException("index id must not be blank");
        }
        return nativeAddShadowIndex(collectionId, indexId);
    }

    public final int collectionDeletedCount(String id) {
        p.i(id, "id");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(id)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        return nativeCollectionDeletedCount(id);
    }

    public final String collectionPrimaryIndexId(String collectionId) {
        p.i(collectionId, "collectionId");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        return nativeCollectionPrimaryIndexId(collectionId);
    }

    public final List<String> collectionQuarantinedFiles(String collectionId) {
        p.i(collectionId, "collectionId");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        return r.T0(nativeCollectionQuarantinedFiles(collectionId));
    }

    public final int collectionVectorCount(String collectionId) {
        p.i(collectionId, "collectionId");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        return nativeCollectionVectorCount(collectionId);
    }

    public final boolean compact(double minFragmentation, boolean rebuildIndex) {
        if (this.initialized) {
            return nativeCompact(minFragmentation, rebuildIndex);
        }
        Log.w(TAG, "Cannot compact: engine not initialized");
        return false;
    }

    public final boolean compactCollection(String id) {
        p.i(id, "id");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(id)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        return nativeCompactCollection(id);
    }

    public final boolean createCollection(String id, int rawDim, int storageDim, int metric, int dtype, String embeddingModel, boolean inputNormalized, CollectionPersistConfig persistOverride, long initialBytes, long stepBytes, long maxBytes) {
        p.i(id, "id");
        p.i(embeddingModel, "embeddingModel");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(id)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        if (rawDim <= 0) {
            throw new IllegalArgumentException("rawDim must be > 0");
        }
        if (H.x0(embeddingModel)) {
            throw new IllegalArgumentException("embeddingModel must not be blank");
        }
        if (persistOverride == null) {
            return nativeCreateCollection(id, rawDim, storageDim, metric, dtype, embeddingModel, inputNormalized, initialBytes, stepBytes, maxBytes);
        }
        Integer checkpointAfterWrites = persistOverride.getCheckpointAfterWrites();
        return nativeCreateCollectionWithPersist(id, rawDim, storageDim, metric, dtype, embeddingModel, inputNormalized, checkpointAfterWrites != null ? checkpointAfterWrites.intValue() : -1, initialBytes, stepBytes, maxBytes);
    }

    public final boolean delete(long vectorId) {
        if (this.initialized) {
            return nativeDelete(vectorId);
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final int deleteBatch(List<Long> ids) {
        p.i(ids, "ids");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        List<Long> list = ids;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("IDs list cannot be empty");
        }
        return nativeDeleteBatch(F.n1(list));
    }

    public final int deleteFromCollection(String collectionId, long[] vectorIds) {
        p.i(collectionId, "collectionId");
        p.i(vectorIds, "vectorIds");
        if (this.initialized) {
            return nativeDeleteFromCollection(collectionId, vectorIds);
        }
        return 0;
    }

    public final boolean dropCollection(String id) {
        p.i(id, "id");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(id)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        return nativeDropCollection(id);
    }

    public final boolean flushAllCollections() {
        if (this.initialized) {
            return nativeFlushAllCollections();
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final void flushPersist() {
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        nativeFlushPersist();
    }

    public final long getAllocatedMemory() {
        if (this.initialized) {
            return nativeGetAllocatedMemory();
        }
        return 0L;
    }

    public final int[] getClusterAssignments() {
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        Log.i(TAG, "Getting cluster assignments...");
        int[] iArrNativeGetClusterAssignments = nativeGetClusterAssignments();
        if (iArrNativeGetClusterAssignments == null) {
            Log.e(TAG, "✗ Failed to get cluster assignments (IVF not trained?)");
            return iArrNativeGetClusterAssignments;
        }
        Log.i(TAG, "✓ Got " + iArrNativeGetClusterAssignments.length + " cluster assignments");
        return iArrNativeGetClusterAssignments;
    }

    public final int getCollectionResidencyState(String id) {
        p.i(id, "id");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(id)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        return nativeGetCollectionResidencyState(id);
    }

    public final long[] getCollectionRuntimeStats(String collectionId) {
        p.i(collectionId, "collectionId");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        return nativeGetCollectionRuntimeStats(collectionId);
    }

    public final AMEConfig getConfig() {
        return this.config;
    }

    public final String getFieldSchemasJson() {
        if (this.initialized) {
            return nativeGetFieldSchemas();
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final Map<String, Object> getMetadata(long vectorId) {
        if (this.initialized) {
            return nativeGetMetadata(vectorId);
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final long getMetadataCount() {
        if (this.initialized) {
            return nativeGetMetadataCount();
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final long getTotalCapacityBytes() {
        if (this.initialized) {
            return nativeGetTotalCapacityBytes();
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final long getUsedMemory() {
        if (this.initialized) {
            return nativeGetUsedMemory();
        }
        return 0L;
    }

    public final float[] getVectorById(long vectorId) {
        if (this.initialized) {
            return nativeGetVectorById(vectorId);
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final int getVectorCount() {
        if (this.initialized) {
            return nativeGetVectorCount();
        }
        return 0;
    }

    public final String getVectorStoragePath() {
        return this.vectorStoragePath;
    }

    public final long insert(float[] vector) {
        p.i(vector, "vector");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        requireNonEmptyVector$default(this, vector, null, 2, null);
        return nativeInsert(vector);
    }

    public final long[] insertBatch(List<float[]> vectors) {
        p.i(vectors, "vectors");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (vectors.isEmpty()) {
            return new long[0];
        }
        requireUniformDimension$default(this, vectors, null, 2, null);
        return nativeInsertBatch((float[][]) vectors.toArray(new float[0][]));
    }

    public final long[] insertBatchToCollection(String collectionId, float[] vectors, int count, int dim, String[] metadataJsonArray) {
        p.i(collectionId, "collectionId");
        p.i(vectors, "vectors");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        if (count <= 0) {
            throw new IllegalArgumentException(("count must be > 0, got " + count).toString());
        }
        if (dim <= 0) {
            throw new IllegalArgumentException(("dim must be > 0, got " + dim).toString());
        }
        int i10 = count * dim;
        if (vectors.length != i10) {
            throw new IllegalArgumentException(("vectors.size=" + vectors.length + " mismatch count*dim=" + i10).toString());
        }
        if (metadataJsonArray == null || metadataJsonArray.length == count) {
            return nativeInsertBatchToCollection(collectionId, vectors, count, dim, metadataJsonArray);
        }
        throw new IllegalArgumentException(("metadataJsonArray.size=" + metadataJsonArray.length + " mismatch count=" + count).toString());
    }

    public final long insertToCollection(String collectionId, float[] vector, String metadataJson) {
        p.i(collectionId, "collectionId");
        p.i(vector, "vector");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        requireNonEmptyVector(vector, "vector");
        return nativeInsertToCollection(collectionId, vector, metadataJson);
    }

    public final long[] insertToCollectionBatch(String collectionId, long[] vectorIds, byte[] vectorsFp16, int dimension) {
        p.i(collectionId, "collectionId");
        p.i(vectorIds, "vectorIds");
        p.i(vectorsFp16, "vectorsFp16");
        return !this.initialized ? new long[0] : nativeInsertToCollectionBatch(collectionId, vectorIds, vectorsFp16, dimension);
    }

    /* renamed from: isInitialized, reason: from getter */
    public final boolean getInitialized() {
        return this.initialized;
    }

    public final List<String> listCollections() {
        if (this.initialized) {
            return r.T0(nativeListCollections());
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final boolean load(String path) {
        p.i(path, "path");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        Log.i(TAG, "Loading database from: " + path);
        boolean zNativeLoad = nativeLoad(path);
        if (!zNativeLoad) {
            Log.e(TAG, "✗ Failed to load database");
            return zNativeLoad;
        }
        Log.i(TAG, "✓ Database loaded: " + getVectorCount() + " vectors");
        return zNativeLoad;
    }

    public final boolean promoteIndex(String collectionId, String indexId) {
        p.i(collectionId, "collectionId");
        p.i(indexId, "indexId");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        if (H.x0(indexId)) {
            throw new IllegalArgumentException("index id must not be blank");
        }
        return nativePromoteIndex(collectionId, indexId);
    }

    public final int pruneQuarantine(long maxAgeMs, int maxFilesPerCollection) {
        if (this.initialized) {
            return nativePruneQuarantine(maxAgeMs, maxFilesPerCollection);
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final boolean registerMetadataField(String name, String type) {
        p.i(name, "name");
        p.i(type, "type");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        int iNativeRegisterField = nativeRegisterField(name, type);
        return iNativeRegisterField == 0 || iNativeRegisterField == -4;
    }

    public final int registerMetadataFieldReturnCode(String name, String type) {
        p.i(name, "name");
        p.i(type, "type");
        if (this.initialized) {
            return nativeRegisterField(name, type);
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final void release() {
        shutdown();
    }

    public final boolean removeDbForTest() {
        if (!this.initialized) {
            Log.w(TAG, "Cannot removeDbForTest: engine not initialized");
            return false;
        }
        Log.w(TAG, "=========================================");
        Log.w(TAG, "removeDbForTest: 开始清空数据库（测试专用）");
        Log.w(TAG, "=========================================");
        boolean zNativeRemoveDbForTest = nativeRemoveDbForTest();
        if (zNativeRemoveDbForTest) {
            Log.w(TAG, "✓ 数据库已清空（测试专用）");
            return zNativeRemoveDbForTest;
        }
        Log.e(TAG, "✗ 清空数据库失败");
        return zNativeRemoveDbForTest;
    }

    public final int removeRetiredIndexes(String collectionId) {
        p.i(collectionId, "collectionId");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        return nativeRemoveRetiredIndexes(collectionId);
    }

    public final boolean rollbackIndex(String collectionId) {
        p.i(collectionId, "collectionId");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        return nativeRollbackIndex(collectionId);
    }

    public final String runHmxTest() {
        return nativeRunHmxTest();
    }

    public final boolean save(String path) {
        p.i(path, "path");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        Log.i(TAG, "Saving database to: " + path);
        boolean zNativeSave = nativeSave(path);
        if (zNativeSave) {
            Log.i(TAG, "✓ Database saved successfully");
            return zNativeSave;
        }
        Log.e(TAG, "✗ Failed to save database");
        return zNativeSave;
    }

    public final boolean saveSharded(String path, int[] clusterAssignments) {
        p.i(path, "path");
        p.i(clusterAssignments, "clusterAssignments");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (clusterAssignments.length != getVectorCount()) {
            throw new IllegalArgumentException(("Cluster assignments size mismatch: expected " + getVectorCount() + ", got " + clusterAssignments.length).toString());
        }
        Log.i(TAG, "Saving database in sharded format to: " + path);
        boolean zNativeSaveSharded = nativeSaveSharded(path, clusterAssignments);
        if (!zNativeSaveSharded) {
            Log.e(TAG, "✗ Failed to save sharded database");
            return zNativeSaveSharded;
        }
        Log.i(TAG, "✓ Sharded database saved successfully");
        Log.i(TAG, "  Files: " + path + ".shard0, " + path + ".shard1, ..., " + path + ".meta");
        return zNativeSaveSharded;
    }

    public final List<SearchResultWithMetadata> search(float[] query, int topK, boolean withMetadata) {
        List<SearchResultWithMetadata> listT0;
        p.i(query, "query");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        requireNonEmptyVector(query, "query");
        SearchResultWithMetadata[] searchResultWithMetadataArrNativeSearch = nativeSearch(query, topK, withMetadata);
        return (searchResultWithMetadataArrNativeSearch == null || (listT0 = r.T0(searchResultWithMetadataArrNativeSearch)) == null) ? C1173v.m() : listT0;
    }

    public final List<List<SearchResult>> searchBatch(List<float[]> queries, int topK) {
        p.i(queries, "queries");
        List<List<SearchResultWithMetadata>> listSearchBatchFull = searchBatchFull(queries, topK, null, 2, false, FilterStrategy.POST_FILTER);
        ArrayList arrayList = new ArrayList(C1174w.x(listSearchBatchFull, 10));
        Iterator<T> it = listSearchBatchFull.iterator();
        while (it.hasNext()) {
            List<SearchResultWithMetadata> list = (List) it.next();
            ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
            for (SearchResultWithMetadata searchResultWithMetadata : list) {
                arrayList2.add(new SearchResult(searchResultWithMetadata.getId(), searchResultWithMetadata.getScore()));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public final List<List<SearchResultWithMetadata>> searchBatchFull(List<float[]> queries, int topK, String filterJson, int overfetchRatio, boolean withMetadata, FilterStrategy filterStrategy) {
        p.i(queries, "queries");
        p.i(filterStrategy, "filterStrategy");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (queries.isEmpty()) {
            return C1173v.m();
        }
        int iRequireUniformDimension = requireUniformDimension(queries, "queries");
        String str = (filterJson == null || H.x0(filterJson)) ? null : filterJson;
        if (overfetchRatio <= 0) {
            overfetchRatio = 2;
        }
        int i10 = overfetchRatio;
        float[] fArr = new float[queries.size() * iRequireUniformDimension];
        int i11 = 0;
        for (Object obj : queries) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            System.arraycopy((float[]) obj, 0, fArr, i11 * iRequireUniformDimension, iRequireUniformDimension);
            i11 = i12;
        }
        SearchResultWithMetadata[][] searchResultWithMetadataArrNativeSearchBatchFull = nativeSearchBatchFull(fArr, queries.size(), iRequireUniformDimension, topK, str, i10, withMetadata, filterStrategy.getValue());
        if (searchResultWithMetadataArrNativeSearchBatchFull == null) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList(searchResultWithMetadataArrNativeSearchBatchFull.length);
        for (SearchResultWithMetadata[] searchResultWithMetadataArr : searchResultWithMetadataArrNativeSearchBatchFull) {
            arrayList.add(r.T0(searchResultWithMetadataArr));
        }
        return arrayList;
    }

    public final List<List<CollectionHit>> searchBatchInCollection(String collectionId, List<float[]> queries, int topK, String filterJson, int overfetchRatio) {
        p.i(collectionId, "collectionId");
        p.i(queries, "queries");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        if (topK <= 0) {
            throw new IllegalArgumentException("topK must be > 0");
        }
        if (queries.isEmpty()) {
            return C1173v.m();
        }
        int length = queries.get(0).length;
        if (length <= 0) {
            throw new IllegalArgumentException("query dim must be > 0");
        }
        float[] fArr = new float[queries.size() * length];
        int size = queries.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (queries.get(i10).length != length) {
                throw new IllegalArgumentException("all queries must have same dim");
            }
            System.arraycopy(queries.get(i10), 0, fArr, i10 * length, length);
        }
        Object[] objArrNativeSearchBatchInCollection = nativeSearchBatchInCollection(collectionId, fArr, queries.size(), length, topK, filterJson, overfetchRatio);
        if (objArrNativeSearchBatchInCollection == null) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList(objArrNativeSearchBatchInCollection.length);
        for (Object obj : objArrNativeSearchBatchInCollection) {
            Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
            if (objArr != null) {
                Object obj2 = objArr[0];
                long[] jArr = obj2 instanceof long[] ? (long[]) obj2 : null;
                if (jArr == null) {
                    jArr = new long[0];
                }
                Object obj3 = objArr[1];
                float[] fArr2 = obj3 instanceof float[] ? (float[]) obj3 : null;
                if (fArr2 == null) {
                    fArr2 = new float[0];
                }
                int iMin = Math.min(jArr.length, fArr2.length);
                ArrayList arrayList2 = new ArrayList(iMin);
                for (int i11 = 0; i11 < iMin; i11++) {
                    arrayList2.add(new CollectionHit(jArr[i11], fArr2[i11]));
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public final List<SearchResultWithMetadata> searchFull(float[] query, int topK, String filterJson, int overfetchRatio, boolean withMetadata, FilterStrategy filterStrategy) {
        List<SearchResultWithMetadata> listT0;
        p.i(query, "query");
        p.i(filterStrategy, "filterStrategy");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        requireNonEmptyVector(query, "query");
        if (filterJson == null || H.x0(filterJson)) {
            filterJson = null;
        }
        if (overfetchRatio <= 0) {
            overfetchRatio = 2;
        }
        SearchResultWithMetadata[] searchResultWithMetadataArrNativeSearchFull = nativeSearchFull(query, topK, filterJson, overfetchRatio, withMetadata, filterStrategy.getValue());
        return (searchResultWithMetadataArrNativeSearchFull == null || (listT0 = r.T0(searchResultWithMetadataArrNativeSearchFull)) == null) ? C1173v.m() : listT0;
    }

    public final List<CollectionHit> searchInCollection(String collectionId, float[] query, int topK) {
        int iMin;
        p.i(collectionId, "collectionId");
        p.i(query, "query");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        requireNonEmptyVector(query, "query");
        if (topK <= 0) {
            throw new IllegalArgumentException("topK must be > 0");
        }
        Object[] objArrNativeSearchInCollection = nativeSearchInCollection(collectionId, query, topK);
        if (objArrNativeSearchInCollection.length < 2) {
            return C1173v.m();
        }
        Object obj = objArrNativeSearchInCollection[0];
        long[] jArr = obj instanceof long[] ? (long[]) obj : null;
        if (jArr == null) {
            return C1173v.m();
        }
        Object obj2 = objArrNativeSearchInCollection[1];
        float[] fArr = obj2 instanceof float[] ? (float[]) obj2 : null;
        if (fArr != null && (iMin = Math.min(jArr.length, fArr.length)) != 0) {
            ArrayList arrayList = new ArrayList(iMin);
            for (int i10 = 0; i10 < iMin; i10++) {
                arrayList.add(new CollectionHit(jArr[i10], fArr[i10]));
            }
            return arrayList;
        }
        return C1173v.m();
    }

    public final long[] searchInCollectionSync(String collectionId, byte[] queryFp16, int topK, String filter) {
        p.i(collectionId, "collectionId");
        p.i(queryFp16, "queryFp16");
        return !this.initialized ? new long[0] : nativeSearchInCollectionSync(collectionId, queryFp16, topK, filter);
    }

    public final List<CollectionHit> searchInCollectionWithFilter(String collectionId, float[] query, int topK, String filterJson, int overfetchRatio) {
        int iMin;
        p.i(collectionId, "collectionId");
        p.i(query, "query");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        requireNonEmptyVector(query, "query");
        if (topK <= 0) {
            throw new IllegalArgumentException("topK must be > 0");
        }
        Object[] objArrNativeSearchInCollectionWithFilter = nativeSearchInCollectionWithFilter(collectionId, query, topK, filterJson, overfetchRatio);
        if (objArrNativeSearchInCollectionWithFilter.length < 2) {
            return C1173v.m();
        }
        Object obj = objArrNativeSearchInCollectionWithFilter[0];
        long[] jArr = obj instanceof long[] ? (long[]) obj : null;
        if (jArr == null) {
            return C1173v.m();
        }
        Object obj2 = objArrNativeSearchInCollectionWithFilter[1];
        float[] fArr = obj2 instanceof float[] ? (float[]) obj2 : null;
        if (fArr != null && (iMin = Math.min(jArr.length, fArr.length)) != 0) {
            ArrayList arrayList = new ArrayList(iMin);
            for (int i10 = 0; i10 < iMin; i10++) {
                arrayList.add(new CollectionHit(jArr[i10], fArr[i10]));
            }
            return arrayList;
        }
        return C1173v.m();
    }

    public final boolean setCollectionAutoSwitchConfig(String id, boolean enabled, int upgradeThreshold, int downgradeThreshold, long cooldownMs, int checkIntervalWrites) {
        p.i(id, "id");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(id)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        return nativeSetCollectionAutoSwitchConfig(id, enabled, upgradeThreshold, downgradeThreshold, cooldownMs, checkIntervalWrites);
    }

    public final void setCollectionPersistConfig(CollectionPersistConfig config) {
        p.i(config, "config");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        boolean enabled = config.getEnabled();
        Integer checkpointAfterWrites = config.getCheckpointAfterWrites();
        nativeSetCollectionPersistConfig(enabled, checkpointAfterWrites != null ? checkpointAfterWrites.intValue() : 1000, config.getCheckpointIdleSeconds(), config.getUseWal(), config.getWalFsyncEveryN(), config.getAsyncCheckpoint());
    }

    public final void setCollectionResidencyConfig(boolean enabled, int maxCount, long maxBytes, long idleMs) {
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        nativeSetCollectionResidencyConfig(enabled, maxCount, maxBytes, idleMs);
    }

    public final void setGlobalCapacityMaxBytes(long maxBytes) {
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        nativeSetGlobalCapacityMaxBytes(maxBytes);
    }

    public final void setPowerMode(PowerMode mode) {
        p.i(mode, "mode");
        if (this.initialized) {
            nativeSetPowerMode(mode.ordinal());
        }
    }

    public final void shutdown() {
        if (this.initialized) {
            nativeShutdown();
            this.initialized = false;
            Log.i(TAG, "AMEngineNative shutdown", new Throwable("shutdown call stack"));
        }
    }

    public final long totalIonAllocatedBytes() {
        if (this.initialized) {
            return nativeTotalIonAllocatedBytes();
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final void trainIndex() {
        if (!this.initialized) {
            Log.w(TAG, "Cannot train index: engine not initialized");
            return;
        }
        Log.i(TAG, "Training default collection IVF primary (if applicable)...");
        nativeTrainIVF();
        Log.i(TAG, "IVF train request finished");
    }

    public final void triggerCompactScan() {
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        nativeTriggerCompactScan();
    }

    public final boolean triggerIvfTrain(String collectionId, String indexId) {
        p.i(collectionId, "collectionId");
        p.i(indexId, "indexId");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (H.x0(collectionId)) {
            throw new IllegalArgumentException("collection id must not be blank");
        }
        if (H.x0(indexId)) {
            throw new IllegalArgumentException("index id must not be blank");
        }
        return nativeTriggerIvfTrain(collectionId, indexId);
    }

    public final void triggerResidencyScan() {
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        nativeTriggerResidencyScan();
    }

    public final boolean update(long vectorId, float[] newVector, Map<String, ? extends Object> metadataMap) {
        p.i(newVector, "newVector");
        p.i(metadataMap, "metadataMap");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        requireNonEmptyVector(newVector, "newVector");
        return nativeUpdate(vectorId, newVector, new HashMap(metadataMap));
    }

    public final int updateBatch(List<Long> ids, List<float[]> vectors, List<? extends Map<String, ? extends Object>> metadataMaps) {
        p.i(ids, "ids");
        p.i(vectors, "vectors");
        p.i(metadataMaps, "metadataMaps");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        if (ids.size() != vectors.size() || vectors.size() != metadataMaps.size()) {
            throw new IllegalArgumentException("IDs, vectors and metadata list size mismatch");
        }
        if (!vectors.isEmpty()) {
            requireUniformDimension$default(this, vectors, null, 2, null);
        }
        int size = ids.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            if (update(ids.get(i11).longValue(), vectors.get(i11), metadataMaps.get(i11))) {
                i10++;
            }
        }
        return i10;
    }

    public final int updateInCollection(String collectionId, long[] vectorIds, byte[] vectorsFp16, int dimension) {
        p.i(collectionId, "collectionId");
        p.i(vectorIds, "vectorIds");
        p.i(vectorsFp16, "vectorsFp16");
        if (this.initialized) {
            return nativeUpdateInCollection(collectionId, vectorIds, vectorsFp16, dimension);
        }
        return 0;
    }

    public final void updateThermalStatus(ThermalStatus status) {
        p.i(status, "status");
        if (this.initialized) {
            nativeUpdateThermal(status.ordinal());
        }
    }

    public final boolean view(String path) {
        p.i(path, "path");
        if (!this.initialized) {
            throw new IllegalStateException("AMEngineNative not initialized");
        }
        Log.i(TAG, "Memory-mapping database from: " + path + " (zero-copy mode)");
        boolean zNativeView = nativeView(path);
        if (!zNativeView) {
            Log.e(TAG, "✗ Failed to memory-map database");
            return zNativeView;
        }
        Log.i(TAG, "✓ Database memory-mapped: " + getVectorCount() + " vectors (read-only)");
        Log.i(TAG, "  Note: Data will be paged in from disk on-demand");
        return zNativeView;
    }

    private AMEngineNative(AMEConfig aMEConfig, String str) {
        this.config = aMEConfig;
        this.vectorStoragePath = str;
    }

    public static /* synthetic */ List search$default(AMEngineNative aMEngineNative, float[] fArr, int i10, String str, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            i11 = 2;
        }
        return aMEngineNative.search(fArr, i10, str, i11);
    }

    public final long insert(float[] vector, Map<String, ? extends Object> metadataMap) {
        p.i(vector, "vector");
        p.i(metadataMap, "metadataMap");
        if (this.initialized) {
            requireNonEmptyVector$default(this, vector, null, 2, null);
            return nativeInsert(vector, new HashMap(metadataMap));
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final List<SearchResult> search(float[] query, int topK) {
        List<SearchResult> listT0;
        p.i(query, "query");
        if (this.initialized) {
            requireNonEmptyVector(query, "query");
            SearchResult[] searchResultArrNativeSearch = nativeSearch(query, topK);
            return (searchResultArrNativeSearch == null || (listT0 = r.T0(searchResultArrNativeSearch)) == null) ? C1173v.m() : listT0;
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final boolean update(long vectorId, float[] newVector) {
        p.i(newVector, "newVector");
        if (this.initialized) {
            requireNonEmptyVector(newVector, "newVector");
            return nativeUpdate(vectorId, newVector);
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final boolean addShadowIndex(String collectionId, String indexId, int type) {
        p.i(collectionId, "collectionId");
        p.i(indexId, "indexId");
        if (this.initialized) {
            if (!H.x0(collectionId)) {
                if (!H.x0(indexId)) {
                    return nativeAddShadowIndexTyped(collectionId, indexId, type);
                }
                throw new IllegalArgumentException("index id must not be blank");
            }
            throw new IllegalArgumentException("collection id must not be blank");
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final long[] insertBatch(List<float[]> vectors, List<? extends Map<String, ? extends Object>> metadataMaps) {
        p.i(vectors, "vectors");
        p.i(metadataMaps, "metadataMaps");
        if (this.initialized) {
            if (vectors.size() == metadataMaps.size()) {
                if (vectors.isEmpty()) {
                    return new long[0];
                }
                requireUniformDimension$default(this, vectors, null, 2, null);
                int size = vectors.size();
                HashMap<String, Object>[] mapArr = new HashMap[size];
                for (int i10 = 0; i10 < size; i10++) {
                    mapArr[i10] = new HashMap<>(metadataMaps.get(i10));
                }
                return nativeInsertBatchWithMetadata((float[][]) vectors.toArray(new float[0][]), mapArr);
            }
            throw new IllegalArgumentException(("Vectors and metadata list size mismatch: " + vectors.size() + " vs " + metadataMaps.size()).toString());
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final int updateBatch(List<Long> ids, List<float[]> vectors) {
        p.i(ids, "ids");
        p.i(vectors, "vectors");
        if (this.initialized) {
            if (ids.size() == vectors.size()) {
                List<float[]> list = vectors;
                if (!list.isEmpty()) {
                    requireUniformDimension$default(this, vectors, null, 2, null);
                }
                return nativeUpdateBatch(F.n1(ids), (float[][]) list.toArray(new float[0][]));
            }
            throw new IllegalArgumentException(("IDs and vectors size mismatch: " + ids.size() + " vs " + vectors.size()).toString());
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final List<SearchResult> search(float[] query, int topK, String filterJson, int overfetchRatio) {
        List<SearchResult> listT0;
        p.i(query, "query");
        if (this.initialized) {
            requireNonEmptyVector(query, "query");
            if (filterJson == null || H.x0(filterJson)) {
                filterJson = null;
            }
            if (overfetchRatio <= 0) {
                overfetchRatio = 2;
            }
            SearchResult[] searchResultArrNativeSearch = nativeSearch(query, topK, filterJson, overfetchRatio);
            return (searchResultArrNativeSearch == null || (listT0 = r.T0(searchResultArrNativeSearch)) == null) ? C1173v.m() : listT0;
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }

    public final boolean addShadowIndex(String collectionId, String indexId, int type, int numClusters, int nprobe) {
        p.i(collectionId, "collectionId");
        p.i(indexId, "indexId");
        if (this.initialized) {
            if (!H.x0(collectionId)) {
                if (!H.x0(indexId)) {
                    return nativeAddShadowIndexWithParams(collectionId, indexId, type, numClusters, nprobe);
                }
                throw new IllegalArgumentException("index id must not be blank");
            }
            throw new IllegalArgumentException("collection id must not be blank");
        }
        throw new IllegalStateException("AMEngineNative not initialized");
    }
}
