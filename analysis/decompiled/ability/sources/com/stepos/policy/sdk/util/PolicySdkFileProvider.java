package com.stepos.policy.sdk.util;

import androidx.core.content.FileProvider;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public class PolicySdkFileProvider extends FileProvider {
    public PolicySdkFileProvider() {
        super(R.xml.policy_sdk_file_paths);
    }
}
