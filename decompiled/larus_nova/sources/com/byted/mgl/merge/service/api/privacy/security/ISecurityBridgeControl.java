package com.byted.mgl.merge.service.api.privacy.security;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH&J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH&J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¨\u0006\r"}, d2 = {"Lcom/byted/mgl/merge/service/api/privacy/security/ISecurityBridgeControl;", "", "controlBridgeInvoke", "", "appId", "", "bridgeName", "path", "getFreeBridgeList", "", "getValidateBridgeList", "preMatchByAppId", "", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface ISecurityBridgeControl {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 18})
    public static final class DefaultImpls {
        public static /* synthetic */ void preMatchByAppId$default(ISecurityBridgeControl r100, String r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.preMatchByAppId(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preMatchByAppId");
        }

        public static /* synthetic */ boolean controlBridgeInvoke$default(ISecurityBridgeControl r100, String r101, String r102, String r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = null;
        L7:
            return r100.controlBridgeInvoke(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: controlBridgeInvoke");
        }
    }

    boolean controlBridgeInvoke(String r100, String r101, String r102);

    List<String> getFreeBridgeList();

    List<String> getValidateBridgeList();

    void preMatchByAppId(String r100, String r101);
}
