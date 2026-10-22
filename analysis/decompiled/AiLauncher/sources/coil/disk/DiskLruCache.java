package coil.disk;

import La.D;
import La.H;
import Mb.AbstractC0971i;
import Mb.AbstractC0972j;
import Mb.G;
import Mb.InterfaceC0967e;
import Mb.u;
import Mb.z;
import Ua.C1060i;
import Ua.I;
import Ua.L0;
import Ua.M;
import Y8.t;
import coil.disk.DiskLruCache;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import io.ktor.http.ContentDisposition;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import p9.InterfaceC5074l;
import v1.C5654b;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\u0005*\u0001_\b\u0000\u0018\u0000 b2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0004>:<8B7\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u000f\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u0013J#\u0010!\u001a\u00020\u00112\n\u0010\u001e\u001a\u00060\u001dR\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u001b\u0010'\u001a\u00020\u001f2\n\u0010&\u001a\u00060%R\u00020\u0000H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0011H\u0002¢\u0006\u0004\b)\u0010\u0013J\u000f\u0010*\u001a\u00020\u0011H\u0002¢\u0006\u0004\b*\u0010\u0013J\u000f\u0010+\u001a\u00020\u001fH\u0002¢\u0006\u0004\b+\u0010$J\u000f\u0010,\u001a\u00020\u0011H\u0002¢\u0006\u0004\b,\u0010\u0013J\u000f\u0010-\u001a\u00020\u0011H\u0002¢\u0006\u0004\b-\u0010\u0013J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0017H\u0002¢\u0006\u0004\b/\u0010\u001aJ\r\u00100\u001a\u00020\u0011¢\u0006\u0004\b0\u0010\u0013J\u001e\u00102\u001a\b\u0018\u000101R\u00020\u00002\u0006\u0010.\u001a\u00020\u0017H\u0086\u0002¢\u0006\u0004\b2\u00103J\u001b\u00104\u001a\b\u0018\u00010\u001dR\u00020\u00002\u0006\u0010.\u001a\u00020\u0017¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0011H\u0016¢\u0006\u0004\b6\u0010\u0013J\u000f\u00107\u001a\u00020\u0011H\u0016¢\u0006\u0004\b7\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010@\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00109R\u0014\u0010B\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u00109R\u0014\u0010D\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00109R$\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\b\u0012\u00060%R\u00020\u00000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010;R\u0016\u0010P\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010=R\u0018\u0010S\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010Z\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010UR\u0016\u0010\\\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010UR\u0016\u0010^\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010UR\u0014\u0010\u0005\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010a¨\u0006c"}, d2 = {"Lcoil/disk/DiskLruCache;", "Ljava/io/Closeable;", "Lokio/Closeable;", "Ljava/io/Flushable;", "LMb/i;", "fileSystem", "LMb/z;", "directory", "LUa/I;", "cleanupDispatcher", "", "maxSize", "", "appVersion", "valueCount", "<init>", "(LMb/i;LMb/z;LUa/I;JII)V", "LY8/t;", "f1", "()V", "LMb/e;", "Y0", "()LMb/e;", "", "line", "h1", "(Ljava/lang/String;)V", "b1", "t1", "Lcoil/disk/DiskLruCache$b;", "editor", "", "success", "k0", "(Lcoil/disk/DiskLruCache$b;Z)V", "R0", "()Z", "Lcoil/disk/DiskLruCache$c;", "entry", "k1", "(Lcoil/disk/DiskLruCache$c;)Z", "g0", "m1", "l1", "v0", "T0", "key", "s1", "N0", "Lcoil/disk/DiskLruCache$d;", "I0", "(Ljava/lang/String;)Lcoil/disk/DiskLruCache$d;", "D0", "(Ljava/lang/String;)Lcoil/disk/DiskLruCache$b;", "close", "flush", Const.INTENT_KEY_APIKEY, "LMb/z;", Const.INTENT_KEY_PKGNAME, "J", "c", "I", Const.INTENT_KEY_UMID, "e", "journalFile", "f", "journalFileTmp", Const.INTENT_KEY_BACKGROUND_COMMAND, "journalFileBackup", "Ljava/util/LinkedHashMap;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/LinkedHashMap;", "lruEntries", "LUa/M;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LUa/M;", "cleanupScope", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, ContentDisposition.Parameters.Size, "k", "operationsSinceRewrite", "l", "LMb/e;", "journalWriter", "m", "Z", "hasJournalErrors", "n", "initialized", "o", AlipayXuiIsland.REASON_CLOSED, "p", "mostRecentTrimFailed", "q", "mostRecentRebuildFailed", "coil/disk/DiskLruCache$e", "r", "Lcoil/disk/DiskLruCache$e;", "s", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable, Flushable {

    /* renamed from: t, reason: collision with root package name */
    public static final Regex f15606t = new Regex("[a-z0-9_-]{1,120}");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final z directory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long maxSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int appVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int valueCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final z journalFile;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final z journalFileTmp;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final z journalFileBackup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final LinkedHashMap<String, c> lruEntries;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final M cleanupScope;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public long size;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public int operationsSinceRewrite;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public InterfaceC0967e journalWriter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public boolean hasJournalErrors;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public boolean initialized;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public boolean mostRecentTrimFailed;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public boolean mostRecentRebuildFailed;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final e fileSystem;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0018\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\u0013\u0010\u0011\u001a\b\u0018\u00010\u0010R\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0004\u001a\u00060\u0002R\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0017\u0010!\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcoil/disk/DiskLruCache$b;", "", "Lcoil/disk/DiskLruCache$c;", "Lcoil/disk/DiskLruCache;", "entry", "<init>", "(Lcoil/disk/DiskLruCache;Lcoil/disk/DiskLruCache$c;)V", "", "index", "LMb/z;", "f", "(I)LMb/z;", "LY8/t;", "e", "()V", Const.INTENT_KEY_PKGNAME, "Lcoil/disk/DiskLruCache$d;", "c", "()Lcoil/disk/DiskLruCache$d;", Const.INTENT_KEY_APIKEY, "", "success", Const.INTENT_KEY_UMID, "(Z)V", "Lcoil/disk/DiskLruCache$c;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcoil/disk/DiskLruCache$c;", "Z", AlipayXuiIsland.REASON_CLOSED, "", "[Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()[Z", "written", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final c entry;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public boolean closed;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final boolean[] written;

        public b(c cVar) {
            this.entry = cVar;
            this.written = new boolean[DiskLruCache.this.valueCount];
        }

        public final void a() {
            d(false);
        }

        public final void b() {
            d(true);
        }

        public final d c() {
            d dVarI0;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                b();
                dVarI0 = diskLruCache.I0(this.entry.getKey());
            }
            return dVarI0;
        }

        public final void d(boolean success) {
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                try {
                    if (this.closed) {
                        throw new IllegalStateException("editor is closed");
                    }
                    if (p.d(this.entry.getCurrentEditor(), this)) {
                        diskLruCache.k0(this, success);
                    }
                    this.closed = true;
                    t tVar = t.f7040a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void e() {
            if (p.d(this.entry.getCurrentEditor(), this)) {
                this.entry.m(true);
            }
        }

        public final z f(int index) {
            z zVar;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (this.closed) {
                    throw new IllegalStateException("editor is closed");
                }
                this.written[index] = true;
                z zVar2 = this.entry.c().get(index);
                F1.e.a(diskLruCache.fileSystem, zVar2);
                zVar = zVar2;
            }
            return zVar;
        }

        /* renamed from: g, reason: from getter */
        public final c getEntry() {
            return this.entry;
        }

        /* renamed from: h, reason: from getter */
        public final boolean[] getWritten() {
            return this.written;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\b\u0018\u00010\u000fR\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0013\u0010!R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b\u001f\u0010!R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010.\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R(\u00104\u001a\b\u0018\u00010/R\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u00100\u001a\u0004\b\u0018\u00101\"\u0004\b2\u00103R\"\u0010:\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u00106\u001a\u0004\b+\u00107\"\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcoil/disk/DiskLruCache$c;", "", "", "key", "<init>", "(Lcoil/disk/DiskLruCache;Ljava/lang/String;)V", "", "strings", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/List;)V", "LMb/e;", "writer", "o", "(LMb/e;)V", "Lcoil/disk/DiskLruCache$d;", "Lcoil/disk/DiskLruCache;", "n", "()Lcoil/disk/DiskLruCache$d;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "", Const.INTENT_KEY_PKGNAME, "[J", "e", "()[J", "lengths", "Ljava/util/ArrayList;", "LMb/z;", "c", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "cleanFiles", "dirtyFiles", "", "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "l", "(Z)V", "readable", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "m", "zombie", "Lcoil/disk/DiskLruCache$b;", "Lcoil/disk/DiskLruCache$b;", "()Lcoil/disk/DiskLruCache$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcoil/disk/DiskLruCache$b;)V", "currentEditor", "", "I", "()I", "k", "(I)V", "lockingSnapshotCount", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String key;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final long[] lengths;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final ArrayList<z> cleanFiles;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final ArrayList<z> dirtyFiles;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public boolean readable;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public boolean zombie;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public b currentEditor;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public int lockingSnapshotCount;

        public c(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new ArrayList<>(DiskLruCache.this.valueCount);
            this.dirtyFiles = new ArrayList<>(DiskLruCache.this.valueCount);
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            int i10 = DiskLruCache.this.valueCount;
            for (int i11 = 0; i11 < i10; i11++) {
                sb2.append(i11);
                this.cleanFiles.add(DiskLruCache.this.directory.n(sb2.toString()));
                sb2.append(".tmp");
                this.dirtyFiles.add(DiskLruCache.this.directory.n(sb2.toString()));
                sb2.setLength(length);
            }
        }

        public final ArrayList<z> a() {
            return this.cleanFiles;
        }

        /* renamed from: b, reason: from getter */
        public final b getCurrentEditor() {
            return this.currentEditor;
        }

        public final ArrayList<z> c() {
            return this.dirtyFiles;
        }

        /* renamed from: d, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* renamed from: e, reason: from getter */
        public final long[] getLengths() {
            return this.lengths;
        }

        /* renamed from: f, reason: from getter */
        public final int getLockingSnapshotCount() {
            return this.lockingSnapshotCount;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getReadable() {
            return this.readable;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getZombie() {
            return this.zombie;
        }

        public final void i(b bVar) {
            this.currentEditor = bVar;
        }

        public final void j(List<String> strings) throws IOException {
            if (strings.size() != DiskLruCache.this.valueCount) {
                throw new IOException("unexpected journal line: " + strings);
            }
            try {
                int size = strings.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.lengths[i10] = Long.parseLong(strings.get(i10));
                }
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + strings);
            }
        }

        public final void k(int i10) {
            this.lockingSnapshotCount = i10;
        }

        public final void l(boolean z10) {
            this.readable = z10;
        }

        public final void m(boolean z10) {
            this.zombie = z10;
        }

        public final d n() {
            if (!this.readable || this.currentEditor != null || this.zombie) {
                return null;
            }
            ArrayList<z> arrayList = this.cleanFiles;
            DiskLruCache diskLruCache = DiskLruCache.this;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!diskLruCache.fileSystem.J(arrayList.get(i10))) {
                    try {
                        diskLruCache.k1(this);
                    } catch (IOException unused) {
                    }
                    return null;
                }
            }
            this.lockingSnapshotCount++;
            return DiskLruCache.this.new d(this);
        }

        public final void o(InterfaceC0967e writer) throws IOException {
            for (long j10 : this.lengths) {
                writer.writeByte(32).s0(j10);
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0005\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\b\u0018\u00010\u0010R\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u00060\u0003R\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcoil/disk/DiskLruCache$d;", "Ljava/io/Closeable;", "Lokio/Closeable;", "Lcoil/disk/DiskLruCache$c;", "Lcoil/disk/DiskLruCache;", "entry", "<init>", "(Lcoil/disk/DiskLruCache;Lcoil/disk/DiskLruCache$c;)V", "", "index", "LMb/z;", "e", "(I)LMb/z;", "LY8/t;", "close", "()V", "Lcoil/disk/DiskLruCache$b;", Const.INTENT_KEY_PKGNAME, "()Lcoil/disk/DiskLruCache$b;", Const.INTENT_KEY_APIKEY, "Lcoil/disk/DiskLruCache$c;", "getEntry", "()Lcoil/disk/DiskLruCache$c;", "", "Z", AlipayXuiIsland.REASON_CLOSED, "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class d implements Closeable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final c entry;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public boolean closed;

        public d(c cVar) {
            this.entry = cVar;
        }

        public final b b() {
            b bVarD0;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                close();
                bVarD0 = diskLruCache.D0(this.entry.getKey());
            }
            return bVarD0;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                try {
                    this.entry.k(r1.getLockingSnapshotCount() - 1);
                    if (this.entry.getLockingSnapshotCount() == 0 && this.entry.getZombie()) {
                        diskLruCache.k1(this.entry);
                    }
                    t tVar = t.f7040a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final z e(int index) {
            if (this.closed) {
                throw new IllegalStateException("snapshot is closed");
            }
            return this.entry.a().get(index);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"coil/disk/DiskLruCache$e", "LMb/j;", "LMb/z;", Const.STR_FILE, "", "mustCreate", "LMb/G;", "k0", "(LMb/z;Z)LMb/G;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends AbstractC0972j {
        public e(AbstractC0971i abstractC0971i) {
            super(abstractC0971i);
        }

        @Override // Mb.AbstractC0972j, Mb.AbstractC0971i
        public G k0(z file, boolean mustCreate) throws IOException {
            z zVarK = file.k();
            if (zVarK != null) {
                i(zVarK);
            }
            return super.k0(file, mustCreate);
        }
    }

    public DiskLruCache(AbstractC0971i abstractC0971i, z zVar, I i10, long j10, int i11, int i12) {
        this.directory = zVar;
        this.maxSize = j10;
        this.appVersion = i11;
        this.valueCount = i12;
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i12 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        this.journalFile = zVar.n("journal");
        this.journalFileTmp = zVar.n("journal.tmp");
        this.journalFileBackup = zVar.n("journal.bkp");
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupScope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(i10.m1(1)));
        this.fileSystem = new e(abstractC0971i);
    }

    public static final t a1(DiskLruCache diskLruCache, IOException iOException) {
        diskLruCache.hasJournalErrors = true;
        return t.f7040a;
    }

    public final synchronized b D0(String key) {
        g0();
        s1(key);
        N0();
        c cVar = this.lruEntries.get(key);
        if ((cVar != null ? cVar.getCurrentEditor() : null) != null) {
            return null;
        }
        if (cVar != null && cVar.getLockingSnapshotCount() != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            InterfaceC0967e interfaceC0967e = this.journalWriter;
            p.f(interfaceC0967e);
            interfaceC0967e.L("DIRTY");
            interfaceC0967e.writeByte(32);
            interfaceC0967e.L(key);
            interfaceC0967e.writeByte(10);
            interfaceC0967e.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (cVar == null) {
                cVar = new c(key);
                this.lruEntries.put(key, cVar);
            }
            b bVar = new b(cVar);
            cVar.i(bVar);
            return bVar;
        }
        T0();
        return null;
    }

    public final synchronized d I0(String key) {
        d dVarN;
        g0();
        s1(key);
        N0();
        c cVar = this.lruEntries.get(key);
        if (cVar != null && (dVarN = cVar.n()) != null) {
            this.operationsSinceRewrite++;
            InterfaceC0967e interfaceC0967e = this.journalWriter;
            p.f(interfaceC0967e);
            interfaceC0967e.L("READ");
            interfaceC0967e.writeByte(32);
            interfaceC0967e.L(key);
            interfaceC0967e.writeByte(10);
            if (R0()) {
                T0();
            }
            return dVarN;
        }
        return null;
    }

    public final synchronized void N0() {
        try {
            if (this.initialized) {
                return;
            }
            this.fileSystem.A(this.journalFileTmp);
            if (this.fileSystem.J(this.journalFileBackup)) {
                if (this.fileSystem.J(this.journalFile)) {
                    this.fileSystem.A(this.journalFileBackup);
                } else {
                    this.fileSystem.g(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.J(this.journalFile)) {
                try {
                    f1();
                    b1();
                    this.initialized = true;
                    return;
                } catch (IOException unused) {
                    try {
                        v0();
                        this.closed = false;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            t1();
            this.initialized = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final boolean R0() {
        return this.operationsSinceRewrite >= 2000;
    }

    public final void T0() {
        C1060i.d(this.cleanupScope, null, null, new DiskLruCache$launchCleanup$1(this, null), 3, null);
    }

    public final InterfaceC0967e Y0() {
        return u.b(new C5654b(this.fileSystem.b(this.journalFile), new InterfaceC5074l() { // from class: v1.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DiskLruCache.a1(this.f42691a, (IOException) obj);
            }
        }));
    }

    public final void b1() throws IOException {
        Iterator<c> it = this.lruEntries.values().iterator();
        long j10 = 0;
        while (it.hasNext()) {
            c next = it.next();
            int i10 = 0;
            if (next.getCurrentEditor() == null) {
                int i11 = this.valueCount;
                while (i10 < i11) {
                    j10 += next.getLengths()[i10];
                    i10++;
                }
            } else {
                next.i(null);
                int i12 = this.valueCount;
                while (i10 < i12) {
                    this.fileSystem.A(next.a().get(i10));
                    this.fileSystem.A(next.c().get(i10));
                    i10++;
                }
                it.remove();
            }
        }
        this.size = j10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.initialized && !this.closed) {
                for (c cVar : (c[]) this.lruEntries.values().toArray(new c[0])) {
                    b currentEditor = cVar.getCurrentEditor();
                    if (currentEditor != null) {
                        currentEditor.e();
                    }
                }
                m1();
                kotlinx.coroutines.d.e(this.cleanupScope, null, 1, null);
                InterfaceC0967e interfaceC0967e = this.journalWriter;
                p.f(interfaceC0967e);
                interfaceC0967e.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f1() throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            coil.disk.DiskLruCache$e r1 = r9.fileSystem
            Mb.z r2 = r9.journalFile
            Mb.I r1 = r1.v0(r2)
            Mb.f r1 = Mb.u.c(r1)
            java.lang.String r2 = r1.h0()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = r1.h0()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = r1.h0()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = r1.h0()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r6 = r1.h0()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = kotlin.jvm.internal.p.d(r7, r2)     // Catch: java.lang.Throwable -> L5b
            if (r7 == 0) goto L82
            java.lang.String r7 = "1"
            boolean r7 = kotlin.jvm.internal.p.d(r7, r3)     // Catch: java.lang.Throwable -> L5b
            if (r7 == 0) goto L82
            int r7 = r9.appVersion     // Catch: java.lang.Throwable -> L5b
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L5b
            boolean r7 = kotlin.jvm.internal.p.d(r7, r4)     // Catch: java.lang.Throwable -> L5b
            if (r7 == 0) goto L82
            int r7 = r9.valueCount     // Catch: java.lang.Throwable -> L5b
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L5b
            boolean r7 = kotlin.jvm.internal.p.d(r7, r5)     // Catch: java.lang.Throwable -> L5b
            if (r7 == 0) goto L82
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L5b
            if (r7 > 0) goto L82
            r0 = 0
        L51:
            java.lang.String r2 = r1.h0()     // Catch: java.lang.Throwable -> L5b java.io.EOFException -> L5d
            r9.h1(r2)     // Catch: java.lang.Throwable -> L5b java.io.EOFException -> L5d
            int r0 = r0 + 1
            goto L51
        L5b:
            r9 = move-exception
            goto Lb6
        L5d:
            java.util.LinkedHashMap<java.lang.String, coil.disk.DiskLruCache$c> r2 = r9.lruEntries     // Catch: java.lang.Throwable -> L5b
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L5b
            int r0 = r0 - r2
            r9.operationsSinceRewrite = r0     // Catch: java.lang.Throwable -> L5b
            boolean r0 = r1.k()     // Catch: java.lang.Throwable -> L5b
            if (r0 != 0) goto L70
            r9.t1()     // Catch: java.lang.Throwable -> L5b
            goto L76
        L70:
            Mb.e r0 = r9.Y0()     // Catch: java.lang.Throwable -> L5b
            r9.journalWriter = r0     // Catch: java.lang.Throwable -> L5b
        L76:
            Y8.t r9 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L80
            r1.close()     // Catch: java.lang.Throwable -> L7e
            goto L80
        L7e:
            r9 = move-exception
            goto Lc0
        L80:
            r9 = 0
            goto Lc0
        L82:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L5b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r7.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch: java.lang.Throwable -> L5b
            r7.append(r2)     // Catch: java.lang.Throwable -> L5b
            r7.append(r0)     // Catch: java.lang.Throwable -> L5b
            r7.append(r3)     // Catch: java.lang.Throwable -> L5b
            r7.append(r0)     // Catch: java.lang.Throwable -> L5b
            r7.append(r4)     // Catch: java.lang.Throwable -> L5b
            r7.append(r0)     // Catch: java.lang.Throwable -> L5b
            r7.append(r5)     // Catch: java.lang.Throwable -> L5b
            r7.append(r0)     // Catch: java.lang.Throwable -> L5b
            r7.append(r6)     // Catch: java.lang.Throwable -> L5b
            r0 = 93
            r7.append(r0)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r0 = r7.toString()     // Catch: java.lang.Throwable -> L5b
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L5b
            throw r9     // Catch: java.lang.Throwable -> L5b
        Lb6:
            if (r1 == 0) goto Lc0
            r1.close()     // Catch: java.lang.Throwable -> Lbc
            goto Lc0
        Lbc:
            r0 = move-exception
            Y8.d.a(r9, r0)
        Lc0:
            if (r9 != 0) goto Lc3
            return
        Lc3:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.disk.DiskLruCache.f1():void");
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.initialized) {
            g0();
            m1();
            InterfaceC0967e interfaceC0967e = this.journalWriter;
            p.f(interfaceC0967e);
            interfaceC0967e.flush();
        }
    }

    public final void g0() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final void h1(String line) throws IOException {
        String strSubstring;
        int iT0 = H.t0(line, ' ', 0, false, 6, null);
        if (iT0 == -1) {
            throw new IOException("unexpected journal line: " + line);
        }
        int i10 = iT0 + 1;
        int iT02 = H.t0(line, ' ', i10, false, 4, null);
        if (iT02 == -1) {
            strSubstring = line.substring(i10);
            p.h(strSubstring, "substring(...)");
            if (iT0 == 6 && D.X(line, "REMOVE", false, 2, null)) {
                this.lruEntries.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = line.substring(i10, iT02);
            p.h(strSubstring, "substring(...)");
        }
        LinkedHashMap<String, c> linkedHashMap = this.lruEntries;
        c cVar = linkedHashMap.get(strSubstring);
        if (cVar == null) {
            cVar = new c(strSubstring);
            linkedHashMap.put(strSubstring, cVar);
        }
        c cVar2 = cVar;
        if (iT02 != -1 && iT0 == 5 && D.X(line, "CLEAN", false, 2, null)) {
            String strSubstring2 = line.substring(iT02 + 1);
            p.h(strSubstring2, "substring(...)");
            List<String> listA1 = H.a1(strSubstring2, new char[]{' '}, false, 0, 6, null);
            cVar2.l(true);
            cVar2.i(null);
            cVar2.j(listA1);
            return;
        }
        if (iT02 == -1 && iT0 == 5 && D.X(line, "DIRTY", false, 2, null)) {
            cVar2.i(new b(cVar2));
            return;
        }
        if (iT02 == -1 && iT0 == 4 && D.X(line, "READ", false, 2, null)) {
            return;
        }
        throw new IOException("unexpected journal line: " + line);
    }

    public final synchronized void k0(b editor, boolean success) {
        c entry = editor.getEntry();
        if (!p.d(entry.getCurrentEditor(), editor)) {
            throw new IllegalStateException("Check failed.");
        }
        int i10 = 0;
        if (!success || entry.getZombie()) {
            int i11 = this.valueCount;
            while (i10 < i11) {
                this.fileSystem.A(entry.c().get(i10));
                i10++;
            }
        } else {
            int i12 = this.valueCount;
            for (int i13 = 0; i13 < i12; i13++) {
                if (editor.getWritten()[i13] && !this.fileSystem.J(entry.c().get(i13))) {
                    editor.a();
                    return;
                }
            }
            int i14 = this.valueCount;
            while (i10 < i14) {
                z zVar = entry.c().get(i10);
                z zVar2 = entry.a().get(i10);
                if (this.fileSystem.J(zVar)) {
                    this.fileSystem.g(zVar, zVar2);
                } else {
                    F1.e.a(this.fileSystem, entry.a().get(i10));
                }
                long j10 = entry.getLengths()[i10];
                Long size = this.fileSystem.V(zVar2).getSize();
                long jLongValue = size != null ? size.longValue() : 0L;
                entry.getLengths()[i10] = jLongValue;
                this.size = (this.size - j10) + jLongValue;
                i10++;
            }
        }
        entry.i(null);
        if (entry.getZombie()) {
            k1(entry);
            return;
        }
        this.operationsSinceRewrite++;
        InterfaceC0967e interfaceC0967e = this.journalWriter;
        p.f(interfaceC0967e);
        if (success || entry.getReadable()) {
            entry.l(true);
            interfaceC0967e.L("CLEAN");
            interfaceC0967e.writeByte(32);
            interfaceC0967e.L(entry.getKey());
            entry.o(interfaceC0967e);
            interfaceC0967e.writeByte(10);
        } else {
            this.lruEntries.remove(entry.getKey());
            interfaceC0967e.L("REMOVE");
            interfaceC0967e.writeByte(32);
            interfaceC0967e.L(entry.getKey());
            interfaceC0967e.writeByte(10);
        }
        interfaceC0967e.flush();
        if (this.size > this.maxSize || R0()) {
            T0();
        }
    }

    public final boolean k1(c entry) throws IOException {
        InterfaceC0967e interfaceC0967e;
        if (entry.getLockingSnapshotCount() > 0 && (interfaceC0967e = this.journalWriter) != null) {
            interfaceC0967e.L("DIRTY");
            interfaceC0967e.writeByte(32);
            interfaceC0967e.L(entry.getKey());
            interfaceC0967e.writeByte(10);
            interfaceC0967e.flush();
        }
        if (entry.getLockingSnapshotCount() > 0 || entry.getCurrentEditor() != null) {
            entry.m(true);
            return true;
        }
        int i10 = this.valueCount;
        for (int i11 = 0; i11 < i10; i11++) {
            this.fileSystem.A(entry.a().get(i11));
            this.size -= entry.getLengths()[i11];
            entry.getLengths()[i11] = 0;
        }
        this.operationsSinceRewrite++;
        InterfaceC0967e interfaceC0967e2 = this.journalWriter;
        if (interfaceC0967e2 != null) {
            interfaceC0967e2.L("REMOVE");
            interfaceC0967e2.writeByte(32);
            interfaceC0967e2.L(entry.getKey());
            interfaceC0967e2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey());
        if (R0()) {
            T0();
        }
        return true;
    }

    public final boolean l1() throws IOException {
        for (c cVar : this.lruEntries.values()) {
            if (!cVar.getZombie()) {
                k1(cVar);
                return true;
            }
        }
        return false;
    }

    public final void m1() {
        while (this.size > this.maxSize) {
            if (!l1()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    public final void s1(String key) {
        if (f15606t.k(key)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + key + JsonFactory.DEFAULT_QUOTE_CHAR).toString());
    }

    public final synchronized void t1() {
        Throwable th;
        try {
            InterfaceC0967e interfaceC0967e = this.journalWriter;
            if (interfaceC0967e != null) {
                interfaceC0967e.close();
            }
            InterfaceC0967e interfaceC0967eB = u.b(this.fileSystem.k0(this.journalFileTmp, false));
            try {
                interfaceC0967eB.L("libcore.io.DiskLruCache").writeByte(10);
                interfaceC0967eB.L("1").writeByte(10);
                interfaceC0967eB.s0(this.appVersion).writeByte(10);
                interfaceC0967eB.s0(this.valueCount).writeByte(10);
                interfaceC0967eB.writeByte(10);
                for (c cVar : this.lruEntries.values()) {
                    if (cVar.getCurrentEditor() != null) {
                        interfaceC0967eB.L("DIRTY");
                        interfaceC0967eB.writeByte(32);
                        interfaceC0967eB.L(cVar.getKey());
                        interfaceC0967eB.writeByte(10);
                    } else {
                        interfaceC0967eB.L("CLEAN");
                        interfaceC0967eB.writeByte(32);
                        interfaceC0967eB.L(cVar.getKey());
                        cVar.o(interfaceC0967eB);
                        interfaceC0967eB.writeByte(10);
                    }
                }
                t tVar = t.f7040a;
                if (interfaceC0967eB != null) {
                    try {
                        interfaceC0967eB.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    th = null;
                }
            } catch (Throwable th3) {
                if (interfaceC0967eB != null) {
                    try {
                        interfaceC0967eB.close();
                    } catch (Throwable th4) {
                        Y8.d.a(th3, th4);
                    }
                }
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            if (this.fileSystem.J(this.journalFile)) {
                this.fileSystem.g(this.journalFile, this.journalFileBackup);
                this.fileSystem.g(this.journalFileTmp, this.journalFile);
                this.fileSystem.A(this.journalFileBackup);
            } else {
                this.fileSystem.g(this.journalFileTmp, this.journalFile);
            }
            this.journalWriter = Y0();
            this.operationsSinceRewrite = 0;
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public final void v0() throws IOException {
        close();
        F1.e.b(this.fileSystem, this.directory);
    }
}
