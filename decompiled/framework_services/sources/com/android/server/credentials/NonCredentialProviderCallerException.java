package com.android.server.credentials;

/* JADX INFO: loaded from: classes.dex */
public class NonCredentialProviderCallerException extends RuntimeException {
    private static final String MESSAGE = " is not an existing Credential Provider.";

    public NonCredentialProviderCallerException(String caller) {
        super(caller + MESSAGE);
    }
}
