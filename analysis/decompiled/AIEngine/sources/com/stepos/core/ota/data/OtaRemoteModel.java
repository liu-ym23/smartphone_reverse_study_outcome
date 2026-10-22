package com.stepos.core.ota.data;

import a0.a;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import com.tonyodev.fetch2core.server.FileResponse;
import e5.b;
import gc.q;
import h0.e;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaRemoteModel {

    @b("abilities")
    private final List<String> abilities;

    @b(alternate = {"dekCipher"}, value = "dek_cipher")
    private final String dek_cipher;

    @b("dependencies")
    private final List<String> dependencies;

    @b("file_size")
    private final long file_size;

    @b("i18n")
    private final String i18n;

    @b(FileResponse.FIELD_MD5)
    private final String md5;

    @b("model_id")
    private final String name;

    @b("resourceUrl")
    private final String resource_url;

    @b("update_info")
    private final String update_info;

    @b("update_time")
    private final long update_time;

    @b("url")
    private final String url;

    @b("version_code")
    private final int version_code;

    public OtaRemoteModel() {
        this(null, 0, null, 0L, null, null, 0L, null, null, null, null, null, 4095, null);
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.resource_url;
    }

    public final String component11() {
        return this.i18n;
    }

    public final String component12() {
        return this.dek_cipher;
    }

    public final int component2() {
        return this.version_code;
    }

    public final String component3() {
        return this.url;
    }

    public final long component4() {
        return this.file_size;
    }

    public final String component5() {
        return this.md5;
    }

    public final String component6() {
        return this.update_info;
    }

    public final long component7() {
        return this.update_time;
    }

    public final List<String> component8() {
        return this.abilities;
    }

    public final List<String> component9() {
        return this.dependencies;
    }

    public final OtaRemoteModel copy(String name, int i10, String url, long j10, String md5, String update_info, long j11, List<String> abilities, List<String> list, String resource_url, String i18n, String dek_cipher) {
        g.f(name, "name");
        g.f(url, "url");
        g.f(md5, "md5");
        g.f(update_info, "update_info");
        g.f(abilities, "abilities");
        g.f(resource_url, "resource_url");
        g.f(i18n, "i18n");
        g.f(dek_cipher, "dek_cipher");
        return new OtaRemoteModel(name, i10, url, j10, md5, update_info, j11, abilities, list, resource_url, i18n, dek_cipher);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OtaRemoteModel)) {
            return false;
        }
        OtaRemoteModel otaRemoteModel = (OtaRemoteModel) obj;
        return g.b(this.name, otaRemoteModel.name) && this.version_code == otaRemoteModel.version_code && g.b(this.url, otaRemoteModel.url) && this.file_size == otaRemoteModel.file_size && g.b(this.md5, otaRemoteModel.md5) && g.b(this.update_info, otaRemoteModel.update_info) && this.update_time == otaRemoteModel.update_time && g.b(this.abilities, otaRemoteModel.abilities) && g.b(this.dependencies, otaRemoteModel.dependencies) && g.b(this.resource_url, otaRemoteModel.resource_url) && g.b(this.i18n, otaRemoteModel.i18n) && g.b(this.dek_cipher, otaRemoteModel.dek_cipher);
    }

    public final List<String> getAbilities() {
        return this.abilities;
    }

    public final String getBaseModelName() {
        return q.K0(this.name, ".");
    }

    public final String getDek_cipher() {
        return this.dek_cipher;
    }

    public final List<String> getDependencies() {
        return this.dependencies;
    }

    public final long getFile_size() {
        return this.file_size;
    }

    public final String getI18n() {
        return this.i18n;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPluginName() {
        return isPlugin() ? q.G0(this.name, ".") : "";
    }

    public final String getResource_url() {
        return this.resource_url;
    }

    public final String getUpdate_info() {
        return this.update_info;
    }

    public final long getUpdate_time() {
        return this.update_time;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getVersion_code() {
        return this.version_code;
    }

    public int hashCode() {
        int iB = e.b(this.abilities, a.c(d.a(d.a(a.c(d.a(ai.onnxruntime.a.d(this.version_code, this.name.hashCode() * 31, 31), 31, this.url), this.file_size, 31), 31, this.md5), 31, this.update_info), this.update_time, 31), 31);
        List<String> list = this.dependencies;
        return this.dek_cipher.hashCode() + d.a(d.a((iB + (list == null ? 0 : list.hashCode())) * 31, 31, this.resource_url), 31, this.i18n);
    }

    public final boolean isPlugin() {
        return q.l0(this.name, ".", false);
    }

    public final String toDumpString() {
        String str = this.name;
        int i10 = this.version_code;
        long j10 = this.file_size;
        int length = this.dek_cipher.length();
        String str2 = this.url;
        StringBuilder sbF = e.f("name=", str, " ver=", i10, " size=");
        sbF.append(j10);
        sbF.append(" dekLen=");
        sbF.append(length);
        return ai.onnxruntime.a.o(sbF, " url=", str2);
    }

    public final String toFullDumpString() {
        String str = this.name;
        int i10 = this.version_code;
        long j10 = this.file_size;
        String str2 = this.md5;
        String str3 = this.url;
        String str4 = this.resource_url;
        long j11 = this.update_time;
        List<String> list = this.abilities;
        Object obj = this.dependencies;
        if (obj == null) {
            obj = EmptyList.f10001a;
        }
        String str5 = this.update_info;
        int length = this.i18n.length();
        int length2 = this.dek_cipher.length();
        StringBuilder sbF = e.f("model_id=", str, " version_code=", i10, " file_size=");
        ai.onnxruntime.a.u(j10, " md5=", str2, sbF);
        ai.onnxruntime.a.z(sbF, " url=", str3, " resourceUrl=", str4);
        a.s(j11, " update_time=", " abilities=", sbF);
        sbF.append(list);
        sbF.append(" dependencies=");
        sbF.append(obj);
        sbF.append(" update_info=");
        com.stepos.core.ota.d.o(length, str5, " i18nLen=", " dekLen=", sbF);
        sbF.append(length2);
        return sbF.toString();
    }

    public String toString() {
        String str = this.name;
        int i10 = this.version_code;
        String str2 = this.url;
        long j10 = this.file_size;
        String str3 = this.md5;
        String str4 = this.update_info;
        long j11 = this.update_time;
        List<String> list = this.abilities;
        List<String> list2 = this.dependencies;
        String str5 = this.resource_url;
        String str6 = this.i18n;
        String str7 = this.dek_cipher;
        StringBuilder sbF = e.f("OtaRemoteModel(name=", str, ", version_code=", i10, ", url=");
        com.stepos.core.ota.d.p(j10, str2, ", file_size=", sbF);
        ai.onnxruntime.a.z(sbF, ", md5=", str3, ", update_info=", str4);
        a.s(j11, ", update_time=", ", abilities=", sbF);
        sbF.append(list);
        sbF.append(", dependencies=");
        sbF.append(list2);
        sbF.append(", resource_url=");
        ai.onnxruntime.a.z(sbF, str5, ", i18n=", str6, ", dek_cipher=");
        return ai.onnxruntime.a.o(sbF, str7, ")");
    }

    public OtaRemoteModel(String name, int i10, String url, long j10, String md5, String update_info, long j11, List<String> abilities, List<String> list, String resource_url, String i18n, String dek_cipher) {
        g.f(name, "name");
        g.f(url, "url");
        g.f(md5, "md5");
        g.f(update_info, "update_info");
        g.f(abilities, "abilities");
        g.f(resource_url, "resource_url");
        g.f(i18n, "i18n");
        g.f(dek_cipher, "dek_cipher");
        this.name = name;
        this.version_code = i10;
        this.url = url;
        this.file_size = j10;
        this.md5 = md5;
        this.update_info = update_info;
        this.update_time = j11;
        this.abilities = abilities;
        this.dependencies = list;
        this.resource_url = resource_url;
        this.i18n = i18n;
        this.dek_cipher = dek_cipher;
    }

    public OtaRemoteModel(String str, int i10, String str2, long j10, String str3, String str4, long j11, List list, List list2, String str5, String str6, String str7, int i11, kotlin.jvm.internal.e eVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? 0L : j10, (i11 & 16) != 0 ? "" : str3, (i11 & 32) != 0 ? "" : str4, (i11 & 64) == 0 ? j11 : 0L, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? EmptyList.f10001a : list, (i11 & 256) != 0 ? null : list2, (i11 & VadSessionManager.FRAME_BYTES) != 0 ? "" : str5, (i11 & 1024) != 0 ? "" : str6, (i11 & 2048) != 0 ? "" : str7);
    }
}
