package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import lb.InterfaceC4883a;
import nb.AbstractC4951d;
import nb.AbstractC4952e;
import nb.AbstractC4959l;
import nb.AbstractC4960m;
import pb.AbstractC5086b;
import pb.AbstractC5115p0;
import qb.AbstractC5171a;
import qb.C5168A;
import qb.C5172b;
import qb.InterfaceC5178h;
import qb.JsonConfiguration;
import sb.AbstractC5465c;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0013J#\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H$¢\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020/2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010.\u001a\u00020!H\u0014¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u0002072\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020/2\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020<2\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020?2\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020B2\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\bC\u0010DJ\u0017\u0010F\u001a\u00020E2\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\bH\u0010\u0016J\u001f\u0010K\u001a\u00020J2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010I\u001a\u00020!H\u0014¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020J2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\bM\u0010NR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\b\u0018\u0010XR\u0014\u0010\\\u001a\u00020Y8\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_\u0082\u0001\u0003abc¨\u0006d"}, d2 = {"Lrb/c;", "Lpb/p0;", "Lqb/h;", "Lqb/a;", "json", "Lqb/i;", UxipConstants.f30680s, "", "polymorphicDiscriminator", "<init>", "(Lqb/a;Lqb/i;Ljava/lang/String;)V", "Lqb/F;", "literal", "primitive", "tag", "", ExifInterface.LONGITUDE_WEST, "(Lqb/F;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Void;", "H", "()Lqb/i;", "currentTag", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, ExifInterface.GPS_DIRECTION_TRUE, "Llb/a;", "deserializer", "decodeSerializableValue", "(Llb/a;)Ljava/lang/Object;", "parentName", "childName", "z", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lob/c;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lob/c;", "LY8/t;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "decodeNotNullMark", "()Z", "G", "(Ljava/lang/String;)Lqb/i;", "enumDescriptor", "", "M", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "I", "(Ljava/lang/String;)Z", "", "J", "(Ljava/lang/String;)B", "", "R", "(Ljava/lang/String;)S", "P", "(Ljava/lang/String;)I", "", "Q", "(Ljava/lang/String;)J", "", "N", "(Ljava/lang/String;)F", "", "L", "(Ljava/lang/String;)D", "", "K", "(Ljava/lang/String;)C", ExifInterface.LATITUDE_SOUTH, "inlineDescriptor", "Lkotlinx/serialization/encoding/Decoder;", "O", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "decodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", Const.INTENT_KEY_UMID, "Lqb/a;", Const.INTENT_KEY_APIKEY, "()Lqb/a;", "e", "Lqb/i;", "U", "f", "Ljava/lang/String;", "()Ljava/lang/String;", "Lqb/f;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lqb/f;", "configuration", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "serializersModule", "Lrb/w;", "Lrb/B;", "Lrb/D;", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5253c extends AbstractC5115p0 implements InterfaceC5178h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final AbstractC5171a json;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final qb.i value;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String polymorphicDiscriminator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final JsonConfiguration configuration;

    public /* synthetic */ AbstractC5253c(AbstractC5171a abstractC5171a, qb.i iVar, String str, kotlin.jvm.internal.i iVar2) {
        this(abstractC5171a, iVar, str);
    }

    public abstract qb.i G(String tag);

    public final qb.i H() {
        qb.i iVarG;
        String strT = t();
        return (strT == null || (iVarG = G(strT)) == null) ? U() : iVarG;
    }

    @Override // pb.b1
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public boolean i(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        qb.i iVarG = G(tag);
        if (iVarG instanceof qb.F) {
            qb.F f10 = (qb.F) iVarG;
            try {
                Boolean boolE = qb.j.e(f10);
                if (boolE != null) {
                    return boolE.booleanValue();
                }
                W(f10, "boolean", tag);
                throw new KotlinNothingValueException();
            } catch (IllegalArgumentException unused) {
                W(f10, "boolean", tag);
                throw new KotlinNothingValueException();
            }
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.F.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarG.getClass()).t() + " as the serialized body of boolean at element: " + V(tag), iVarG.toString());
    }

    @Override // pb.b1
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public byte j(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        qb.i iVarG = G(tag);
        if (iVarG instanceof qb.F) {
            qb.F f10 = (qb.F) iVarG;
            try {
                long jO = qb.j.o(f10);
                Byte bValueOf = (-128 > jO || jO > 127) ? null : Byte.valueOf((byte) jO);
                if (bValueOf != null) {
                    return bValueOf.byteValue();
                }
                W(f10, "byte", tag);
                throw new KotlinNothingValueException();
            } catch (IllegalArgumentException unused) {
                W(f10, "byte", tag);
                throw new KotlinNothingValueException();
            }
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.F.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarG.getClass()).t() + " as the serialized body of byte at element: " + V(tag), iVarG.toString());
    }

    @Override // pb.b1
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public char k(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        qb.i iVarG = G(tag);
        if (iVarG instanceof qb.F) {
            qb.F f10 = (qb.F) iVarG;
            try {
                return La.K.Q1(f10.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
            } catch (IllegalArgumentException unused) {
                this.W(f10, "char", tag);
                throw new KotlinNothingValueException();
            }
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.F.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarG.getClass()).t() + " as the serialized body of char at element: " + V(tag), iVarG.toString());
    }

    @Override // pb.b1
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public double l(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        qb.i iVarG = G(tag);
        if (iVarG instanceof qb.F) {
            qb.F f10 = (qb.F) iVarG;
            try {
                double dG = qb.j.g(f10);
                if (getJson().getConfiguration().getAllowSpecialFloatingPointValues() || Math.abs(dG) <= Double.MAX_VALUE) {
                    return dG;
                }
                throw C5268s.a(Double.valueOf(dG), tag, H().toString());
            } catch (IllegalArgumentException unused) {
                W(f10, "double", tag);
                throw new KotlinNothingValueException();
            }
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.F.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarG.getClass()).t() + " as the serialized body of double at element: " + V(tag), iVarG.toString());
    }

    @Override // pb.b1
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public int m(String tag, SerialDescriptor enumDescriptor) {
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(enumDescriptor, "enumDescriptor");
        AbstractC5171a json = getJson();
        qb.i iVarG = G(tag);
        String serialName = enumDescriptor.getSerialName();
        if (iVarG instanceof qb.F) {
            return u.k(enumDescriptor, json, ((qb.F) iVarG).getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String(), null, 4, null);
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.F.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarG.getClass()).t() + " as the serialized body of " + serialName + " at element: " + V(tag), iVarG.toString());
    }

    @Override // pb.b1
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public float n(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        qb.i iVarG = G(tag);
        if (iVarG instanceof qb.F) {
            qb.F f10 = (qb.F) iVarG;
            try {
                float fH = qb.j.h(f10);
                if (getJson().getConfiguration().getAllowSpecialFloatingPointValues() || Math.abs(fH) <= Float.MAX_VALUE) {
                    return fH;
                }
                throw C5268s.a(Float.valueOf(fH), tag, H().toString());
            } catch (IllegalArgumentException unused) {
                W(f10, "float", tag);
                throw new KotlinNothingValueException();
            }
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.F.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarG.getClass()).t() + " as the serialized body of float at element: " + V(tag), iVarG.toString());
    }

    @Override // pb.b1
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public Decoder o(String tag, SerialDescriptor inlineDescriptor) {
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(inlineDescriptor, "inlineDescriptor");
        if (!K.b(inlineDescriptor)) {
            return super.o(tag, inlineDescriptor);
        }
        AbstractC5171a json = getJson();
        qb.i iVarG = G(tag);
        String serialName = inlineDescriptor.getSerialName();
        if (iVarG instanceof qb.F) {
            return new r(M.a(json, ((qb.F) iVarG).getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String()), getJson());
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.F.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarG.getClass()).t() + " as the serialized body of " + serialName + " at element: " + V(tag), iVarG.toString());
    }

    @Override // pb.b1
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public int p(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        qb.i iVarG = G(tag);
        if (iVarG instanceof qb.F) {
            qb.F f10 = (qb.F) iVarG;
            try {
                long jO = qb.j.o(f10);
                Integer numValueOf = (-2147483648L > jO || jO > 2147483647L) ? null : Integer.valueOf((int) jO);
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
                W(f10, "int", tag);
                throw new KotlinNothingValueException();
            } catch (IllegalArgumentException unused) {
                W(f10, "int", tag);
                throw new KotlinNothingValueException();
            }
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.F.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarG.getClass()).t() + " as the serialized body of int at element: " + V(tag), iVarG.toString());
    }

    @Override // pb.b1
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public long q(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        qb.i iVarG = G(tag);
        if (iVarG instanceof qb.F) {
            qb.F f10 = (qb.F) iVarG;
            try {
                return qb.j.o(f10);
            } catch (IllegalArgumentException unused) {
                this.W(f10, "long", tag);
                throw new KotlinNothingValueException();
            }
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.F.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarG.getClass()).t() + " as the serialized body of long at element: " + V(tag), iVarG.toString());
    }

    @Override // pb.b1
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public short r(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        qb.i iVarG = G(tag);
        if (iVarG instanceof qb.F) {
            qb.F f10 = (qb.F) iVarG;
            try {
                long jO = qb.j.o(f10);
                Short shValueOf = (-32768 > jO || jO > 32767) ? null : Short.valueOf((short) jO);
                if (shValueOf != null) {
                    return shValueOf.shortValue();
                }
                W(f10, "short", tag);
                throw new KotlinNothingValueException();
            } catch (IllegalArgumentException unused) {
                W(f10, "short", tag);
                throw new KotlinNothingValueException();
            }
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.F.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarG.getClass()).t() + " as the serialized body of short at element: " + V(tag), iVarG.toString());
    }

    @Override // pb.b1
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public String s(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        qb.i iVarG = G(tag);
        if (!(iVarG instanceof qb.F)) {
            throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.F.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarG.getClass()).t() + " as the serialized body of string at element: " + V(tag), iVarG.toString());
        }
        qb.F f10 = (qb.F) iVarG;
        if (!(f10 instanceof qb.w)) {
            throw C5268s.f(-1, "Expected string value for a non-null key '" + tag + "', got null literal instead at element: " + V(tag), H().toString());
        }
        qb.w wVar = (qb.w) f10;
        if (wVar.getIsString() || getJson().getConfiguration().getIsLenient()) {
            return wVar.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String();
        }
        throw C5268s.f(-1, "String literal for key '" + tag + "' should be quoted at element: " + V(tag) + ".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.", H().toString());
    }

    /* renamed from: T, reason: from getter */
    public final String getPolymorphicDiscriminator() {
        return this.polymorphicDiscriminator;
    }

    public abstract qb.i U();

    public final String V(String currentTag) {
        kotlin.jvm.internal.p.i(currentTag, "currentTag");
        return D() + '.' + currentTag;
    }

    public final Void W(qb.F literal, String primitive, String tag) {
        StringBuilder sb2;
        String str;
        if (La.D.X(primitive, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, false, 2, null)) {
            sb2 = new StringBuilder();
            str = "an ";
        } else {
            sb2 = new StringBuilder();
            str = "a ";
        }
        sb2.append(str);
        sb2.append(primitive);
        throw C5268s.f(-1, "Failed to parse literal '" + literal + "' as " + sb2.toString() + " value at element: " + V(tag), H().toString());
    }

    @Override // qb.InterfaceC5178h
    /* renamed from: a, reason: from getter */
    public AbstractC5171a getJson() {
        return this.json;
    }

    @Override // qb.InterfaceC5178h
    public qb.i b() {
        return H();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public ob.c beginStructure(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        qb.i iVarH = H();
        AbstractC4959l kind = descriptor.getKind();
        if (kotlin.jvm.internal.p.d(kind, AbstractC4960m.b.f37294a) || (kind instanceof AbstractC4951d)) {
            AbstractC5171a json = getJson();
            String serialName = descriptor.getSerialName();
            if (iVarH instanceof C5172b) {
                return new C5249D(json, (C5172b) iVarH);
            }
            throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(C5172b.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarH.getClass()).t() + " as the serialized body of " + serialName + " at element: " + D(), iVarH.toString());
        }
        if (!kotlin.jvm.internal.p.d(kind, AbstractC4960m.c.f37295a)) {
            AbstractC5171a json2 = getJson();
            String serialName2 = descriptor.getSerialName();
            if (iVarH instanceof qb.D) {
                return new C5247B(json2, (qb.D) iVarH, this.polymorphicDiscriminator, null, 8, null);
            }
            throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.D.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarH.getClass()).t() + " as the serialized body of " + serialName2 + " at element: " + D(), iVarH.toString());
        }
        AbstractC5171a json3 = getJson();
        SerialDescriptor serialDescriptorA = T.a(descriptor.g(0), json3.getSerializersModule());
        AbstractC4959l kind2 = serialDescriptorA.getKind();
        if ((kind2 instanceof AbstractC4952e) || kotlin.jvm.internal.p.d(kind2, AbstractC4959l.b.f37292a)) {
            AbstractC5171a json4 = getJson();
            String serialName3 = descriptor.getSerialName();
            if (iVarH instanceof qb.D) {
                return new F(json4, (qb.D) iVarH);
            }
            throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.D.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarH.getClass()).t() + " as the serialized body of " + serialName3 + " at element: " + D(), iVarH.toString());
        }
        if (!json3.getConfiguration().getAllowStructuredMapKeys()) {
            throw C5268s.d(serialDescriptorA);
        }
        AbstractC5171a json5 = getJson();
        String serialName4 = descriptor.getSerialName();
        if (iVarH instanceof C5172b) {
            return new C5249D(json5, (C5172b) iVarH);
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(C5172b.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarH.getClass()).t() + " as the serialized body of " + serialName4 + " at element: " + D(), iVarH.toString());
    }

    @Override // pb.b1, kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return t() != null ? super.decodeInline(descriptor) : new w(getJson(), U(), this.polymorphicDiscriminator).decodeInline(descriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !(H() instanceof C5168A);
    }

    @Override // pb.b1, kotlinx.serialization.encoding.Decoder
    public <T> T decodeSerializableValue(InterfaceC4883a<? extends T> deserializer) {
        qb.F fK;
        kotlin.jvm.internal.p.i(deserializer, "deserializer");
        if (!(deserializer instanceof AbstractC5086b) || getJson().getConfiguration().getUseArrayPolymorphism()) {
            return deserializer.deserialize(this);
        }
        AbstractC5086b abstractC5086b = (AbstractC5086b) deserializer;
        String strC = H.c(abstractC5086b.getDescriptor(), getJson());
        qb.i iVarB = b();
        String serialName = abstractC5086b.getDescriptor().getSerialName();
        if (iVarB instanceof qb.D) {
            qb.D d10 = (qb.D) iVarB;
            qb.i iVar = (qb.i) d10.get(strC);
            try {
                InterfaceC4883a interfaceC4883aA = lb.f.a((AbstractC5086b) deserializer, this, (iVar == null || (fK = qb.j.k(iVar)) == null) ? null : qb.j.f(fK));
                kotlin.jvm.internal.p.g(interfaceC4883aA, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                return (T) P.b(getJson(), strC, d10, interfaceC4883aA);
            } catch (SerializationException e10) {
                String message = e10.getMessage();
                kotlin.jvm.internal.p.f(message);
                throw C5268s.f(-1, message, d10.toString());
            }
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.D.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarB.getClass()).t() + " as the serialized body of " + serialName + " at element: " + D(), iVarB.toString());
    }

    public void endStructure(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
    }

    @Override // ob.c
    public AbstractC5465c getSerializersModule() {
        return getJson().getSerializersModule();
    }

    @Override // pb.AbstractC5115p0
    public String z(String parentName, String childName) {
        kotlin.jvm.internal.p.i(parentName, "parentName");
        kotlin.jvm.internal.p.i(childName, "childName");
        return childName;
    }

    public /* synthetic */ AbstractC5253c(AbstractC5171a abstractC5171a, qb.i iVar, String str, int i10, kotlin.jvm.internal.i iVar2) {
        this(abstractC5171a, iVar, (i10 & 4) != 0 ? null : str, null);
    }

    public AbstractC5253c(AbstractC5171a abstractC5171a, qb.i iVar, String str) {
        this.json = abstractC5171a;
        this.value = iVar;
        this.polymorphicDiscriminator = str;
        this.configuration = getJson().getConfiguration();
    }
}
