package com.byted.mgl.merge.service.api.privacy;

import com.byted.mgl.merge.service.api.privacy.audio.IPrivacyAudio;
import com.byted.mgl.merge.service.api.privacy.camera.IPrivacyCamera;
import com.byted.mgl.merge.service.api.privacy.clipboard.IPrivacyClipboard;
import com.byted.mgl.merge.service.api.privacy.device.IPrivacyDeviceInfo;
import com.byted.mgl.merge.service.api.privacy.installer.IPrivacyInstaller;
import com.byted.mgl.merge.service.api.privacy.location.IPrivacyLocation;
import com.byted.mgl.merge.service.api.privacy.media.IPrivacyMedia;
import com.byted.mgl.merge.service.api.privacy.permission.IPrivacyPermission;
import com.byted.mgl.merge.service.api.privacy.security.ISecurityBridgeControl;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes43.dex */
public interface IMglPrivacyService extends IBdpService {
    IPrivacyAudio getAudioDelegate();

    ISecurityBridgeControl getBridgeControlDelegate();

    IPrivacyCamera getCameraDelegate();

    IPrivacyClipboard getClipboardDelegate();

    IPrivacyDeviceInfo getDeviceInfoDelegate();

    IPrivacyInstaller getInstallerDelegate();

    IPrivacyLocation getLocationDelegate();

    IPrivacyMedia getMediaDelegate();

    IPrivacyPermission getPermissionDelegate();
}
