package com.autonavi.aps.protocol.aps.common.enums;

import com.amap.api.services.core.AMapException;

/* loaded from: classes.dex */
public enum Status {
    SUCCESS(0, "成功"),
    UNKNOWN_ERROR(1, AMapException.AMAP_CLIENT_UNKNOWN_ERROR),
    REQ_DEC_MSG_IS_NULL(101, "ApsMessage4Http空"),
    REQ_DEC_INTERRUPT_BY_EXCEPTION(102, "req解码过程中发生异常（字段未被全部解析，但已解析出来的仍可被使用）"),
    REQ_DEC_BIN_SIZE_ERROR(103, "req解码长度与预期不一致，但已解析出来的仍可被使用"),
    REQ_DEC_XXTEA_DECRYPT_ERROR(104, "req解码前解密错误"),
    REQ_DEC_UNGZIP_ERROR(105, "req解码前解压错误"),
    REQ_DEC_CRC_ERROR(106, "req解码前CRC错误"),
    REQ_DEC_INVALID_XML_CONTENT(107, "reqXml内容错误"),
    REQ_DEC_XML_DECRYPT_ERROR(108, "reqXml解密错误"),
    REQ_DEC_PARSE_CONTEXT_ERROR(109, "req解析Context失败，但其他字段解析成功"),
    REQ_DEC_INVALID_VERSION(110, "req解码时指定了无效的版本号"),
    REQ_ENC_SIZE_ERROR(201, "req编码长度与预期不一致"),
    REQ_ENC_ERROR(202, "req编码错误"),
    REQ_ENC_ENCRYPT_ERROR(203, "req编码后加密错误"),
    REQ_ENC_GZIP_ERROR(204, "req编码后压缩错误"),
    REQ_ENC_INVALID_VERSION(205, "req编码时指定了无效的版本号"),
    RES_ENC_OBJECT_EMPTY(301, "res对象或参数为空"),
    RES_ENC_FORMAT_TYPE_ERROR(302, "res响应结果的格式类型错误"),
    RES_ENC_ERROR(303, "res编码失败"),
    RES_ENC_ENCRYPT_ERROR(304, "res加密失败"),
    RES_ENC_FAILED_AND_RETURN_DEFAULT_MSG(305, "res编码失败，返回默认的失败msg"),
    RES_DEC_OBJECT_EMPTY(401, "res对象或参数为空"),
    RES_DEC_FORMAT_TYPE_ERROR(402, "res响应结果的格式类型错误"),
    RES_DEC_ERROR(403, "res解码失败"),
    RES_DEC_RGEO_PARSE_ERROR(404, "res逆地理解析失败"),
    RES_DEC_INDOOR_PARSE_ERROR(405, "res室内定位解析失败"),
    RES_DEC_CONTEXT_PARSE_ERROR(406, "res上下文信息解析失败");


    /* renamed from: a, reason: collision with root package name */
    private int f18527a;

    /* renamed from: b, reason: collision with root package name */
    private String f18528b;

    /* renamed from: c, reason: collision with root package name */
    private Throwable f18529c = null;

    Status(int i10, String str) {
        this.f18527a = i10;
        this.f18528b = str;
    }

    public int getCode() {
        return this.f18527a;
    }

    public String getDescription() {
        return this.f18528b;
    }

    public Throwable getThrowable() {
        return this.f18529c;
    }

    public Status setThrowable(Throwable th) {
        this.f18529c = th;
        return this;
    }
}
