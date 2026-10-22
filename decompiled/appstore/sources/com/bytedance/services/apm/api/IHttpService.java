package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import i6.c;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IHttpService extends IService {
    IMultipartUploader buildMultipartUpload(String r10, String r11, boolean r12) throws Exception;

    IMultipartUploader buildMultipartUpload(String r10, String r11, boolean r12, Map<String, String> r13) throws Exception;

    c doGet(String r10, Map<String, String> r11) throws Exception;

    c doPost(String r10, byte[] r11, Map<String, String> r12) throws Exception;

    c uploadFiles(String r10, List<File> r11, Map<String, String> r12) throws Exception;
}
