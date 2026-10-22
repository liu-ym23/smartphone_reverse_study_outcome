package com.stepos.datacenter.core.storage;

import La.C0953c;
import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.datacenter.core.storage.b;
import com.stepos.datacenter.core.storage.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001\rB5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u000e¨\u0006'"}, d2 = {"Lcom/stepos/datacenter/core/storage/a;", "", "Lcom/stepos/datacenter/core/storage/FileMagic;", "magic", "", "formatVersion", "", "featureFlags", "createdAtNs", "", "schemaHash", "<init>", "(Lcom/stepos/datacenter/core/storage/FileMagic;IJJ[B)V", Const.INTENT_KEY_APIKEY, "()[B", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/stepos/datacenter/core/storage/FileMagic;", "getMagic", "()Lcom/stepos/datacenter/core/storage/FileMagic;", Const.INTENT_KEY_PKGNAME, "I", "c", "J", "getFeatureFlags", "()J", Const.INTENT_KEY_UMID, "getCreatedAtNs", "e", "[B", "getSchemaHash", "Companion", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: com.stepos.datacenter.core.storage.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class FileHeader {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final FileMagic magic;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int formatVersion;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final long featureFlags;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final long createdAtNs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final byte[] schemaHash;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/stepos/datacenter/core/storage/a$a;", "", "<init>", "()V", "", "schema", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)[B", SingleFileBundle.KEY_BYTES, "", "offset", "Lcom/stepos/datacenter/core/storage/FileMagic;", "expectedMagic", "Lcom/stepos/datacenter/core/storage/c;", Const.INTENT_KEY_PKGNAME, "([BILcom/stepos/datacenter/core/storage/FileMagic;)Lcom/stepos/datacenter/core/storage/c;", "length", "", Const.INTENT_KEY_APIKEY, "([BII)J", "c", "()[B", "EMPTY_SCHEMA_HASH", "HEADER_SIZE", "I", "MAGIC_SIZE", "SCHEMA_HASH_SIZE", "HEADER_CRC_OFFSET", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.core.storage.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final long a(byte[] bytes, int offset, int length) {
            p.i(bytes, "bytes");
            CRC32 crc32 = new CRC32();
            crc32.update(bytes, offset, length);
            return crc32.getValue();
        }

        public final c b(byte[] bytes, int offset, FileMagic expectedMagic) {
            p.i(bytes, "bytes");
            if (bytes.length - offset < 64) {
                return new c.Failure(new b.c(bytes.length - offset, 64));
            }
            byte[] bArrO = C1168p.o(bytes, offset, offset + 64);
            FileMagic fileMagicA = FileMagic.INSTANCE.a(bArrO);
            if (fileMagicA == null) {
                return new c.Failure(new b.d(C1168p.o(bArrO, 0, 8)));
            }
            if (expectedMagic != null && fileMagicA != expectedMagic) {
                return new c.Failure(new b.C0356b(expectedMagic, fileMagicA));
            }
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrO, 60, 4);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            long j10 = byteBufferWrap.order(byteOrder).getInt() & 4294967295L;
            long jA = a(bArrO, 0, 60);
            if (j10 != jA) {
                return new c.Failure(new b.a(j10, jA));
            }
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArrO).order(byteOrder);
            return new c.Success(new FileHeader(fileMagicA, byteBufferOrder.getInt(8), byteBufferOrder.getLong(12), byteBufferOrder.getLong(20), C1168p.o(bArrO, 28, 60)));
        }

        public final byte[] c() {
            return new byte[32];
        }

        public final byte[] d(String schema) throws NoSuchAlgorithmException {
            p.i(schema, "schema");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = schema.getBytes(C0953c.UTF_8);
            p.h(bytes, "getBytes(...)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            p.h(bArrDigest, "digest(...)");
            return bArrDigest;
        }

        public Companion() {
        }
    }

    public FileHeader(FileMagic magic, int i10, long j10, long j11, byte[] schemaHash) {
        p.i(magic, "magic");
        p.i(schemaHash, "schemaHash");
        this.magic = magic;
        this.formatVersion = i10;
        this.featureFlags = j10;
        this.createdAtNs = j11;
        this.schemaHash = schemaHash;
        if (i10 < 0) {
            throw new IllegalArgumentException(("formatVersion must be non-negative, got " + i10).toString());
        }
        if (schemaHash.length == 32) {
            return;
        }
        throw new IllegalArgumentException(("schemaHash must be 32 bytes, got " + schemaHash.length).toString());
    }

    public final byte[] a() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(this.magic.getBytes());
        byteBufferOrder.putInt(this.formatVersion);
        byteBufferOrder.putLong(this.featureFlags);
        byteBufferOrder.putLong(this.createdAtNs);
        byteBufferOrder.put(this.schemaHash);
        Companion companion = INSTANCE;
        byte[] bArrArray = byteBufferOrder.array();
        p.h(bArrArray, "array(...)");
        byteBufferOrder.putInt(60, (int) companion.a(bArrArray, 0, 60));
        byte[] bArrArray2 = byteBufferOrder.array();
        p.h(bArrArray2, "array(...)");
        return bArrArray2;
    }

    /* renamed from: b, reason: from getter */
    public final int getFormatVersion() {
        return this.formatVersion;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileHeader)) {
            return false;
        }
        FileHeader fileHeader = (FileHeader) other;
        return this.magic == fileHeader.magic && this.formatVersion == fileHeader.formatVersion && this.featureFlags == fileHeader.featureFlags && this.createdAtNs == fileHeader.createdAtNs && Arrays.equals(this.schemaHash, fileHeader.schemaHash);
    }

    public int hashCode() {
        return (((((((this.magic.hashCode() * 31) + this.formatVersion) * 31) + Long.hashCode(this.featureFlags)) * 31) + Long.hashCode(this.createdAtNs)) * 31) + Arrays.hashCode(this.schemaHash);
    }

    public String toString() {
        return "FileHeader(magic=" + this.magic + ", formatVersion=" + this.formatVersion + ", featureFlags=" + this.featureFlags + ", createdAtNs=" + this.createdAtNs + ", schemaHash=" + Arrays.toString(this.schemaHash) + ")";
    }

    public /* synthetic */ FileHeader(FileMagic fileMagic, int i10, long j10, long j11, byte[] bArr, int i11, i iVar) {
        this(fileMagic, i10, (i11 & 4) != 0 ? 0L : j10, (i11 & 8) != 0 ? System.nanoTime() : j11, (i11 & 16) != 0 ? INSTANCE.c() : bArr);
    }
}
